package id.my.hendisantika.springbootgeneratepdf2.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import id.my.hendisantika.springbootgeneratepdf2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/17/24
 * Time: 07:03
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component("pdfGenerator")
@RequiredArgsConstructor
public class PDFGenerator {

    private final EmployeeRepository employeeRepository;
    @Value("${pdfDir}")
    private String pdfDir;
    @Value("${reportFileName}")
    private String reportFileName;
    @Value("${reportFileNameDateFormat}")
    private String reportFileNameDateFormat;
    @Value("${localDateFormat}")
    private String localDateFormat;
    @Value("${logoImgPath}")
    private String logoImgPath;
    @Value("${logoImgScale}")
    private Float[] logoImgScale;
    @Value("${currencySymbol:}")
    private String currencySymbol;
    @Value("${table_noOfColumns}")
    private int noOfColumns;
    @Value("${table.columnNames}")
    private List<String> columnNames;

    private static final Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
    private static final Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static final Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

    public void generatePdfReport() {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate()));
            document.open();
            addLogo(document);
            addDocTitle(document);
            createTable(document, noOfColumns);
            addFooter(document);
            document.close();
            log.info("------------------Your PDF Report is ready!-------------------------");

        } catch (FileNotFoundException | DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void addLogo(Document document) {
        try {
            Image img = Image.getInstance(logoImgPath);
            img.scalePercent(logoImgScale[0], logoImgScale[1]);
            img.setAlignment(Element.ALIGN_RIGHT);
            document.add(img);
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

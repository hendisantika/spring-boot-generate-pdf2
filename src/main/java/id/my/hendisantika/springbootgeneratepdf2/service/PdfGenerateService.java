package id.my.hendisantika.springbootgeneratepdf2.service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/17/24
 * Time: 06:35
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PdfGenerateService {
    private final TemplateEngine templateEngine;

//    @Value("${pdf.directory}")
//    private String pdfDirectory;

    public void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName) {
        Context context = new Context();
        context.setVariables(data);

        String htmlContent = templateEngine.process(templateName, context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/output/" + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
            log.info(System.getProperty("user.dir"));
            log.info("PDF Generated successfully ... ");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (DocumentException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void export(HttpServletResponse httpServletResponse) throws IOException, DocumentException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.COURIER_BOLD);
        fontTitle.setSize(16);
        fontTitle.setColor(108, 142, 163);

        Paragraph paragraph = new Paragraph("Generate a PDF Using Spring Boot", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        fontParagraph.setColor(153, 153, 255);

        Paragraph headingPara = new Paragraph("This is Heading for a Paragraph.", fontParagraph);
        headingPara.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(headingPara);

        document.close();

    }
}

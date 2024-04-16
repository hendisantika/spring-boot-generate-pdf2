package id.my.hendisantika.springbootgeneratepdf2.service;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    @Value("${pdf.directory}")
    private String pdfDirectory;

    public void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName) {
        Context context = new Context();
        context.setVariables(data);

        String htmlContent = templateEngine.process(templateName, context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfDirectory + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (DocumentException e) {
            log.error(e.getMessage(), e);
        }
    }
}

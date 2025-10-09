package id.my.hendisantika.springbootgeneratepdf2.controller;

import com.lowagie.text.DocumentException;
import id.my.hendisantika.springbootgeneratepdf2.service.PdfGenerateService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/08/24
 * Time: 06.45
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class PDFExportController {
    public final PdfGenerateService pdfGeneratorService;

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        this.pdfGeneratorService.export(response);
    }
}

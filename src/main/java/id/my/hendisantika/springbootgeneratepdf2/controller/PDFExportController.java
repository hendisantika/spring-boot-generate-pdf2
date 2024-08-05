package id.my.hendisantika.springbootgeneratepdf2.controller;

import id.my.hendisantika.springbootgeneratepdf2.service.PdfGenerateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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

}

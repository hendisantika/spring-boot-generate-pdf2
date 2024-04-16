package id.my.hendisantika.springbootgeneratepdf2;

import id.my.hendisantika.springbootgeneratepdf2.service.PdfGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/17/24
 * Time: 06:38
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PdfGeneratorRunner implements CommandLineRunner {

    @Autowired
    private PdfGenerateService pdfGenerateService;

}

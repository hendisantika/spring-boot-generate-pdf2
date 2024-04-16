package id.my.hendisantika.springbootgeneratepdf2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/17/24
 * Time: 06:37
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class ThymeleafConfiguration {

    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver() {
        ClassLoaderTemplateResolver pdfTemplateResolver = new ClassLoaderTemplateResolver();
        pdfTemplateResolver.setPrefix("pdf-templates/");
        pdfTemplateResolver.setSuffix(".html");
        pdfTemplateResolver.setTemplateMode("HTML");
        pdfTemplateResolver.setCharacterEncoding("UTF-8");
        pdfTemplateResolver.setOrder(1);
        return pdfTemplateResolver;
    }
}

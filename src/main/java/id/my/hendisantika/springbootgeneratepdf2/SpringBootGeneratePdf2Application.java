package id.my.hendisantika.springbootgeneratepdf2;

import id.my.hendisantika.springbootgeneratepdf2.util.PDFGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootGeneratePdf2Application {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootGeneratePdf2Application.class, args);
        ApplicationContext ac = SpringApplication.run(SpringBootGeneratePdf2Application.class, args);

        PDFGenerator pDFGenerator = ac.getBean("pdfGenerator", PDFGenerator.class);

        pDFGenerator.generatePdfReport();
    }

}

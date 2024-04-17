package id.my.hendisantika.springbootgeneratepdf2.util;

import id.my.hendisantika.springbootgeneratepdf2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
}

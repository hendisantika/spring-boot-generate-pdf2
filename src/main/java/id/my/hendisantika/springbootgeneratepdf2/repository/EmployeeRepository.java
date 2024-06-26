package id.my.hendisantika.springbootgeneratepdf2.repository;

import id.my.hendisantika.springbootgeneratepdf2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/17/24
 * Time: 07:01
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee e")
    List<Employee> getAllEmployeeData();
}

package com.cg.repo;

import com.cg.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
       //findBy --> JPA repo keyword + Name= attribute of employee class (always write like this)
       //public List<Employee> findByName(String name);

                               //OR
       //if function name is different --> write Query
       @Query("select e from Employee e where e.name=:n")
       public List<Employee> findByNa(@Param("n") String name);

       public List<Employee> findBySalaryLessThan(int sal);
       public List<Employee> findByNameAndSalary(String name, int salary);

       public List<Employee> findByDobBetween(LocalDate st, LocalDate end);

}

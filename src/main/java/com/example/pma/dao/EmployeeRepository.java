package com.example.pma.dao;

import com.example.pma.dataTransferObject.EmployeeProject;
import com.example.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, " +
            "COUNT(pe.employee_id) as projectCount FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY projectCount DESC"
    )
    public List<EmployeeProject> employeeProjects();
}

package com.bikkadit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
public Employee findByEmpIDAndEmpName(Integer id,String name);
}

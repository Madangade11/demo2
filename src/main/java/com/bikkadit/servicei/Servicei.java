package com.bikkadit.servicei;

import java.util.List;

import com.bikkadit.model.Employee;

public interface Servicei {
public Employee AddEmp(Employee employee);
public List <Employee>addAllemp(List<Employee>employee);

public Employee getById(Integer id);

public List<Employee>getAllEmp();
public Employee updateEmp(Employee employee);

public List<Employee>upadateAllEmp(List<Employee>id);

public Employee findByEmpIdAndEmpName(Integer id,String name);

public String deleteById(Integer id);

public String deleteAll();


	
}


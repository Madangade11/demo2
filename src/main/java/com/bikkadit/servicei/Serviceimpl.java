package com.bikkadit.servicei;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bikkadit.model.Employee;
import com.bikkadit.repository.EmployeeRepository;

@Service
public class Serviceimpl implements Servicei {
	@Autowired
 private EmployeeRepository employeeRepository;
	@Override
	public Employee AddEmp(Employee employee) {
		
		Employee save = employeeRepository.save(employee);
				return save;
	}
	@Override
	public List<Employee> addAllemp(List<Employee> employee) {
		List<Employee> saveAll = employeeRepository.saveAll(employee);
		for(Employee emp:saveAll) {
			System.out.println(emp);
		}
		
			return saveAll;
	}
	@Override
	public Employee getById(Integer id) {
		Employee employee = employeeRepository.findById(id).get();
		
		
		
				return employee;
	}
	@Override
	public List<Employee> getAllEmp() {
		List<Employee> findAll = employeeRepository.findAll();
		
		for(Employee emp:findAll) {
			System.out.println(emp);
		}
		
		return findAll;
	}
	@Override
	public Employee updateEmp(Employee employee) {
		
		Employee save = employeeRepository.save(employee);
				return save;
	}
	@Override
	public List<Employee> upadateAllEmp(List<Employee> employee) {
		
	
		List<Employee> saveAll = employeeRepository.saveAll(employee);	
		
		return saveAll;
	}
	@Override
	public Employee findByEmpIdAndEmpName(Integer id, String name) {
		Employee findByEmployeeIdAndAmployeeName = employeeRepository.findByEmpIDAndEmpName(id, name);
		return findByEmployeeIdAndAmployeeName;
	}
	@Override
	public String deleteById(Integer id) {
		employeeRepository.deleteById(id);
		return "data deleted successfully";
	}
	@Override
	public String deleteAll() {
		employeeRepository.deleteAll();
				return "deleted successfully";
	}

}

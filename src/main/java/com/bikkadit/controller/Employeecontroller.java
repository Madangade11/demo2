package com.bikkadit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.model.Employee;
import com.bikkadit.repository.EmployeeRepository;
import com.bikkadit.servicei.Servicei;
import com.bikkadit.servicei.Serviceimpl;

@RestController
public class Employeecontroller {
	@Autowired
	private Serviceimpl serviceimpl;
	@PostMapping(value="/saveEmp",produces= "application/json",consumes = "application/json")
	public ResponseEntity<Employee>saveEmpData(@RequestBody Employee emp) {
		
		Employee addEmployee = serviceimpl.AddEmp(emp);
		System.out.println(addEmployee);
		return new ResponseEntity<Employee>(addEmployee,HttpStatus.CREATED);
	}
	
	
	@PostMapping(value="/saveAppEmployee",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<Employee>>saveAllEmployedata(@RequestBody List<Employee>employee) {
		List<Employee> addmultipleemployee = serviceimpl.addAllemp(employee);
		System.out.println(addmultipleemployee);
		
		return new ResponseEntity<List<Employee>>(addmultipleemployee,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getId/{id}",produces = "application/json")
	public ResponseEntity<Employee>getByEmployeeId(@PathVariable Integer id) {
		Employee byId = serviceimpl.getById(id);
		return new ResponseEntity<Employee>(byId,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getallemployee")
public ResponseEntity <List<Employee>>getAllEmployee(){
	List<Employee> allEmployee = serviceimpl.getAllEmp();
	
	
	return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
	
	}
	
	@GetMapping(value = "/login/{id}/{name}",produces ="application/json")
public ResponseEntity<String>loginCheck(@PathVariable Integer id,@PathVariable String name){
Employee findByEmpIdAndEmpName = serviceimpl.findByEmpIdAndEmpName(id, name);
	

	if(findByEmpIdAndEmpName ==null) {
		return new ResponseEntity<String>("Invaild data",HttpStatus.NOT_FOUND);
	
}
return new ResponseEntity<String>("login successfully",HttpStatus.OK);

	}
@PutMapping(value="/updateemployee",produces = "application/json",consumes = "application/json")
public ResponseEntity<String>updateEmployee(@RequestBody Employee emp){
Employee updateEmp = serviceimpl.updateEmp(emp);

return new ResponseEntity<String>(updateEmp.getEmpId()+"data update successfully",HttpStatus.OK);

}
@PutMapping(value ="/updateAllemployee",produces = "application/json",consumes = "application/json")
public ResponseEntity<String>updateAppEmployee(@RequestBody List<Employee>employee){
	List<Employee> upadateAllEmployee = serviceimpl.upadateAllEmp(employee);
	return new ResponseEntity<String>("All Data updated successfully",HttpStatus.OK);
}
@DeleteMapping(value="/delete/{id}",consumes = "application/json")
public  ResponseEntity<String>deleteById(@PathVariable Integer id){
	String deleteById = serviceimpl.deleteById(id);
	return new ResponseEntity<String>(id+"Id deleted succssfully",HttpStatus.OK);
}
@DeleteMapping(value ="/deleteAll",consumes = "application/json")
	public ResponseEntity<String>deleteAll(){
	
	String deleteAll = serviceimpl.deleteAll();
		return new ResponseEntity<String>("All data deleted succssfully",HttpStatus.OK);
		

}

}

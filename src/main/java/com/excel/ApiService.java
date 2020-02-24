package com.excel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ApiService {
	
	public List<Employee> getData(){
		List<Employee> emps =new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("rishu");
		emps.add(emp);
		return emps;
	}

}

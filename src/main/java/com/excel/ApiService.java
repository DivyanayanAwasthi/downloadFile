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
		Employee emp1 = new Employee();
		emp1.setEmployeeId(1);
		emp1.setEmployeeName("sangavi");
		emps.add(emp1);
		return emps;
	}

}

package com.Bean;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyEmployee {
	private int Empid;
	private String EmpName;
	private int salary;
	private String date;
	private String location;

	public int getEmpid() {
		return Empid;
	}

	public void setEmpid(int empid) {
		Empid = empid;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//For validating Strings which contains only Character value.
		public boolean validateName(String EmpName) 
		{
			String regex= "^[A-Z][A-Za-z]+";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(EmpName);
			return m.matches();
						
		}

}

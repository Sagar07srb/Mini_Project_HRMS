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
	private String mobile;
	private String email;
	private String role;

	Scanner sc = new Scanner(System.in);

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
		this.EmpName = empName;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// For validating Strings which contains only Character value.
	public boolean validateName(String EmpName) {
		String regex = "^[A-Z][A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(EmpName);
		return m.matches();
	}

	public void checkFname() {
		
		System.out.println("Enter First name:");
		String name = sc.next();
		if (this.validateName(name))
			this.EmpName = name;
		else {
			System.out.println("Invalid");
			checkFname();
		}

	}

	public void setEmp() {
		System.out.println("Enter empid:");
		this.Empid = sc.nextInt();

		this.checkFname();

		System.out.println("Enter salay:");
		this.salary = sc.nextInt();

		System.out.println("Enter Date:");
		this.date = sc.next();

		System.out.println("Enter Location:");
		this.location = sc.next();

		this.checkPhoneNo();

		this.checkEmail();

		System.out.println("Enter Role:");
		this.role = sc.next();

	}

	public boolean phoneValidation(String no) {
		Pattern p = Pattern.compile("[7-9][0-9]{9}");
		Matcher m = p.matcher(no);

		return (m.find() && m.group().equals(no));

	}

	// Check for phone number is valid and set the value
	public void checkPhoneNo() {
		System.out.println("Enter Phone number:");
		String no = sc.next();
		if (this.phoneValidation(no))
			this.mobile = no;
		else
			checkPhoneNo();
	}

	public boolean emailValidation(String email) {
		Pattern p = Pattern.compile("^(.+)@(.+)com");
		Matcher m = p.matcher(email);

		return (m.matches());
	}

	public void checkEmail() {
		System.out.println("Enter email id:");
		String emailId = sc.next();
		if (this.emailValidation(emailId))
			this.email = emailId;
		else {
			System.out.println("Enterd value is invalid");
			checkEmail();
		}
	}
}

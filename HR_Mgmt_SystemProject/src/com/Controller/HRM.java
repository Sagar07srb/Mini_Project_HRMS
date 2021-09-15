package com.Controller;

import java.util.*;
import com.DAO.DAOclass;

public class HRM {

	String a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DAOclass dc1 = new DAOclass();
		dc1.myConn();
		String a;

		do {
			System.out.println(" ******* Welcome To HR Management System ******");
			System.out.println("1.Add employee");
			System.out.println("2.Delete Employee");
			System.out.println("3.Update Employee Details");
			System.out.println("4.Search Employee by name/id/department");

			System.out.println("5.Show list of employees for given department");
			System.out.println("6.Department wise employee count");
			Scanner s = new Scanner(System.in);
			System.out.println("enter your choice::");
			int ch = s.nextInt();
			
			switch (ch) {
			case 1:
				dc1.addEmployee();
				break;

			case 2:
				dc1.myDelete();
				break;
			case 3:
				dc1.myUpdate();
				break;
			case 4:
				dc1.mySearch();
				break;

			case 5:
				dc1.listofEmp();
				break;

			case 6:
				dc1.countdeptWise();
				break;
			}
			System.out.println("do you want to continue.....enter yes/no");
			a = sc.nextLine();
			
		} while (a.equals("yes"));
		
	}
	
}
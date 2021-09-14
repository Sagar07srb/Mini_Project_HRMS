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

			Scanner keyboard = new Scanner(System.in);
			System.out.println("enter your choice::");
			int ch = keyboard.nextInt();

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
			}
			System.out.println("do you want to continue.....enter y/n");
			a = sc.nextLine();
		} while (a.equals("yes"));
	}
}
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Bean.MyEmployee;

public class DAOclass {
	public static Connection c = null;
	ResultSet rs = null;
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/hrm";

	public Scanner sc = new Scanner(System.in);

	public void addEmployee() {
		String sql = "insert into employee(eid,ename,salary,join_date,Location,mobile,email,role) values(?,?,?,?,?,?,?,?)";

		MyEmployee me = new MyEmployee();

		me.setEmp();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, me.getEmpid());
			ps.setString(2, me.getEmpName());
			ps.setInt(3, me.getSalary());
			ps.setString(4, me.getDate());
			ps.setString(5, me.getLocation());
			ps.setString(6, me.getMobile());
			ps.setString(7, me.getEmail());
			ps.setString(8, me.getRole());
			ps.execute();
			System.out.println("Data added successfully.....");
		} catch (SQLException e) {

			System.out.println("Plz add sufficient data.....");
			e.printStackTrace();
		}

	}

	public void mySearch() {
		String sql2 = "select * from employee where eid=?";

		System.out.println("enter eid:");
		int eid = sc.nextInt();

		try {
			PreparedStatement ps = c.prepareStatement(sql2);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println("id::" + rs.getInt(1));
				System.out.println(("name::" + rs.getString(2)));
				System.out.println(("salary::" + rs.getInt(3)));
				System.out.println("join_date::" + rs.getString(4));
				System.out.println("location::" + rs.getString(5));
				System.out.println("mobile::" + rs.getString(7));
				System.out.println("email::" + rs.getString(8));
				System.out.println("Role::" + rs.getString(9));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void myDelete() {
		String sql1 = "delete from employee where eid=?";

		System.out.println("enter eid");
		int eid = sc.nextInt();

		try {
			PreparedStatement ps = c.prepareStatement(sql1);
			ps.setInt(1, eid);
			ps.execute();
			System.out.println("Row deleted....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void myUpdate() {
		String sql3 = "update employee set ename=?,location=? where eid=?";
		System.out.println("enter name");
		String empname = sc.next();
		System.out.println("enter location");
		String location = sc.next();
		System.out.println("enter eid");
		int empid = sc.nextInt();

		try {
			PreparedStatement ps = c.prepareStatement(sql3);
			ps.setInt(3, empid);
			ps.setString(1, empname);
			ps.setString(2, location);

			ps.execute();
			System.out.println("Updated Successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listofEmp() {
		String sql7 = "select ename,deptname from employee e inner join department d on e.deptid=d.deptid where d.deptid=?";
		try {
			PreparedStatement ps = c.prepareStatement(sql7);
			System.out.println("enter deptid:");
			ps.setInt(1, sc.nextInt());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("ename") + "\t" + rs.getString("deptname"));
			}
			System.out.println("Employee List.....");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void countdeptWise() {
		String sql4 = "SELECT deptname, COUNT(*) FROM department INNER JOIN employee ON employee.deptid = department.deptid GROUP BY deptname";
		try {
			PreparedStatement ps = c.prepareStatement(sql4);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("deptname"));
				System.out.println(rs.getInt(2));
			}
			System.out.println("Counted.....");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void myConn() {

		try {

			System.out.println("Enter username:");
			String username = sc.nextLine();

			System.out.println("Enter password:");
			String password = sc.nextLine();

			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);

			System.out.println("Successfully Login...Now You Can Perform Following Tasks!!!!! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void myClose() {
		try {
			c.close();
			System.out.println("connection closed...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

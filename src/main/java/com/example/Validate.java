package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email, String pass) {
		boolean st = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/students","admin","Password@123");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return st;	
	}
}
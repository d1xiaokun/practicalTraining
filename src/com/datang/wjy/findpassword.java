package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class findpassword {
	public void findpassword(){
		System.out.println("======��ӭ�һ��������======");
		 System.out.println("������Ҫ�һص��ֻ��ţ�");
		 Scanner userInput =new Scanner(System.in);
		User user=new User();  
		user.setPhone(userInput.nextLine().trim());   
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superone","root","root");

			 String sql = "update user set password=5201314 where "+user.getPhone()+""; 
			 PreparedStatement ps=con.prepareStatement(sql);
			 int res=ps.executeUpdate(sql);
			 System.out.println("�һ�����ɹ���");
			login login=new login();
			login.login();
	         con.close();
	       } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	


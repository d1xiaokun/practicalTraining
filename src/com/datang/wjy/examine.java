package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

public class examine {
	public void examine(){
		System.out.println("��ӭ����鿴���ｻ����Ϣ����");
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superone","root","root");
         Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from jyxx");
         while(rs.next()){
        	 System.out.print(rs.getString("jyjf")+"\t");	
        	 System.out.print(rs.getString("jyyf")+"\t");	
        	 System.out.print(rs.getString("ddnumber")+"\t");	
        	 System.out.println("\t");
         }System.out.println("\t");
		// String sql = "delete from jyxx where ddnumber="+deal.getDdnumber()+"";  
		 //PreparedStatement ps=con.prepareStatement(sql);
		 //int res=ps.executeUpdate(sql);
		 System.out.println("�鿴�ɹ���");
		 pet pet=new pet();
		 pet.pet();
        con.close();
      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

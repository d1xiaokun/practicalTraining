package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class inquire {
	public void inquire(){
		
		System.out.println("��ӭ�����ѯ����");
		 System.out.println("������Ҫ��ѯ�����ţ�");
		 Scanner userInput =new Scanner(System.in);
		 deal deal=new deal();
		 deal.setDdnumber(userInput.nextLine().trim());
		 try {
				
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cwglxt","wjy","root");
			 String sqlStr1="select jyjf,jyyf,ddnumber from jyxx where ddnumber="+deal.getDdnumber()+"";//Ҫִ�е�SQL
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery(sqlStr1); //ִ�в�ѯ
             System.out.println("�׷�\t"+"�ҷ�\t"+"������\t");
             while(rs.next()){
            	 System.out.printf(rs.getString(1)+"\t");
            	 System.out.printf(rs.getString(2)+"\t");
            	 System.out.printf(rs.getString(3)+"\t");
            	 System.out.println();
             }
             System.out.println("��ѯ�ɹ���");
             pet pet=new pet();
             pet.pet();
	       con.close();
	        } catch (Exception e) {
			 	// TODO Auto-generated catch block
			  e.printStackTrace();
			}
	}
		
}

	            

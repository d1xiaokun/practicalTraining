package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
	public void delete(){
		 System.out.println("��ӭ����ɾ������");
		 System.out.println("������Ҫɾ�������ţ�");
		 Scanner userInput =new Scanner(System.in);
		 deal deal=new deal();
		 deal.setDdnumber(userInput.nextLine().trim());
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cwglxt","wjy","root");

		 String sql = "delete from jyxx where ddnumber="+deal.getDdnumber()+"";  
		 PreparedStatement ps=con.prepareStatement(sql);
		 int res=ps.executeUpdate(sql);
		 System.out.println("ɾ���ɹ���");
		 pet pet=new pet();
		 pet.pet();
         con.close();
       } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

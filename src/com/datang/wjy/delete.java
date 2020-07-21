package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
	public void delete(){
		 System.out.println("欢迎进入删除界面");
		 System.out.println("请输入要删除订单号：");
		 Scanner userInput =new Scanner(System.in);
		 deal deal=new deal();
		 deal.setDdnumber(userInput.nextLine().trim());
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cwglxt","wjy","root");

		 String sql = "delete from jyxx where ddnumber="+deal.getDdnumber()+"";  
		 PreparedStatement ps=con.prepareStatement(sql);
		 int res=ps.executeUpdate(sql);
		 System.out.println("删除成功！");
		 pet pet=new pet();
		 pet.pet();
         con.close();
       } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.datang.model.User;
public class inquire {
	public void inquire() throws Exception{
		Scanner input = new Scanner(System.in);
		User user = new User();
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql1 = "select * from jyxx ";
		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		
		// 6.ִ��sql���
		ResultSet eq1 = ps1.executeQuery();
		System.out.println("======��ӭ�����ѯ����======");
		System.out.println("��������Ҫ���ҵĶ�����:");
        user.setNumber(input.nextLine().trim());
        String sql2 = "select * from jyxx where ddnumber=?";
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
        ps2.setString(1,user.getNumber());
        ResultSet eq2 = ps2.executeQuery();
       if(eq2.next()){
	   System.out.println("�׷�\t�ҷ�\t������\t");
	    System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)
			+ "\t" + eq2.getString(3) + "\t" );
       System.out.println("�������ⷵ��");
	   new Scanner(System.in).nextLine();
	   pet.pet();
     }
      System.err.println("���ݿ����޴��û�,�뷵������");
      new Scanner(System.in).nextLine();
      pet.pet();
	            
}
}


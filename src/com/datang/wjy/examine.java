package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

import com.datang.model.User;

public class examine {
	public void examine() throws Exception{
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
		System.out.println("======��ӭ����鿴���ｻ�׽���======");
		System.out.println("��������Ҫ�鿴�ļ׷�:");
        user.setNumber(input.nextLine().trim());
        String sql2 = "select * from jyxx where jyjf=?";
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
        ps2.setString(1,user.getNumber());
        ResultSet eq2 = ps2.executeQuery();
        if(eq1.next()){
        	System.out.println("��ʾ���м׷�����");
       while(eq2.next()){
	   System.out.println("�׷�\t�ҷ�\t������\t");
	    System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)
			+ "\t" + eq2.getString(3) + "\t" );      
	  
       }
       System.out.println("�������ⷵ��");
	   new Scanner(System.in).nextLine();// ͣ��һ��
       pet.pet();
       }else{
      System.err.println("���ݿ����޴˽�����Ϣ,�뷵������");
      new Scanner(System.in).nextLine();// ͣ��һ��
      examine();}
	}
}

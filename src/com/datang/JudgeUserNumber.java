package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class JudgeUserNumber {
 public String judgeUserNumber() throws Exception{
	 Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// ����sql���
		String select = "select * from user where yonghu=?";
		// ��ȡ��ȡsql���Ķ���
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		User user = new User();
		Scanner input = new Scanner(System.in);
//		Admin admin = new Admin();
//		Scanner input = new Scanner(System.in);
		
		
		System.out.println("1��������ӵ��û��˺�(6-16λ):");
		user.setNumber(input.nextLine().trim());
		
//		admin.setAcc_number(input.nextLine().trim());
//		System.out.println(admin.getAcc_number()+" 1");
//ִ��sql���
		ps1.setString(1, user.getNumber());
		//ps1.setString(1, admin.getAcc_number());
		ResultSet eq = ps1.executeQuery();
		if(eq.next()){// ���ж��Ƿ��˺��Ƿ�ע��
			//while (eq.getString(2).equals(admin.getAcc_number())) {
				System.out.println("2��Ǹ,��������˺��ѱ�ע��!����������!");
				
				//System.out.println(admin.getAcc_number()+" 2");
				return judgeUserNumber();
			//}
		}
/*
* ��������
*/
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());
		
		if (returnunum == 0) {
			System.out.println("3��������˺�Ϊ��,����������!");
			//System.out.println(admin.getAcc_number()+" 3 ");
			return judgeUserNumber();

		} else if (returnunum == 1) {
			System.out.println("6��������˺Ų�����6-16λ,����������!");
			//System.out.println(admin.getAcc_number()+" 4");
			return judgeUserNumber();
		}else {
			return user.getNumber();
		}
 }
}

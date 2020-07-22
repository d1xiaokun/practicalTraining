package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class JudgeUserNumber {
	public String judgeUserNumber() throws Exception {
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
		System.out.println("��������ӵ��û��˺�(6-16λ):");
		user.setNumber(input.nextLine().trim());
		// ִ��sql���
		ps1.setString(1, user.getNumber());
		ResultSet eq = ps1.executeQuery();
		if (eq.next()) {// ���ж��Ƿ��˺��Ƿ�ע��
			System.err.println("��Ǹ,��������˺��ѱ�ע��!����������!");
			return judgeUserNumber();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());
		if (returnunum == 0) {
			System.err.println("��������˺�Ϊ��,����������!");
			return judgeUserNumber();
		} else if (returnunum == 1) {
			System.err.println("��������˺Ų�����6-16λ,����������!");
			return judgeUserNumber();
		} else {
			return user.getNumber();
		}
	}
}

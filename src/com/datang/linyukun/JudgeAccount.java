package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.Admin;
import com.mysql.jdbc.PreparedStatement;

class JudgeAccount {

	public String judgeAccount() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// ����sql���
		String select = "select * from admin where acc_number=?";
		// ��ȡ��ȡsql���Ķ���
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		Admin admin = new Admin();
		Scanner input = new Scanner(System.in);
		System.out.println("��������ӵĹ���Ա�˺�(6-16λ):");// ����֤����Ա�˺��Ƿ����ݿ��д�����executeQuery()�������ݿ���������˺���Ϣ,
													// Ȼ����ѭ����������˺���ƥ��,���û��һ�����˺ž��ܲ�����Ϣ�����ݿ�,�������������˺�
		admin.setAcc_number(input.nextLine().trim());
		// ִ��sql���
		ps1.setString(1, admin.getAcc_number());
		ResultSet eq = ps1.executeQuery();
		if (eq.next()) {// ���ж��Ƿ��˺��Ƿ�ע��
			System.err.println("��Ǹ,��������˺��ѱ�ע��!����������!");
			return judgeAccount();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnadnum = verifyNumber.verifyNumber(admin.getAcc_number());
		if (returnadnum == 0) {
			System.err.println("��������˺�Ϊ��,����������!");
			// System.out.println(admin.getAcc_number()+" 3 ");
			return judgeAccount();
		} else if (returnadnum == 1) {
			System.err.println("��������˺Ų�����6-16λ,����������!");
			// System.out.println(admin.getAcc_number()+" 4");
			return judgeAccount();
		} else {
			return admin.getAcc_number();
		}
	}
}

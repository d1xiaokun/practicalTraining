package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class DeleteUser {
	public static void main(String[] args) throws Exception{
		deleteuser();
	}
	public static void deleteuser() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// ����sql���
		String select = "select * from user where yonghu=?";
		String sql = "delete from user where yonghu=?";
		// ��ȡ��ȡsql���Ķ���
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
		PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);
		User user = new User();
		Scanner input = new Scanner(System.in);
		// Admin admin = new Admin();
		// Scanner input = new Scanner(System.in);

		System.out.println("1������Ҫɾ�����û��˺�(6-16λ):");
		user.setNumber(input.nextLine().trim());

		// admin.setAcc_number(input.nextLine().trim());
		// System.out.println(admin.getAcc_number()+" 1");
		// ִ��sql���
		ps1.setString(1, user.getNumber());
		ResultSet eq = ps1.executeQuery();
		while (eq.next()) {// ���ж��Ƿ��˺��Ƿ�ע��
			System.out.println("���ҵ����û���Ϣ!\n" + "�û���\t�ֻ���\t\t����\t\t\tע��ʱ��");
			System.out.println(eq.getString(1) + "\t" + eq.getString(2)
						+ "\t" + eq.getString(3) + "\t\t" + eq.getString(4));
			while (true) {
				
				
				System.out.println("�Ƿ�ɾ��?");
				String affirm = input.nextLine().trim();
				if (affirm.equals("y") || affirm.equals("Y")) {
					ps2.setString(1, user.getNumber());
					int res = ps2.executeUpdate();
					// 7.�鿴���ؽ����
					if (res != 0) {
						System.out.println("ɾ���ɹ�!");
						System.out.println("���ڷ�����һ��");
						ManageUsers.manageUsers();
					} else {
						System.err.println("ɾ��ʧ��!���ڷ���....");
						deleteuser();
					}
				} else if (affirm.equals("N") || affirm.equals("n")) {
					
					System.out.println("���Ƿ����ִ��ɾ������?����y������,�������ⷵ����һ��");
					String reaffirm = input.nextLine().trim();
					if (reaffirm.equals("y")||reaffirm.equals("Y")) {
						System.out.println("���ڷ��ز���..");
						deleteuser();
					}else {
						ManageUsers.manageUsers();
					}
					
				} else {
					System.err.println("�������ѡ���,����������!");

				}

			}
		}
		if (!eq.next()) {
			System.err.println("��������û�������!����������!");
			deleteuser();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());

		if (returnunum == 0) {
			System.out.println("3��������˺�Ϊ��,����������!");
			// System.out.println(admin.getAcc_number()+" 3 ");
			// return judgeUserNumber();
			deleteuser();

		}  else {
			// return user.getNumber();
		}
	}

}
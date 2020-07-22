package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.TS;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class UserRegister {
	public void userRegister() throws Exception {

		// 2.ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql = "INSERT INTO user(yonghu,phone,password)VALUE(?,?,?);";
		// 5.��ȡsql���Ķ���
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		User user = new User();
		Scanner input = new Scanner(System.in);
		JudgeUserNumber jun = new JudgeUserNumber();
		String Number = jun.judgeUserNumber();
		// ����ע����֤���ݲ���
		System.out.println("��������ӵ��û�����(6-16λ):");
		// admin.setAcc_pwd(input.nextLine().trim());
		user.setPassword(input.nextLine().trim());
		VerifyPwd verifyPwd = new VerifyPwd();
		int returnPwd = verifyPwd.verifyPwd(user.getPassword());
		while (returnPwd == 0 || returnPwd == 1) {
			if (returnPwd == 0) {
				System.err.println("�����������Ϊ��,����������!");
				// admin.setAcc_pwd(input.nextLine().trim());
				user.setPassword(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(user.getPassword());
			} else if (returnPwd == 1) {
				System.err.println("����������벻����6-16λ,����������!");
				// admin.setAcc_pwd(input.nextLine().trim());
				user.setPassword(input.nextLine().trim());
				// returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				returnPwd = verifyPwd.verifyPwd(user.getPassword());
			}
		}
		System.out.println("��������һ��Ҫ��ӵ��û�����:");
		String verifyConfirm = input.nextLine().trim();
		while (!user.getPassword().equals(verifyConfirm)) {
			System.err.println("������������벻һ��,�����������һ������!");
			user.setPassword(input.nextLine().trim());
			verifyPwd = new VerifyPwd();
			returnPwd = verifyPwd.verifyPwd(user.getPassword());
			while (returnPwd == 0 || returnPwd == 1) {
				if (returnPwd == 0) {
					System.err.println("�����������Ϊ��,����������!");
					// admin.setAcc_pwd(input.nextLine().trim());
					user.setPassword(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(user.getPassword());
				} else if (returnPwd == 1) {
					System.err.println("����������벻����6-16λ,����������!");
					// admin.setAcc_pwd(input.nextLine().trim());//
					user.setPassword(input.nextLine().trim());
					// returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
					returnPwd = verifyPwd.verifyPwd(user.getPassword());
				}
			}
			System.out.println("��������һ��Ҫ��ӵ��û�����:");
			verifyConfirm = input.nextLine().trim();
		}
		// �ֻ���ע����֤���ݲ���
		System.out.println("��������ӵ��û��ֻ���:");
		// admin.setPhone(input.nextLine().trim()) ;
		user.setPhone(input.nextLine().trim());
		VerifyPhone verifyPhone = new VerifyPhone();
		int returnNumber = verifyPhone.verifyPhone(user.getPhone());
		while (returnNumber == 0 || returnNumber == 1 || returnNumber == 2) {
			if (returnNumber == 0) {
				System.err.println("��������ֻ���Ϊ��!����������:");
				// admin.setPhone(input.nextLine().trim()) ;
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else if (returnNumber == 1) {
				System.err.println("��������ֻ��Ų�Ϊ11λ!����������:");
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else if (returnNumber == 2) {
				System.err.println("������Ĳ�����ʵ�ֻ���!����������:");
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else {

			}
		}
		// 6.ִ��sql���
		ps.setString(1, Number);
		ps.setString(2, user.getPhone());
		ps.setString(3, user.getPassword());
		int res = ps.executeUpdate();
		// System.out.println(res);
		// 7.�鿴���ؽ��
		if (res != 0) {
			System.out.println("==================================");
			System.out.println("�û�ע��ɹ�!�������μ��û���Ϣ!");
			System.out.println("�û��˺�Ϊ:" + Number);
			System.out.println("�û�����Ϊ:" + user.getPassword());
			System.out.println("�û�ע���ֻ���Ϊ:" + user.getPassword());
			System.out.println("==================================");
			TS ts = new TS();
			ts.tS();
			Scanner admininput = new Scanner(System.in);
			String change = admininput.nextLine();
			if (change.equals("1")) {
				userRegister();
			} else if (change.equals("2")) {
				ManageUsers.manageUsers();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				thread.sleep(800);// ��ͣ0.8S
				System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
				System.exit(-1);
			} else {
				while (!change.equals("1") && !change.equals("2")
						&& !change.equals("3")) {
					System.err.println("��������ȷ��ѡ��!(1-3)");
					ts.tS();
					change = input.nextLine().trim();
					if (change.equals("1")) {
						userRegister();
					} else if (change.equals("2")) {
						ManageUsers.manageUsers();
					} else if (change.equals("3")) {
						Thread thread = new Thread();
						thread.sleep(800);// ��ͣ0.8S
						System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
						System.exit(-1);
					}
				}
			}

		} else {
			// ִ��sql���ʧ��
			System.err.println("�û�ע��ʧ��!");
			System.out.println("������������ע��");
			userRegister();
		}
	}
}
package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class ManageUsers {
	public static void manageUsers() throws Exception {
		// 2.ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql1 = "select * from user ";
		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		
		// 6.ִ��sql���
		ResultSet eq1 = ps1.executeQuery();
		
		
		// System.out.println(res);
		System.out.println("=======����Ա�����û�����======");
		System.out.println("����������ѡ��:");
		System.out.println("1.��ʾ�����û�����Ϣ");
		System.out.println("2.�����ض��û���Ϣ");
		System.out.println("3.������û�");
		System.out.println("4.ɾ���û�����Ϣ");
		System.out.println("5.������һ��");
		System.out.println("6.�˳�����");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		User user = new User();
		if (choose.equals("1")) {
			System.out.println("=========�û���=========");
			System.out.println("�û���\t\t�ֻ���\t\t����\t\tע��ʱ��");
			while (eq1.next()) {
				System.out.println(eq1.getString(1) + "\t" + eq1.getString(2)
						+ "\t" + eq1.getString(3) + "\t" + eq1.getString(4));
				
			}
			System.out.println("�������ⷵ��");
				new Scanner(System.in).nextLine();// ͣ��һ��
				manageUsers();
		} else if (choose.equals("2")) {
			System.out.println("��������Ҫ���ҵ��û��˺�:");
			user.setNumber(input.nextLine().trim());
			String sql2 = "select * from user where yonghu=?";
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
			ps2.setString(1,user.getNumber());
			ResultSet eq2 = ps2.executeQuery();
			if(eq2.next()){
				System.out.println("�û���\t\t�ֻ���\t\t����\t\tע��ʱ��");
				System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)
						+ "\t" + eq2.getString(3) + "\t" + eq2.getString(4));
			System.out.println("�������ⷵ��");
				new Scanner(System.in).nextLine();// ͣ��һ��
				manageUsers();
			}
			System.err.println("���ݿ����޴��û�,�뷵������");
			new Scanner(System.in).nextLine();// ͣ��һ��
			manageUsers();
			
		} else if (choose.equals("3")) {
			UserRegister ur = new UserRegister();
			ur.userRegister();
		} else if (choose.equals("4")) {
			DeleteUser du = new DeleteUser();
			du.deleteuser();
		} else if (choose.equals("5")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("6")) {
			Thread thread = new Thread();
			
			thread.sleep(800);//��ͣ0.8S
			System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
			System.exit(-1);
		} 
		else {
			System.err.println("��������ȷ��ѡ��!(1-5)����س�����");
			new Scanner(System.in).nextLine();// ͣ��һ��
			manageUsers();
		}

	}
}

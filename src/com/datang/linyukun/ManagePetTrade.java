package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.mysql.jdbc.PreparedStatement;

public class ManagePetTrade {
	
	public static void managePetTrade() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql1 = "select * from jyxx ";
		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		
		// 6.ִ��sql���
		ResultSet eq1 = ps1.executeQuery();
		
		
		System.out.println("===========������ｻ�׶���ģ��========");
		System.out.println("����������ѡ��:");
		System.out.println("1.��ʾ���ж�������Ϣ");
		System.out.println("2.���ݶ����Ų����ض�������Ϣ");
		System.out.println("3.����¶���");
		System.out.println("4.ɾ��������Ϣ");
		System.out.println("5.������һ��");
		System.out.println("6.�˳�����");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		PetTrade pt = new PetTrade();
		if (choose.equals("1")) {
			System.out.println("=========������=========");
			System.out.println("������\t����\t\t����");//t\t�����\t��������\t����\t�Ա�\tƷ��\t����
			while (eq1.next()) {
				System.out.println(eq1.getString(1) + "\t" + eq1.getString(2)+ "\t\t" + eq1.getString(3));
				}
			System.out.println("�������ⷵ��");
			new Scanner(System.in).nextLine();// ͣ��һ��
			managePetTrade();
			
		}else if (choose.equals("2")) {
			System.out.println("��������Ҫ���ҵĶ�����:");
			//user.setNumber(input.nextLine().trim());
			pt.setDdnumber(input.nextLine().trim());
			String sql2 = "select * from jyxx where ddnumber=?";
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
			//ps2.setString(1,user.getNumber());
			ps2.setString(1, pt.getDdnumber());
			ResultSet eq2 = ps2.executeQuery();
			if(eq2.next()){
				System.out.println("������\t����\t\t����");
				System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)+ "\t\t" + eq2.getString(3));
			
			System.out.println("�������ⷵ��");
				new Scanner(System.in).nextLine();// ͣ��һ��
				managePetTrade();
			}
			System.err.println("���ݿ����޴˶���,�뷵������");
			new Scanner(System.in).nextLine();// ͣ��һ��
			managePetTrade();
		}else if (choose.equals("3")) {
			DdRegister dr = new DdRegister();
			dr.ddRegister();
		}else if (choose.equals("4")) {
			DdDelete dd = new DdDelete();
			dd.ddDelete();
		}else if (choose.equals("5")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("6")) {
			Thread thread = new Thread();
			thread.sleep(800);//��ͣ0.8S
			System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
			System.exit(-1);
		}else {
			System.err.println("��������ȷ��ѡ��!(1-6)����س�����");
			new Scanner(System.in).nextLine();// ͣ��һ��
			managePetTrade();
		}
		
	}
}
package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class exp_update {

	private static Scanner input;
	private static Scanner input2;

	public static void main(String[] args) {
		while (true) {		
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵĹ���Ա�˺�:");
		String acc_number = input.nextLine();

		try {
			// Scanner input = new Scanner(System.in);
			// 2.ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.����sql���
			String sql1 = "select * from admin where acc_number=?";
			// 5.��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql1);
			ps.setString(1, acc_number);
			// 6.ִ��sql���
			//execute ��ɾ�Ĳ� ����ֵΪ��������,�ɹ�Ϊtrue,ʧ��Ϊfalse
			//executeQuery   ��ѯ ���ؽ����
			//executeUpdate  ��ɾ�� ����ֵΪ��ֵ��,ʧ�ܷ���0.�ɹ�����
			ResultSet eq =ps.executeQuery();
			// int res1 = st.executeUpdate(sql);
			// System.out.println(res);
			// 7.�鿴���ؽ����
			
			/* if(res!=0){
				 System.out.println("�ɹ�"); 
				 }else {
					 System.out.println("ʧ��"); }
			 */
			
			while (eq.next()) {
				System.out.println("��ǰ�˺�����Ϊ:" + eq.getString(3)+ "\n��ǰ�˺Ű��ֻ���Ϊ:" + eq.getString(4) + "\n��ǰ�ܱ�����Ϊ:"
						+ eq.getString(5) + "\n��ǰ�ܱ���Ϊ:" + eq.getString(6));

				for (int i = 0; i < 30; i++) {// ��ʾ��Ϣ
					System.out.print("=");
				}
				System.out.println();
				System.out.println("��ѡ��Ҫ�޸ĵ�ѡ��:");
				System.out.println("1.�����˺�����");
				System.out.println("2.�����ֻ���");
				System.out.println("3.�����ܱ�����");
				System.out.println("4.�����ܱ���");
				System.out.println("5.����");
				String cho = input.next();
				// �� update admin set xxx where xxx
				switch (cho) {
				case "1":
					String a=acc_number;
					up_pwd(a);
					break;
				case "2":
					
					String b=acc_number;
					int res1 = ps.executeUpdate();
					if(res1!=0){
						 System.out.println("�޸ĳɹ�"); 
						 }else {
							 System.out.println("�޸�ʧ��"); }
					break;
				case "3":
					
					String c=acc_number;
					int res2 = ps.executeUpdate(up_mibaoQ(c));
					if(res2!=0){
						 System.out.println("�޸ĳɹ�"); 
						 }else {
							 System.out.println("�޸�ʧ��"); }
					break;
				case "4":
					
					String d=acc_number;
					int res3 = ps.executeUpdate(up_mibao(d));
					if(res3!=0){
						 System.out.println("�޸ĳɹ�"); 
						 }else {
							 System.out.println("�޸�ʧ��"); }
					break;
				case "5":
					break;
				default:
					System.out.println("��������ȷ��ѡ��");
					break;

				}

				break;
			}
			

			// 8.�ͷ���Դ
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	private static void up_pwd(String a) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		System.out.println("������Ҫ���ĵ�����:");
		input = new Scanner(System.in);
		String U_pwd = input.nextLine();
		String sql11 = "update admin set acc_pwd=? where acc_number=?";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql11);
		ps1.setString(1,U_pwd );
		ps1.setString(2,a );
		int res = ps1.executeUpdate();
		if(res!=0){
			 System.out.println("�޸ĳɹ�"); 
			 }else {
				 System.out.println("�޸�ʧ��"); }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.��ȡ���ݿ�����
		
		
		
	
	}

	private static String up_phone(String a) {
		System.out.println("������Ҫ���ĵ��ֻ���:");
		input = new Scanner(System.in);
		String U_phone = input.nextLine();
		String sql = "update admin set phone='" + U_phone + "'where acc_number='"+a+"'";
		return sql;
	}

	private static String up_mibaoQ(String a) {
		System.out.println("������Ҫ���ĵ��ܱ�����:");
		input = new Scanner(System.in);
		String U_mbq = input.nextLine();
		String sql = "update admin set mibao_Q='" + U_mbq + "'where acc_number='"+a+"'";
		return sql;
	}

	private static String up_mibao(String a) {
		System.out.println("������Ҫ���ĵ��ܱ���:");
		input2 = new Scanner(System.in);
		String U_mb = input2.nextLine();
		String sql = "update admin set mibao='" + U_mb + "'where acc_number='"+a+"'";
		return sql;
	}
}

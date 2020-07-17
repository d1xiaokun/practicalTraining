package com.datang;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Exp_jdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1.����jar��
		Scanner input = new Scanner(System.in);
		System.out.println("��������ӵĹ���Ա�˺�:");
		String acc_number = input.nextLine();
		System.out.println("��������ӵĹ���Ա����:");
		String acc_pwd = input.nextLine();
		System.out.println("��������ӵĹ���Ա�ֻ���:");
		String phone = input.nextLine();
		System.out.println("��������ӵĹ���Ա�ܱ�����:");
		String mibao_Q = input.nextLine();
		System.out.println("��������ӵĹ���Ա�ܱ���:");
		String mibao = input.nextLine();

		try {
			// 2.ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.����sql���
			// ��INSERT INTO��(����)value(��Ϣ)
			
			String sql = "INSERT INTO admin(acc_number,acc_pwd,phone,mibao_Q,mibao)VALUE(?,?,?,?,?);";
			//ɾ delete from admin where xxxx
			
			 //�� update admin set xxx where xxx
			  //�� select * from admin
			//5.��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//6.ִ��sql���
			ps.setString(1, acc_number);
			ps.setString(2, acc_pwd);
			ps.setString(3, phone);
			ps.setString(4, mibao_Q);
			ps.setString(5, mibao);
			 int res = ps.executeUpdate();
			 System.out.println(res);
			//7.�鿴���ؽ����
			 if(res!=0){
				 System.out.println("�ɹ�");
			 }else {
				System.out.println("ʧ��");
			}
			//8.�ͷ���Դ
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class exp_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫɾ���Ĺ���Ա�˺�:");
		String acc_number = input.nextLine();
		
		try { 
			// 2.ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.����sql���
			//ɾ delete from admin where xxxx
			//String sql = "delete from admin where acc_number='"+acc_number+"'";
			String sql = "delete from admin where acc_number=?";//preparedStatement

			 //�� update admin set xxx where xxx
			  //�� select * from admin
			//5.��ȡsql���Ķ���
			//java.sql.Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			
			//6.�������
			ps.setString(1, acc_number);
			//6.ִ��sql���
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

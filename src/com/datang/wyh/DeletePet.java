package com.datang.wyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeletePet {

	public static void DeletePet() {
		System.out.println("======ɾ��������Ϣ====");
		System.out.println("������Ҫɾ���ĳ���ĳ���ţ�");
		Scanner userInput = new Scanner(System.in);
		Pet pet = new Pet();
		pet.setPetnumber(userInput.nextLine().trim());
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cwglxt", "wjy", "root");
			String sql = "DELETE FROM pet where petnumber = ? ";

			 ps = con.prepareStatement(sql);
			 
			 ps.setString(1, pet.getPetnumber());
			 
			 System.out.println(sql.toString());
			 
			 int count = ps.executeUpdate();
			 
			 if(count>0){
				 System.out.println("ɾ���ɹ�������������һ����");
				 PetSystem petSystem = new PetSystem();
				 petSystem.PetSystem();
			 }
			 else {
				 System.out.println("ɾ��ʧ�ܣ�����������һ����");
				 PetSystem petSystem = new PetSystem();
				 petSystem.PetSystem();
			 }
			 
/*
			if (res != 0) {
				System.out.println("ɾ���ɹ�������������һ����");
				PetSystem petSystem = new PetSystem();
				c
			} else {
				System.out.println("ɾ��ʧ�ܣ�����������һ����");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

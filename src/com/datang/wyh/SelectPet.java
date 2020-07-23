package com.datang.wyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectPet {

	public void SelectPet() {
		// TODO Auto-generated method stub
		System.out.println("======��ѯ������Ϣ====");
		System.out.println("������Ҫ��ѯ�ĳ���ĳ���ţ�");

		Scanner userInput = new Scanner(System.in);
		Pet pet = new Pet();
		pet.setPetnumber(userInput.nextLine().trim());
		ResultSet res=null;
		PreparedStatement ps=null;
		Connection con=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			String sql = "SELECT * FROM pet where petnumber =?";

			ps = con.prepareStatement(sql.toString());
		
			System.out.println(sql);
			
			ps.setString(1, pet.getPetnumber());
			res = ps.executeQuery();
		
			if (res.next()) {
				
				String Petnumber= res.getString("Petnumber");
				String Petname= res.getString("Petname");
				String Petage= res.getString("Petage");
				String Petsex= res.getString("Petsex");
				String Petvariety= res.getString("Petvariety");
				String Petcase= res.getString("Petcase");
				
				System.out.println("�����:" + Petnumber + "\t������:"
						+ Petname+ "\t��������:" + Petage
						+ "\t�����Ա�:" + Petsex + "\t����Ʒ��:"
						+ Petvariety + "\t���ﲡ��:" + Petcase);
			    System.out.println("��ѯ�ɹ�������������һ����");
			    
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}else {
				 System.err.println("��ѯʧ�ܣ��ó���Ų����ڣ�����������һ����");
				 
				 PetSystem petSystem = new PetSystem();
				 petSystem.PetSystem();
			 }
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(res != null){try {
				
				
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}

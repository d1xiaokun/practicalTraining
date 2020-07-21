package com.datang.wyh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.datang.wjy.enter;

public class SelectPet {

	public void SelectPet() {
		// TODO Auto-generated method stub
		System.out.println("======查询宠物信息====");
		System.out.println("请输入要查询的宠物的宠物号：");

		Scanner userInput = new Scanner(System.in);
		Pet pet = new Pet();
		pet.setPetnumber(userInput.nextLine().trim());
		ResultSet res=null;
		PreparedStatement ps=null;
		Connection con=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cwglxt", "wjy", "root");
			String sql = "SELECT * FROM pet where petnumber =?";

			 ps = con.prepareStatement(sql.toString());
			//ps.setString(1, pet.getPetnumber());

			System.out.println(sql);
			//Statement st = con.createStatement();
			ps.setString(1, pet.getPetnumber());
			 res = ps.executeQuery();
//			System.out.println(res);
//			System.out.println(res.next());
			
			while (res.next()) {
				
//				System.out.println(res.next());
				String Petnumber= res.getString("Petnumber");
				String Petname= res.getString("Petname");
				String Petage= res.getString("Petage");
				String Petsex= res.getString("Petsex");
				String Petvariety= res.getString("Petvariety");
				String Petcase= res.getString("Petcase");
				
				System.out.println("宠物号:" + Petnumber + "\t宠物名:"
						+ Petname+ "\t宠物年龄:" + Petage
						+ "\t宠物性别:" + Petsex + "\t宠物品种:"
						+ Petvariety + "\t宠物病例:" + Petcase);
				PetSystem PetSystem= new PetSystem();
				PetSystem.PetSystem();
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

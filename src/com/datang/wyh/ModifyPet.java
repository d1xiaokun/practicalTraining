package com.datang.wyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.datang.wjy.enter;

public class ModifyPet {
	public static void ModifyPet() throws Exception {
		Pet pet=new Pet();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要修改的宠物号:");
		String Petnumber = input.nextLine();
		pet.setPetnumber(Petnumber.trim());
		
		System.out.println("请输入修改的宠物姓名:");
		String Petname = input.nextLine();
		pet.setPetname(Petname.trim());
		
		System.out.println("请输入修改的宠物年龄:");
		String Petage = input.nextLine();
		pet.setPetage(Petage.trim());
		
		System.out.println("请输入修改的宠物性别");
		String Petsex = input.nextLine();
		pet.setPetsex(Petsex.trim());
		
		System.out.println("请输入修改的宠物品种");
		String Petvariety = input.nextLine();
		pet.setPetvariety (Petvariety.trim());
		
		System.out.println("请输入修改的宠物病例");
		String Petcase = input.nextLine();
		pet.setPetcase(Petcase.trim());
		
		/*String sql1 = "update pet set Petname= '老二' and Petage='2' and Petsex='母' and Petvariety='藏獒' and Petcase='无' where Petnumber= ? ";
		*/String sql1 = "update pet set Petname= pet.getPetname and Petage=pet.getPetage and Petsex=pet.getPetsex and Petvariety=pet.getPetvariety' and Petcase=pet.getPetcase where Petnumber= ? ";
		System.out.println(sql1.toString());
			try {
				
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cwglxt", "wjy", "root");
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, pet.getPetnumber());
				 int count =ps.executeUpdate();
				
				 if(count>0){
					 System.out.println("更新成功，即将返回上一级！");
					 PetSystem PetSystem= new PetSystem();
						PetSystem.PetSystem();
				 }
				 else {
					 System.out.println("更新失败，即将返回上一级！");
					 PetSystem PetSystem= new PetSystem();
						PetSystem.PetSystem();
				 }
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {
						rs.close();
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

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
		System.out.println("������Ҫ�޸ĵĳ����:");
		String Petnumber = input.nextLine();
		pet.setPetnumber(Petnumber.trim());
		
		System.out.println("�������޸ĵĳ�������:");
		String Petname = input.nextLine();
		pet.setPetname(Petname.trim());
		
		System.out.println("�������޸ĵĳ�������:");
		String Petage = input.nextLine();
		pet.setPetage(Petage.trim());
		
		System.out.println("�������޸ĵĳ����Ա�");
		String Petsex = input.nextLine();
		pet.setPetsex(Petsex.trim());
		
		System.out.println("�������޸ĵĳ���Ʒ��");
		String Petvariety = input.nextLine();
		pet.setPetvariety (Petvariety.trim());
		
		System.out.println("�������޸ĵĳ��ﲡ��");
		String Petcase = input.nextLine();
		pet.setPetcase(Petcase.trim());
		
		/*String sql1 = "update pet set Petname= '�϶�' and Petage='2' and Petsex='ĸ' and Petvariety='����' and Petcase='��' where Petnumber= ? ";
		*/String sql1 = "update pet set Petname= pet.getPetname and Petage=pet.getPetage and Petsex=pet.getPetsex and Petvariety=pet.getPetvariety' and Petcase=pet.getPetcase where Petnumber= ? ";
		System.out.println(sql1.toString());
			try {
				
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cwglxt", "wjy", "root");
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, pet.getPetnumber());
				 int count =ps.executeUpdate();
				
				 if(count>0){
					 System.out.println("���³ɹ�������������һ����");
					 PetSystem PetSystem= new PetSystem();
						PetSystem.PetSystem();
				 }
				 else {
					 System.out.println("����ʧ�ܣ�����������һ����");
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

package com.datang.wyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AddPet {

	public void AddPet() throws Exception {
		// TODO Auto-gsenerated method stub

		Scanner userInput = new Scanner(System.in);
		Pet pet = new Pet();
		System.out.println("======��ӳ�����Ϣ====");
		System.out.println("���������ţ�");

		pet.setPetnumber(userInput.nextLine().trim());
		System.out.println(pet.getPetnumber());
		int num = 0;
		while (pet.getPetnumber().equals("")) {
			if (num >= 3) {
				// ��ת����ҳ
				System.err.println("���������������࣬�������س�����Ϣ������ҳ");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}
				System.err.println("������ĳ����Ϊ�գ����������룡");
				pet.setPetnumber(userInput.nextLine().trim());
				num++;
		}

		System.out.println("���������������");
		pet.setPetname(userInput.nextLine());
		System.out.println(pet.getPetname());

		System.out.println("������������䣺");
		pet.setPetage(userInput.nextLine());

		System.out.println("����������Ա�");
		pet.setPetsex(userInput.nextLine());

		System.out.println("���������Ʒ�֣�");
		pet.setPetvariety(userInput.nextLine());

		System.out.println("��������ﲡ����");
		pet.setPetcase(userInput.nextLine());

		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// ����sql
			String sql = "INSERT INTO pet(petnumber,petname,petage,petsex,petvariety,petcase)VALUE(?,?,?,?,?,?)";
			// ��ȡִ��sql�Ķ���
			PreparedStatement ps = con.prepareStatement(sql);
			// ��������
			ps.setString(1, pet.getPetnumber());
			ps.setString(2, pet.getPetname());
			ps.setString(3, pet.getPetage());
			ps.setString(4, pet.getPetsex());
			ps.setString(5, pet.getPetvariety());
			ps.setString(6, pet.getPetcase());

			int res = ps.executeUpdate();

			if (res != 0) {
				System.out.println("��ӳɹ�������������һ����");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			} else {
				System.out.println("���ʧ�ܣ�����������һ����");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

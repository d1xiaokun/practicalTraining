package com.datang.wyh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifyPet {
	public void ModifyPet() {
		Scanner input;
		Scanner input2;

		while (true) {

			input = new Scanner(System.in);
			System.out.println("������Ҫ�޸ĵĳ���ĳ����:");
			String petnumber = input.nextLine();

			try {

				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/superone", "root", "root");

				String sql1 = "select * from pet where petnumber=?";

				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement(sql1);
				ps.setString(1, petnumber);

				ResultSet pet = ps.executeQuery();

				while (pet.next()) {
					System.out.println("��ǰ��������Ϊ:" + pet.getString(2)
							+ "\n��ǰ��������Ϊ:" + pet.getString(3) + "\n��ǰ�����Ա�Ϊ:"
							+ pet.getString(4) + "\n��ǰ����Ʒ��Ϊ:"
							+ pet.getString(5) + "\n��ǰ���ﲡ��Ϊ:"
							+ pet.getString(6));

					for (int i = 0; i < 30; i++) {// ��ʾ��Ϣ
						System.out.print("=");
					}
					System.out.println();
					System.out.println("��ѡ��Ҫ�޸ĵ�ѡ��:");
					System.out.println("1.���ĳ�������");
					System.out.println("2.���ĳ�������");
					System.out.println("3.���ĳ����Ա�");
					System.out.println("4.���ĳ���Ʒ��");
					System.out.println("5.���ĳ��ﲡ��");
					System.out.println("6.����");
					String cho = input.next();
					
					switch (cho) {
					case "1":
						String a = petnumber;
						P_name(a);
						break;
					case "2":
						String b = petnumber;
						int res2 = ps.executeUpdate(P_age(b));
						if (res2 != 0) {
							System.out.println("�޸ĳɹ�");
						} else {
							System.out.println("�޸�ʧ��");
						}
						break;
					case "3":
						
						String c = petnumber;
						int res3 = ps.executeUpdate(P_sex(c));
						if (res3 != 0) {
							System.out.println("�޸ĳɹ�");
						} else {
							System.out.println("�޸�ʧ��");
						}
						break;
					case "4":

						String d = petnumber;
						int res4 = ps.executeUpdate(P_variety(d));
						if (res4 != 0) {
							System.out.println("�޸ĳɹ�");
						} else {
							System.out.println("�޸�ʧ��");
						}
						break;
					case "5":

						String e = petnumber;
						int res5 = ps.executeUpdate(P_case(e));
						if (res5 != 0) {
							System.out.println("�޸ĳɹ�");
						} else {
							System.out.println("�޸�ʧ��");
						}
						break;

					case "6":
						break;
					default:
						System.out.println("��������ȷ��ѡ��");
						break;

					}

					break;
				}

				con.close();
			
				System.err.println("ֹͣ�޸ģ�����������һ����");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	private static void P_name(String a) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			System.out.println("������Ҫ���ĳ�������:");
			//Scanner input = null;
			
			Scanner input = new Scanner(System.in);
			String P_name = input.nextLine();
			String sql11 = "update pet set petname=? where petnumber=?";
			PreparedStatement ps1 = (PreparedStatement) con
					.prepareStatement(sql11);
			ps1.setString(1, P_name);
			ps1.setString(2, a);
			int res = ps1.executeUpdate();
			if (res != 0) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String P_age(String a) {
		System.out.println("������Ҫ���ĵĳ�������:");
		Scanner input = new Scanner(System.in);
		String P_age= input.nextLine();
		String sql = "update pet set petage='" + P_age + "'where petnumber='"
				+ a + "'";
		return sql;
	}

	
	private static String P_sex(String a) {
		System.out.println("������Ҫ���ĵĳ����Ա�:");
		Scanner input = new Scanner(System.in);
		String P_sex = input.nextLine();
		String sql = "update pet set petsex='" + P_sex + "'where petnumber='"
				+ a + "'";
		return sql;
	}

	private static String P_variety(String a) {
		System.out.println("������Ҫ���ĵĳ���Ʒ��:");
		Scanner input = new Scanner(System.in);
		String P_variety = input.nextLine();
		String sql = "update pet set petvariety='" + P_variety
				+ "'where petnumber='" + a + "'";
		return sql;
	}

	private static String P_case(String a) {
		System.out.println("������Ҫ���ĵĳ��ﲡ��:");
		Scanner input2 = new Scanner(System.in);
		String P_case = input2.nextLine();
		String sql = "update pet set petcase='" + P_case
				+ "'where petnumber='" + a + "'";
		return sql;
		
	}

}

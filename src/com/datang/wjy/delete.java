package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class delete {
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			delete();
		}
		public static void delete() throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// ����sql���
			String select = "select * from jyxx where ddnumber=?";
			String sql = "delete from jyxx where ddnumber=?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);
			PetTrade pt = new PetTrade();
			Scanner input = new Scanner(System.in);
			System.out.println("======��ӭ����ɾ������======");
			System.out.println("��������Ҫɾ���Ķ�����:");
			pt.setDdnumber(input.nextLine().trim());
			ps1.setString(1, pt.getDdnumber());
			ResultSet eq = ps1.executeQuery();
			while (eq.next()) {
				System.out.println("���ҵ�������Ϣ!\n������\t����\t\t����");
				System.out.println(eq.getString(1) + "\t" + eq.getString(2)+ "\t\t" + eq.getString(3));
				while(true){
					System.out.println("�Ƿ�ɾ��?");
					String affirm = input.nextLine().trim();
					if (affirm.equals("y") || affirm.equals("Y")) {
						ps2.setString(1, pt.getDdnumber());
						int res = ps2.executeUpdate();
						// 7.�鿴���ؽ����
						if (res != 0) {
							System.out.println("ɾ���ɹ�!");
							System.out.println("���ڷ�����һ��");
							pet.pet();
						} else {
							System.err.println("ɾ��ʧ��!���ڷ���....");
							delete();
						}
					} else if (affirm.equals("N") || affirm.equals("n")) {
						
						System.out.println("���Ƿ����ִ��ɾ������?����y������,�������ⷵ����һ��");
						String reaffirm = input.nextLine().trim();
						if (reaffirm.equals("y")||reaffirm.equals("Y")) {
							System.out.println("���ڷ��ز���..");
							delete();
						}else {
							enter.enter();
						}
						
					} else {
						System.err.println("�������ѡ���,����������!");

					}

				}
			}
			if (!eq.next()) {
				System.err.println("������Ķ����Ų�����!����������!");
				delete();
			}
			verifynumber verifynumber = new verifynumber();
			int returnunum = verifynumber.verifynumber(pt.getDdnumber());

			if (returnunum == 0) {
				System.out.println("3��������˺�Ϊ��,����������!");
				// System.out.println(admin.getAcc_number()+" 3 ");
				// return judgeUserNumber();
				delete();

			}  else {
				// return user.getNumber();
			}

		}
}



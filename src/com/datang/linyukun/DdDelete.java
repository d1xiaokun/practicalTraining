package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class DdDelete {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ddDelete();
	}

	public static void ddDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// ����sql���
		String select = "select * from jyxx where ddnumber=?";
		String sql = "delete from jyxx where ddnumber=?";
		// ��ȡ��ȡsql���Ķ���
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);
		PetTrade pt = new PetTrade();
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ���Ķ�����:");
		pt.setDdnumber(input.nextLine().trim());
		ps1.setString(1, pt.getDdnumber());
		ResultSet eq = ps1.executeQuery();
		while (eq.next()) {
			System.out.println("���ҵ�������Ϣ!\n������\t����\t\t����");
			System.out.println(eq.getString(1) + "\t" + eq.getString(2)
					+ "\t\t" + eq.getString(3));
			while (true) {
				System.out.println("�Ƿ�ɾ��?(y|n)");
				String affirm = input.nextLine().trim();
				if (affirm.equals("y") || affirm.equals("Y")) {
					ps2.setString(1, pt.getDdnumber());
					int res = ps2.executeUpdate();
					// 7.�鿴���ؽ����
					if (res != 0) {
						System.out.println("ɾ���ɹ�!");
						System.out.println("���ڷ�����һ��");
						ManagePetTrade.managePetTrade();
					} else {
						System.err.println("ɾ��ʧ��!���ڷ���....");
						ddDelete();
					}
				} else if (affirm.equals("N") || affirm.equals("n")) {
					System.out.println("���Ƿ����ִ��ɾ������?����y������,�������ⷵ����һ��");
					String reaffirm = input.nextLine().trim();
					if (reaffirm.equals("y") || reaffirm.equals("Y")) {
						System.out.println("���ڷ��ز���..");
						ddDelete();
					} else {
						ManagePetTrade.managePetTrade();
					}
				} else {
					System.err.println("�������ѡ���,����������!");
				}
			}
		}
		if (!eq.next()) {
			System.err.println("������Ķ�����δ��¼!����������!");
			ddDelete();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(pt.getDdnumber());
		if (returnunum == 0) {
			System.out.println("3��������˺�Ϊ��,����������!");
			ddDelete();
		}
	}
}

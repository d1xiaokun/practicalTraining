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
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 定义sql语句
		String select = "select * from jyxx where ddnumber=?";
		String sql = "delete from jyxx where ddnumber=?";
		// 获取获取sql语句的对象
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);
		PetTrade pt = new PetTrade();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要删除的订单号:");
		pt.setDdnumber(input.nextLine().trim());
		ps1.setString(1, pt.getDdnumber());
		ResultSet eq = ps1.executeQuery();
		while (eq.next()) {
			System.out.println("已找到订单信息!\n订单号\t卖主\t\t买主");
			System.out.println(eq.getString(1) + "\t" + eq.getString(2)
					+ "\t\t" + eq.getString(3));
			while (true) {
				System.out.println("是否删除?(y|n)");
				String affirm = input.nextLine().trim();
				if (affirm.equals("y") || affirm.equals("Y")) {
					ps2.setString(1, pt.getDdnumber());
					int res = ps2.executeUpdate();
					// 7.查看返回结果集
					if (res != 0) {
						System.out.println("删除成功!");
						System.out.println("正在返回上一级");
						ManagePetTrade.managePetTrade();
					} else {
						System.err.println("删除失败!正在返回....");
						ddDelete();
					}
				} else if (affirm.equals("N") || affirm.equals("n")) {
					System.out.println("您是否继续执行删除操作?输入y将继续,输入任意返回上一级");
					String reaffirm = input.nextLine().trim();
					if (reaffirm.equals("y") || reaffirm.equals("Y")) {
						System.out.println("正在返回操作..");
						ddDelete();
					} else {
						ManagePetTrade.managePetTrade();
					}
				} else {
					System.err.println("您输入的选项不对,请重新输入!");
				}
			}
		}
		if (!eq.next()) {
			System.err.println("您输入的订单号未记录!请重新输入!");
			ddDelete();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(pt.getDdnumber());
		if (returnunum == 0) {
			System.out.println("3您输入的账号为空,请重新输入!");
			ddDelete();
		}
	}
}

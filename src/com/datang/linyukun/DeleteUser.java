package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class DeleteUser {
	public static void main(String[] args) throws Exception{
		deleteuser();
	}
	public static void deleteuser() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 定义sql语句
		String select = "select * from user where yonghu=?";
		String sql = "delete from user where yonghu=?";
		// 获取获取sql语句的对象
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
		PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);
		User user = new User();
		Scanner input = new Scanner(System.in);
		// Admin admin = new Admin();
		// Scanner input = new Scanner(System.in);

		System.out.println("1请输入要删除的用户账号(6-16位):");
		user.setNumber(input.nextLine().trim());

		// admin.setAcc_number(input.nextLine().trim());
		// System.out.println(admin.getAcc_number()+" 1");
		// 执行sql语句
		ps1.setString(1, user.getNumber());
		ResultSet eq = ps1.executeQuery();
		while (eq.next()) {// 先判断是否账号是否被注册
			System.out.println("已找到此用户信息!\n" + "用户名\t手机号\t\t密码\t\t\t注册时间");
			System.out.println(eq.getString(1) + "\t" + eq.getString(2)
						+ "\t" + eq.getString(3) + "\t\t" + eq.getString(4));
			while (true) {
				
				
				System.out.println("是否删除?");
				String affirm = input.nextLine().trim();
				if (affirm.equals("y") || affirm.equals("Y")) {
					ps2.setString(1, user.getNumber());
					int res = ps2.executeUpdate();
					// 7.查看返回结果集
					if (res != 0) {
						System.out.println("删除成功!");
						System.out.println("正在返回上一级");
						ManageUsers.manageUsers();
					} else {
						System.err.println("删除失败!正在返回....");
						deleteuser();
					}
				} else if (affirm.equals("N") || affirm.equals("n")) {
					
					System.out.println("您是否继续执行删除操作?输入y将继续,输入任意返回上一级");
					String reaffirm = input.nextLine().trim();
					if (reaffirm.equals("y")||reaffirm.equals("Y")) {
						System.out.println("正在返回操作..");
						deleteuser();
					}else {
						ManageUsers.manageUsers();
					}
					
				} else {
					System.err.println("您输入的选项不对,请重新输入!");

				}

			}
		}
		if (!eq.next()) {
			System.err.println("您输入的用户不存在!请重新输入!");
			deleteuser();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());

		if (returnunum == 0) {
			System.out.println("3您输入的账号为空,请重新输入!");
			// System.out.println(admin.getAcc_number()+" 3 ");
			// return judgeUserNumber();
			deleteuser();

		}  else {
			// return user.getNumber();
		}
	}

}
package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.Admin;
import com.mysql.jdbc.PreparedStatement;

class JudgeAccount {


	public  String judgeAccount() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 定义sql语句
		String select = "select * from admin where acc_number=?";
		// 获取获取sql语句的对象
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		Admin admin = new Admin();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("1请输入添加的管理员账号(6-16位):");// 需验证管理员账号是否数据库中存在用executeQuery()返回数据库里的所有账号信息,
													// 然后用循环与输入的账号做匹配,如果没有一样的账号就能插入信息到数据库,否则让他更改账号
		admin.setAcc_number(input.nextLine().trim());
		System.out.println(admin.getAcc_number()+" 1");
// 执行sql语句
		ps1.setString(1, admin.getAcc_number());
		ResultSet eq = ps1.executeQuery();
		if(eq.next()){// 先判断是否账号是否被注册
			//while (eq.getString(2).equals(admin.getAcc_number())) {
				System.out.println("2抱歉,您输入的账号已被注册!请重新输入!");
				System.out.println(admin.getAcc_number()+" 2");
				return judgeAccount();
			//}
		}
/*
 * 存在问题
 */
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnadnum = verifyNumber.verifyNumber(admin.getAcc_number());
		if (returnadnum == 0) {
			System.out.println("3您输入的账号为空,请重新输入!");
			System.out.println(admin.getAcc_number()+" 3 ");
			return judgeAccount();

		} else if (returnadnum == 1) {
			System.out.println("6您输入的账号不满足6-16位,请重新输入!");
			System.out.println(admin.getAcc_number()+" 4");
			return judgeAccount();
		}else {
			return admin.getAcc_number();
		}
//		ps1.close();
//		eq.close();
//		con.close();
		//System.out.println(admin.getAcc_number());
		
		
	}
}

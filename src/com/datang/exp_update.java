package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class exp_update {

	private static Scanner input;
	private static Scanner input2;

	public static void main(String[] args) {
		while (true) {		
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		System.out.println("请输入要修改的管理员账号:");
		String acc_number = input.nextLine();

		try {
			// Scanner input = new Scanner(System.in);
			// 2.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3.获取数据库连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.定义sql语句
			String sql1 = "select * from admin where acc_number=?";
			// 5.获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql1);
			ps.setString(1, acc_number);
			// 6.执行sql语句
			//execute 增删改查 返回值为布尔类型,成功为true,失败为false
			//executeQuery   查询 返回结果集
			//executeUpdate  增删改 返回值为数值型,失败返回0.成功返回
			ResultSet eq =ps.executeQuery();
			// int res1 = st.executeUpdate(sql);
			// System.out.println(res);
			// 7.查看返回结果集
			
			/* if(res!=0){
				 System.out.println("成功"); 
				 }else {
					 System.out.println("失败"); }
			 */
			
			while (eq.next()) {
				System.out.println("当前账号密码为:" + eq.getString(3)+ "\n当前账号绑定手机号为:" + eq.getString(4) + "\n当前密保问题为:"
						+ eq.getString(5) + "\n当前密保答案为:" + eq.getString(6));

				for (int i = 0; i < 30; i++) {// 提示信息
					System.out.print("=");
				}
				System.out.println();
				System.out.println("请选择要修改的选项:");
				System.out.println("1.更改账号密码");
				System.out.println("2.更改手机号");
				System.out.println("3.更改密保问题");
				System.out.println("4.更改密保答案");
				System.out.println("5.返回");
				String cho = input.next();
				// 改 update admin set xxx where xxx
				switch (cho) {
				case "1":
					String a=acc_number;
					up_pwd(a);
					break;
				case "2":
					
					String b=acc_number;
					int res1 = ps.executeUpdate();
					if(res1!=0){
						 System.out.println("修改成功"); 
						 }else {
							 System.out.println("修改失败"); }
					break;
				case "3":
					
					String c=acc_number;
					int res2 = ps.executeUpdate(up_mibaoQ(c));
					if(res2!=0){
						 System.out.println("修改成功"); 
						 }else {
							 System.out.println("修改失败"); }
					break;
				case "4":
					
					String d=acc_number;
					int res3 = ps.executeUpdate(up_mibao(d));
					if(res3!=0){
						 System.out.println("修改成功"); 
						 }else {
							 System.out.println("修改失败"); }
					break;
				case "5":
					break;
				default:
					System.out.println("请输入正确的选项");
					break;

				}

				break;
			}
			

			// 8.释放资源
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	private static void up_pwd(String a) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		System.out.println("请输入要更改的密码:");
		input = new Scanner(System.in);
		String U_pwd = input.nextLine();
		String sql11 = "update admin set acc_pwd=? where acc_number=?";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql11);
		ps1.setString(1,U_pwd );
		ps1.setString(2,a );
		int res = ps1.executeUpdate();
		if(res!=0){
			 System.out.println("修改成功"); 
			 }else {
				 System.out.println("修改失败"); }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.获取数据库连接
		
		
		
	
	}

	private static String up_phone(String a) {
		System.out.println("请输入要更改的手机号:");
		input = new Scanner(System.in);
		String U_phone = input.nextLine();
		String sql = "update admin set phone='" + U_phone + "'where acc_number='"+a+"'";
		return sql;
	}

	private static String up_mibaoQ(String a) {
		System.out.println("请输入要更改的密保问题:");
		input = new Scanner(System.in);
		String U_mbq = input.nextLine();
		String sql = "update admin set mibao_Q='" + U_mbq + "'where acc_number='"+a+"'";
		return sql;
	}

	private static String up_mibao(String a) {
		System.out.println("请输入要更改的密保答案:");
		input2 = new Scanner(System.in);
		String U_mb = input2.nextLine();
		String sql = "update admin set mibao='" + U_mb + "'where acc_number='"+a+"'";
		return sql;
	}
}

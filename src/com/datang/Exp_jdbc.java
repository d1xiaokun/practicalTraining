package com.datang;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Exp_jdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1.导入jar包
		Scanner input = new Scanner(System.in);
		System.out.println("请输入添加的管理员账号:");
		String acc_number = input.nextLine();
		System.out.println("请输入添加的管理员密码:");
		String acc_pwd = input.nextLine();
		System.out.println("请输入添加的管理员手机号:");
		String phone = input.nextLine();
		System.out.println("请输入添加的管理员密保问题:");
		String mibao_Q = input.nextLine();
		System.out.println("请输入添加的管理员密保答案:");
		String mibao = input.nextLine();

		try {
			// 2.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3.获取数据库连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.定义sql语句
			// 增INSERT INTO表(列名)value(信息)
			
			String sql = "INSERT INTO admin(acc_number,acc_pwd,phone,mibao_Q,mibao)VALUE(?,?,?,?,?);";
			//删 delete from admin where xxxx
			
			 //改 update admin set xxx where xxx
			  //查 select * from admin
			//5.获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//6.执行sql语句
			ps.setString(1, acc_number);
			ps.setString(2, acc_pwd);
			ps.setString(3, phone);
			ps.setString(4, mibao_Q);
			ps.setString(5, mibao);
			 int res = ps.executeUpdate();
			 System.out.println(res);
			//7.查看返回结果集
			 if(res!=0){
				 System.out.println("成功");
			 }else {
				System.out.println("失败");
			}
			//8.释放资源
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

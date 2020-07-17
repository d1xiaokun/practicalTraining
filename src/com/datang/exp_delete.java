package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class exp_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要删除的管理员账号:");
		String acc_number = input.nextLine();
		
		try { 
			// 2.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3.获取数据库连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.定义sql语句
			//删 delete from admin where xxxx
			//String sql = "delete from admin where acc_number='"+acc_number+"'";
			String sql = "delete from admin where acc_number=?";//preparedStatement

			 //改 update admin set xxx where xxx
			  //查 select * from admin
			//5.获取sql语句的对象
			//java.sql.Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			
			//6.插入语句
			ps.setString(1, acc_number);
			//6.执行sql语句
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

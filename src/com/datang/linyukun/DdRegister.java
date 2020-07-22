package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class DdRegister {
	public void ddRegister() throws Exception{
		/*
		 * 管理员添加订单功能已移除
		 */
			// 2.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3.获取数据库连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.定义sql语句	
			String sql = "INSERT INTO jyxx(ddnumber,jyjf,jyyf)VALUE(?,?,?);";
			//5.获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
			User user = new User();
			Scanner input = new Scanner(System.in);
			JudgeDDNumber jd = new JudgeDDNumber();
			String ddn=jd.judgeDDNumber();
			//String jf = input.nextLine().trim();
			JudgeName jn = new JudgeName();
			String jfn = jn.judgeJName();
			String yfn = jn.judgeYName();
			//6.执行sql语句
			ps.setString(1, ddn);
			ps.setString(2, jfn);
			ps.setString(3, yfn);
			int res =ps.executeUpdate();
			 //System.out.println(res);
			//7.查看返回结果
					if(res != 0 ){
						System.out.println("==================================");
						System.out.println("订单输入成功!");
						//显示一下管理员注册信息
						System.out.println("订单号为:"+ddn);
						System.out.println("甲方为:"+jfn);
						System.out.println("乙方为:"+yfn);
						System.out.println("==================================");
						System.out.println("是否返回创建订单?");
						System.out.println("1.返回继续创建订单");
						System.out.println("2.返回宠物订单界面");
						System.out.println("3.退出系统");
						Scanner admininput = new Scanner(System.in);
						String change =admininput.nextLine();
						while(!change.equals("1" )||!change.equals("1") ||!change.equals("3")){
							if (change.equals("1")) {
							ddRegister();
						} else if (change.equals("2")) {
							ManagePetTrade.managePetTrade();
						} else if (change.equals("3")) {
							Thread thread = new Thread();
							thread.sleep(800);//暂停0.8S
							System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
							System.exit(-1);
						} else {
							System.err.println("请输入正确的选项!(1-3)");
							//new Scanner(System.in).nextLine();//停顿一下
							change =admininput.nextLine();
							//Login();//若输入不在选项继续循环当前模块
						}
						}
					}else {
						//执行sql语句失败
						System.err.println("订单创建失败!");
						System.out.println("即将返回重新创建");
						ddRegister();
				 }				
	}
}

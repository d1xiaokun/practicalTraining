package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.Admin;
import com.mysql.jdbc.PreparedStatement;

public class AdminRegister {//管理员注册
	public void adminRegister() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入添加的管理员账号:");//需验证管理员账号是否数据库中存在用executeQuery()返回数据库里的所有账号信息,
											//然后用循环与输入的账号做匹配,如果没有一样的账号就能插入信息到数据库,否则让他更改账号
		String acc_number = input.nextLine();
		
		
		System.out.println("请输入添加的管理员密码:");
		String acc_pwd = input.nextLine();
		
		
		System.out.println("请输入添加的管理员手机号:");
		Admin admin = new Admin();
		admin.setPhone(input.nextLine().trim()) ;
		VerifyPhone verifyPhone = new VerifyPhone();
		int returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
		while(returnNumber == 0 || returnNumber == 1 || returnNumber == 2){
			if(returnNumber == 0 ){
				System.err.println("您输入的手机号为空!请重新输入:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
			}else if(returnNumber == 1 ){
				System.err.println("您输入的手机号不为11位!请重新输入:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
				
			}else if (returnNumber == 2) {
				System.err.println("您输入的不是真实手机号!请重新输入:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
			}else {
				
			}
		}
		
		
		
		
		
		
		
		
		
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
			String sql = "INSERT INTO admin(acc_number,acc_pwd,phone,mibao_Q,mibao)VALUE(?,?,?,?,?);";
			//删 delete from admin where xxxx
			 //改 update admin set xxx where xxx
			  //查 select * from admin
			//5.获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//6.执行sql语句
			ps.setString(1, acc_number);
			ps.setString(2, acc_pwd);
			ps.setString(3, admin.getPhone());
			ps.setString(4, mibao_Q);
			ps.setString(5, mibao);
			int res =ps.executeUpdate();
			 System.out.println(res);
			//7.查看返回结果
			 
				// while(res != 0||change != "1"){
					if(res != 0 ){
				 System.out.println("管理员注册成功!");
						System.out.println("是否返回登录管理员账号?");
						System.out.println("1.返回管理员登录");
						System.out.println("2.返回主界面");
						System.out.println("3.退出系统");
						Scanner admininput = new Scanner(System.in);
						String change =admininput.nextLine();
						if (change.equals("1")) {
							Adminsystem.adminSystem();
						} else if (change.equals("2")) {
							
							Main.Login();
						} else if (change.equals("3")) {
							Thread thread = new Thread();
							
							thread.sleep(800);//暂停0.8S
							System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
							System.exit(-1);
						} else {
							System.err.println("请输入正确的选项!(1-3)");
							new Scanner(System.in).nextLine();//停顿一下
							//Login();//若输入不在选项继续循环当前模块
						}
					}else {
						System.err.println("管理员注册失败!");
						System.out.println("即将返回重新注册");
						adminRegister();
					//}
				 }
				
			//8.释放资源
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

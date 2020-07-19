package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.Admin;
import com.mysql.jdbc.PreparedStatement;

public class AdminRegister {//管理员注册
	private Scanner input;
private Scanner admininput;

	public void adminRegister() {
		
		try {
			// 2.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3.获取数据库连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.定义sql语句	
			String sql = "INSERT INTO admin(acc_number,acc_pwd,phone,mibao_Q,mibao)VALUE(?,?,?,?,?);";
			//5.获取sql语句的对象
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
			Admin admin = new Admin();
			input = new Scanner(System.in);
			
			
			
			//管理员注册账号输入验证内容部分
			JudgeAccount judgeAccount = new JudgeAccount();
			String Number =judgeAccount.judgeAccount();
			
			
			//密码注册验证内容部分
			System.out.println("请输入添加的管理员密码(6-16位):");
			admin.setAcc_pwd(input.nextLine().trim());
			VerifyPwd verifyPwd = new VerifyPwd();
			int returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
			while(returnPwd == 0 || returnPwd == 1 ){
				if (returnPwd == 0) {
					System.err.println("您输入的密码为空,请重新输入!");
					admin.setAcc_pwd(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				}else if(returnPwd == 1){
					System.err.println("您输入的密码不满足6-16位,请重新输入!");
					admin.setAcc_pwd(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				}
			}
			System.out.println("请再输入一次要添加的管理员密码:");
			String verifyConfirm = input.nextLine().trim();
			while(!admin.getAcc_pwd().equals(verifyConfirm)){
				System.err.println("两次输入的密码不一致,请重新输入第一次密码!");
				//System.out.println("请输入密码1:");
				admin.setAcc_pwd(input.nextLine().trim());
				verifyPwd = new VerifyPwd();
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				while(returnPwd == 0 || returnPwd == 1 ){
					if (returnPwd == 0) {
						System.err.println("您输入的密码为空,请重新输入!");
						admin.setAcc_pwd(input.nextLine().trim());
						returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
					}else if(returnPwd == 1){
						System.err.println("您输入的密码不满足6-16位,请重新输入!");
						admin.setAcc_pwd(input.nextLine().trim());
						returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
					}
				}
				System.out.println("请再输入一次要添加的管理员密码:");
				verifyConfirm = input.nextLine();
			} 
			//手机号注册验证内容部分
			System.out.println("请输入添加的管理员手机号:");
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
						//密保问题不为空
			System.out.println("请输入添加的管理员密保问题:");
			admin.setMibao_Q(input.nextLine().trim());
			VerifyMibao_Q verifyMibao_Q = new VerifyMibao_Q();
			int returnmbQ = verifyMibao_Q.verifyMibao_Q(admin.getMibao_Q());
			while(returnmbQ ==0){
				System.err.println("您输入的密保为空,请重新输入!");
				admin.setMibao_Q(input.nextLine().trim());
				returnmbQ = verifyMibao_Q.verifyMibao_Q(admin.getMibao_Q());
			}
			//密保答案不为空
			System.out.println("请输入添加的管理员密保答案:");
			admin.setMibao(input.nextLine().trim());
			VerifyMibao verifyMibao = new VerifyMibao();
			int returnmb = verifyMibao.verifyMibao(admin.getMibao());
			while(returnmb ==0){
				System.err.println("您输入的密保答案为空,请重新输入!");
				admin.setMibao(input.nextLine().trim());
				returnmb = verifyMibao.verifyMibao(admin.getMibao());
			}

			//6.执行sql语句
			ps.setString(1, Number);
			ps.setString(2, admin.getAcc_pwd());
			ps.setString(3, admin.getPhone());
			ps.setString(4, admin.getMibao_Q());
			ps.setString(5, admin.getMibao());
			int res =ps.executeUpdate();
			 //System.out.println(res);
			//7.查看返回结果
					if(res != 0 ){
						System.out.println("==================================");
						System.out.println("管理员注册成功!请牢记您的信息!");
						//显示一下管理员注册信息
						System.out.println("您的管理员账号为:"+Number);
						System.out.println("您的密码为:"+admin.getAcc_pwd());
						System.out.println("您的注册手机号为:"+admin.getPhone());
						System.out.println("您的密保问题为:"+admin.getMibao_Q());
						System.out.println("您的密保答案为"+admin.getMibao());
						System.out.println("==================================");
				 
						System.out.println("是否返回登录管理员账号?");
						System.out.println("1.返回管理员登录");
						System.out.println("2.返回主界面");
						System.out.println("3.退出系统");
						admininput = new Scanner(System.in);
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
						//执行sql语句失败
						System.err.println("管理员注册失败!");
						System.out.println("即将返回重新注册");
						adminRegister();
				 }
				
			//8.释放资源
			//con.close();
					if(ps!= null) 
				    	  ps.close(); 		
				      if(con!= null) 
				        con.close(); 
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

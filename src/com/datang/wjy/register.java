package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class register {
	public void register() throws Exception{
		Scanner userInput =new Scanner(System.in);
		User user=new User();  
		System.out.println("欢迎进入注册界面");
		System.out.println("请输入用户名：");
		user.setYonghu(userInput.nextLine().trim());
		int num=0;
		while(user.getYonghu().equals("")) {
			if(num>=3){
				System.err.println("用户名输入次数过多，即将放回用户系统首页！");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("您输入用户名为空，请重新输入！");
			user.setYonghu(userInput.nextLine().trim());
			num++;
			}
		System.out.println("请输入手机号：");
		user.setPhone(userInput.nextLine().trim()); 
		VerifyPhone verifyPhone=new VerifyPhone();
	    int verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
	    while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
		if(verifyPhoneNum==0){
			System.err.println("您输入的号码为空！");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==1){
			System.err.println("您输入的号码不符合规则（11位）！");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==2){
			System.err.println("您输入的号码不正确！");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==3){			
		}
	    }
	    System.out.println("请输入密码：(6-16位)");
	    user.setPassword(userInput.nextLine().trim());
	    VerifyPassword VerifyPassword=new VerifyPassword();
	    int VerifyPasswordNum=VerifyPassword.VerifyPassword(user.getPassword());
	    while(VerifyPasswordNum==0||VerifyPasswordNum==1) {	
	    	if(VerifyPasswordNum==0){
	    		System.err.println("您输入密码为空，请重新输入！");
			    user.setPassword(userInput.nextLine().trim());
	    	}
	    	if(VerifyPasswordNum==1){
	    		System.err.println("您输入密码长度不满足6-16位！");
			    user.setPassword(userInput.nextLine().trim());
	    	}
			
	    }
	    
	    System.out.println("请二次确认密码：");
	    String confirmPassword=userInput.nextLine().trim();
	    while(!user.getPassword().equals(confirmPassword)) {			
			System.err.println("两次密码不一致！请重新输入！！");
			user.setPassword(userInput.nextLine().trim());
			VerifyPassword =new VerifyPassword();
			VerifyPasswordNum=VerifyPassword.VerifyPassword(user.getPassword());
			while(VerifyPasswordNum==0||VerifyPasswordNum==1){
				if(VerifyPasswordNum==0){
					System.err.println("您输入密码为空，请重新输入！");
					user.setPassword(userInput.nextLine().trim());
				}if(VerifyPasswordNum==1){
			       System.err.println("您输入密码不满足6-16位！");
			       user.setPassword(userInput.nextLine().trim());
			}
			}
			 System.out.println("请二次确认密码：");
			 confirmPassword=userInput.nextLine();
			}
	    System.out.println("可以传数据库");
	try {
			
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cwglxt","wjy","root");
         String sql="INSERT INTO user(yonghu,phone,password)VALUE(?,?,?)";
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1, user.getYonghu());
         ps.setString(2, user.getPhone());
         ps.setString(3, user.getPassword());
         int res=ps.executeUpdate();
         if(res!=0){
        	System.out.println("注册成功，跳转登录页面！");
        	login login=new login();
        	login.login();
         }
        else{
       	System.err.println("注册失败，返回上一级！");
      	enter enter=new enter();
        enter.enter();
         }
		
       con.close();
        } catch (Exception e) {
		 	// TODO Auto-generated catch block
		  e.printStackTrace();
		}
}
}


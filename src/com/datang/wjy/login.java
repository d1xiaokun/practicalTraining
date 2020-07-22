package com.datang.wjy;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.datang.wyh.PetLogin;
import com.mysql.jdbc.Connection;



public class login {
	public  void login() throws Exception{
		Scanner userInput =new Scanner(System.in);
		User user=new User();  
		System.out.println("欢迎进入登录界面");
		System.out.println("请输入用户名：");
		user.setYonghu(userInput.nextLine().trim());
		int num=0;
		while(user.getYonghu().equals("")) {
			if(num>=3){
				System.err.println("用户名输入次数过多，即将放回系统首页！");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("您输入用户名为空，请重新输入！");
			user.setYonghu(userInput.nextLine().trim());
			num++;
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
			try {
				 PreparedStatement ps = null;
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/superone","root","root");
		         ps=con.prepareStatement("select * from user where yonghu = ?  and password = ?");
		         ps.setString(1, user.getYonghu());
		         ps.setString(2, user.getPassword());
		         ResultSet res=ps.executeQuery();
		         if(res.next()){
		        	if(user.getYonghu().equals(res.getString("yonghu")) && user.getPassword().equals(res.getString("password"))){
		        	System.out.println("登录成功，跳转宠物页面！");
		        	PetLogin PetLogin=new PetLogin();
		        	PetLogin.PetLogin();
		             }
		        	
		         }
		         else{
		         	 System.err.println("登录失败，返回上一级！");
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

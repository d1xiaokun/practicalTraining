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
		System.out.println("��ӭ�����¼����");
		System.out.println("�������û�����");
		user.setYonghu(userInput.nextLine().trim());
		int num=0;
		while(user.getYonghu().equals("")) {
			if(num>=3){
				System.err.println("�û�������������࣬�����Ż�ϵͳ��ҳ��");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("�������û���Ϊ�գ����������룡");
			user.setYonghu(userInput.nextLine().trim());
			num++;
			}
		
		System.out.println("���������룺(6-16λ)");
	    user.setPassword(userInput.nextLine().trim());
	    VerifyPassword VerifyPassword=new VerifyPassword();
	    int VerifyPasswordNum=VerifyPassword.VerifyPassword(user.getPassword());
	    while(VerifyPasswordNum==0||VerifyPasswordNum==1) {	
	    	if(VerifyPasswordNum==0){
	    		System.err.println("����������Ϊ�գ����������룡");
			    user.setPassword(userInput.nextLine().trim());
	    	}
	    	if(VerifyPasswordNum==1){
	    		System.err.println("���������볤�Ȳ�����6-16λ��");
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
		        	System.out.println("��¼�ɹ�����ת����ҳ�棡");
		        	PetLogin PetLogin=new PetLogin();
		        	PetLogin.PetLogin();
		             }
		        	
		         }
		         else{
		         	 System.err.println("��¼ʧ�ܣ�������һ����");
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

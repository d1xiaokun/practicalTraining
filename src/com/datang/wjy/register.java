package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class register {
	public void register() throws Exception{
		Scanner userInput =new Scanner(System.in);
		User user=new User();  
		System.out.println("��ӭ����ע�����");
		System.out.println("�������û�����");
		user.setYonghu(userInput.nextLine().trim());
		int num=0;
		while(user.getYonghu().equals("")) {
			if(num>=3){
				System.err.println("�û�������������࣬�����Ż��û�ϵͳ��ҳ��");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("�������û���Ϊ�գ����������룡");
			user.setYonghu(userInput.nextLine().trim());
			num++;
			}
		System.out.println("�������ֻ��ţ�");
		user.setPhone(userInput.nextLine().trim()); 
		VerifyPhone verifyPhone=new VerifyPhone();
	    int verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
	    while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
		if(verifyPhoneNum==0){
			System.err.println("������ĺ���Ϊ�գ�");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==1){
			System.err.println("������ĺ��벻���Ϲ���11λ����");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==2){
			System.err.println("������ĺ��벻��ȷ��");
			user.setPhone(userInput.nextLine().trim());
			verifyPhoneNum=verifyPhone.VerifyPhone(user.getPhone().trim());
		}else if(verifyPhoneNum==3){			
		}
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
	    
	    System.out.println("�����ȷ�����룺");
	    String confirmPassword=userInput.nextLine().trim();
	    while(!user.getPassword().equals(confirmPassword)) {			
			System.err.println("�������벻һ�£����������룡��");
			user.setPassword(userInput.nextLine().trim());
			VerifyPassword =new VerifyPassword();
			VerifyPasswordNum=VerifyPassword.VerifyPassword(user.getPassword());
			while(VerifyPasswordNum==0||VerifyPasswordNum==1){
				if(VerifyPasswordNum==0){
					System.err.println("����������Ϊ�գ����������룡");
					user.setPassword(userInput.nextLine().trim());
				}if(VerifyPasswordNum==1){
			       System.err.println("���������벻����6-16λ��");
			       user.setPassword(userInput.nextLine().trim());
			}
			}
			 System.out.println("�����ȷ�����룺");
			 confirmPassword=userInput.nextLine();
			}
	    System.out.println("���Դ����ݿ�");
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
        	System.out.println("ע��ɹ�����ת��¼ҳ�棡");
        	login login=new login();
        	login.login();
         }
        else{
       	System.err.println("ע��ʧ�ܣ�������һ����");
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


package com.datang.wjy;

import java.util.Scanner;

import com.datang.linyukun.Main;

public class enter {
	public void enter() throws Exception {
	Scanner userInput =new Scanner(System.in);
	User user=new User();  
	System.out.println("��¼������1��");		
    System.out.println("ע��������2��");
    System.out.println("�һ�����������3��");	
    System.out.println("�˳�ϵͳ������4��");
    System.out.println("������һ��������5");
    int loginchange=userInput.nextInt();
    if(loginchange==1){
    	login login=new login();
    	login.login();
    }else if(loginchange==2){
    	register register =new register();
    	register.register();
    }else if(loginchange==3){
    	findpassword  findpassword =new  findpassword();
    	findpassword.findpassword();
    }else if(loginchange==4){
    	System.out.println("�˳�ϵͳ��");
    }else if (loginchange==5) {
    	Main.Login();
	}
    else{
    	System.out.println("��������ȷ����(1-4)��");
    	enter();
    }
	} 
    
}

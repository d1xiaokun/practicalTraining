package com.datang.wjy;

import java.util.Scanner;

import com.datang.linyukun.Main;

public class enter {
	public void enter() throws Exception {
	Scanner userInput =new Scanner(System.in);
	User user=new User();  
	System.out.println("登录请输入1：");		
    System.out.println("注册请输入2：");
    System.out.println("找回密码请输入3：");	
    System.out.println("退出系统请输入4：");
    System.out.println("返回上一级请输入5");
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
    	System.out.println("退出系统！");
    }else if (loginchange==5) {
    	Main.Login();
	}
    else{
    	System.out.println("请输入正确数字(1-4)！");
    	enter();
    }
	} 
    
}

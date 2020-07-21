package com.datang.wyh;

import java.util.Scanner;

import com.datang.wjy.enter;
import com.datang.wjy.pet;

public class PetLogin {
	public void PetLogin() throws Exception {
	Scanner userInput = new Scanner(System.in);
	System.out.println("   宠物交易模块请输入1");
	System.out.println("   宠物信息管理请输入2");
	System.out.println("   返回上一级请输入quit");
	String adminChange = userInput.nextLine();
	System.out.println(adminChange);
	if (adminChange.equals("1")) {
		pet pet = new pet();
		pet.pet();
	} else if (adminChange.equals("2")) {
		PetSystem PetSyste=new PetSystem();
		PetSystem.PetSystem();
	}else if(adminChange.equals("quit")){
    	System.out.println("返回上一级");
    	enter enter=new enter();
	    enter.enter();
	}else if  (adminChange.equals("5")) {
		System.err.println("请正确输入！");
		PetLogin();
	}
}
	}

package com.datang.wyh;

import java.util.Scanner;

import com.datang.wjy.enter;
import com.datang.wjy.pet;

public class PetLogin {
	public void PetLogin() throws Exception {
	Scanner userInput = new Scanner(System.in);
	System.out.println("   ���ｻ��ģ��������1");
	System.out.println("   ������Ϣ����������2");
	System.out.println("   ������һ��������quit");
	String adminChange = userInput.nextLine();
	System.out.println(adminChange);
	if (adminChange.equals("1")) {
		pet pet = new pet();
		pet.pet();
	} else if (adminChange.equals("2")) {
		PetSystem PetSyste=new PetSystem();
		PetSystem.PetSystem();
	}else if(adminChange.equals("quit")){
    	System.out.println("������һ��");
    	enter enter=new enter();
	    enter.enter();
	}else if  (adminChange.equals("5")) {
		System.err.println("����ȷ���룡");
		PetLogin();
	}
}
	}

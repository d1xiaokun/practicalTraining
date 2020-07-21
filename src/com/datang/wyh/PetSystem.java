package com.datang.wyh;
import java.util.Scanner;

import com.datang.wjy.enter;
import com.datang.wjy.pet;

public class PetSystem {
	public static void PetSystem() throws Exception {
		Scanner userInput = new Scanner(System.in);
		System.out.println("========宠物信息管理========");
		System.out.println("   添加宠物信息请输入1");
		System.out.println("   查询宠物信息请输入2");
		System.out.println("   修改宠物信息请输入3");
		System.out.println("   删除宠物信息请输入4");
		System.out.println("   返回上一级请输入quit");
		String adminChange = userInput.nextLine();
		System.out.println(adminChange);
		if (adminChange.equals("1")) {
			AddPet addPet = new AddPet();
			addPet.AddPet();
		} else if (adminChange.equals("2")) {
			SelectPet selectPet = new SelectPet();
			selectPet.SelectPet();
		} else if (adminChange.equals("3")) {
			ModifyPet modifyPet = new ModifyPet();
			modifyPet.ModifyPet();
		} else if (adminChange.equals("4")) {
			DeletePet deletePet= new DeletePet();
			deletePet.DeletePet();
		}else if(adminChange.equals("quit")){
        	System.out.println("返回上一级");
        	PetLogin PetLogin=new PetLogin();
        	PetLogin.PetLogin();
		}else if  (adminChange.equals("5")) {
			System.err.println("请正确输入！");
			PetSystem();
		}
	}

}

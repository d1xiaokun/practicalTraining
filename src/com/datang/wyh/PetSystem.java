package com.datang.wyh;
import java.util.Scanner;

import com.datang.wjy.enter;
import com.datang.wjy.pet;

public class PetSystem {
	public static void PetSystem() throws Exception {
		Scanner userInput = new Scanner(System.in);
		System.out.println("========������Ϣ����========");
		System.out.println("   ��ӳ�����Ϣ������1");
		System.out.println("   ��ѯ������Ϣ������2");
		System.out.println("   �޸ĳ�����Ϣ������3");
		System.out.println("   ɾ��������Ϣ������4");
		System.out.println("   ������һ��������quit");
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
        	System.out.println("������һ��");
        	PetLogin PetLogin=new PetLogin();
        	PetLogin.PetLogin();
		}else if  (adminChange.equals("5")) {
			System.err.println("����ȷ���룡");
			PetSystem();
		}
	}

}

package com.datang.wjy;

import java.util.Scanner;

public class pet {
     public static void pet() throws Exception{
    	    Scanner userInput=new Scanner(System.in);
	  		System.out.println("======������ｻ�׽���======");
	  		System.out.println("��������������1��");		
	        System.out.println("��ѯ����������2��");
	        System.out.println("ɾ������������3��");
	        System.out.println("�鿴���ｻ����Ϣ������4��");
	        System.out.println("������һ��������quit��");
	        String pet=userInput.nextLine();
	        if(pet.equals("1")){
	        	establish establish=new establish();
	        	establish.establish();
	        }else if(pet.equals("2")){
	        	inquire inquire=new inquire();
	        	inquire.inquire();
	        }else if(pet.equals("3")){
	        	delete delete=new delete();
	        	delete.delete();
	        }else if(pet.equals("4")){
	        	examine examine=new examine();
	        	examine.examine();
	        }else if(pet.equals("quit")){
	        	System.out.println("������һ��");
	        	enter enter=new enter();
			    enter.enter();
			        
	        }
     }
}

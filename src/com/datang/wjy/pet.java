package com.datang.wjy;

import java.util.Scanner;

public class pet {
     public static void pet() throws Exception{
    	    Scanner userInput=new Scanner(System.in);
	  		System.out.println("======进入宠物交易界面======");
	  		System.out.println("创建订单请输入1：");		
	        System.out.println("查询订单请输入2：");
	        System.out.println("删除订单请输入3：");
	        System.out.println("查看宠物交易信息请输入4：");
	        System.out.println("返回上一级请输入quit：");
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
	        	System.out.println("返回上一级");
	        	enter enter=new enter();
			    enter.enter();
			        
	        }
     }
}

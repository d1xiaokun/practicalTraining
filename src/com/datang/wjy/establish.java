package com.datang.wjy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class establish {
	public void establish() throws Exception{
		System.out.println("欢迎进入创建订单界面");
		Scanner userInput =new Scanner(System.in);
		deal deal=new deal();  
		System.out.println("请输入甲方：");
		deal.setJyjf(userInput.nextLine().trim());
		int num=0;
		while(deal.getJyjf().equals("")) {
			if(num>=3){
				System.err.println("甲方输入次数过多，即将放回宠物系统首页！");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("您输入甲方名为空，请重新输入！");
			deal.setJyjf(userInput.nextLine().trim());
			num++;
			}
		System.out.println("请输入乙方：");
		deal.setJyyf(userInput.nextLine().trim()); 
		int num1=0;
		while(deal.getJyjf().equals("")) {
			if(num1>=3){
				System.err.println("已方输入次数过多，即将放回宠物系统首页！");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("您输入已方名为空，请重新输入！");
			deal.setJyjf(userInput.nextLine().trim());
			num1++;
			}		
		System.out.println("请输入订单号号：");
		deal.setDdnumber(userInput.nextLine().trim());  
	    System.out.println("可以传数据库");
	    try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superone","root","root");
	        String sql="INSERT INTO jyxx(jyjf,jyyf,ddnumber)VALUE(?,?,?)";
	        PreparedStatement ps=con.prepareStatement(sql);
	        ps.setString(1, deal.getJyjf());
	        ps.setString(2, deal.getJyyf());
	        ps.setString(3, deal.getDdnumber());
	        int res=ps.executeUpdate();
	         if(res!=0){
	        	System.out.println("创建成功，跳转宠物页面！");
	        	pet pet=new pet();
	        	pet.pet();
	         }
	        else{
	       	System.err.println("创建失败！");
	       	pet pet=new pet();
        	pet.pet();
	        }
			
	        con.close();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	   
}

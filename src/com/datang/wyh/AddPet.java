package com.datang.wyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AddPet {

	public void AddPet() throws Exception {
		// TODO Auto-gsenerated method stub

		Scanner userInput = new Scanner(System.in);
		Pet pet = new Pet();
		System.out.println("======添加宠物信息====");
		System.out.println("请输入宠物号：");

		pet.setPetnumber(userInput.nextLine().trim());
		System.out.println(pet.getPetnumber());
		int num = 0;
		while (pet.getPetnumber().equals("")) {
			if (num >= 3) {
				// 跳转回首页
				System.err.println("宠物号输入次数过多，即将返回宠物信息管理首页");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}
				System.err.println("您输入的宠物号为空！请重新输入！");
				pet.setPetnumber(userInput.nextLine().trim());
				num++;
		}

		System.out.println("请输入宠物姓名：");
		pet.setPetname(userInput.nextLine());
		System.out.println(pet.getPetname());

		System.out.println("请输入宠物年龄：");
		pet.setPetage(userInput.nextLine());

		System.out.println("请输入宠物性别：");
		pet.setPetsex(userInput.nextLine());

		System.out.println("请输入宠物品种：");
		pet.setPetvariety(userInput.nextLine());

		System.out.println("请输入宠物病例：");
		pet.setPetcase(userInput.nextLine());

		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库链接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 定义sql
			String sql = "INSERT INTO pet(petnumber,petname,petage,petsex,petvariety,petcase)VALUE(?,?,?,?,?,?)";
			// 获取执行sql的对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 插入数据
			ps.setString(1, pet.getPetnumber());
			ps.setString(2, pet.getPetname());
			ps.setString(3, pet.getPetage());
			ps.setString(4, pet.getPetsex());
			ps.setString(5, pet.getPetvariety());
			ps.setString(6, pet.getPetcase());

			int res = ps.executeUpdate();

			if (res != 0) {
				System.out.println("添加成功，即将返回上一级！");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			} else {
				System.out.println("添加失败，即将返回上一级！");
				PetSystem petSystem = new PetSystem();
				petSystem.PetSystem();
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

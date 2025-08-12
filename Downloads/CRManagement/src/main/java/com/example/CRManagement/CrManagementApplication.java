package com.example.CRManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class CrManagementApplication {

	public static void main(String[] args) {


//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(url,username,password);
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from ");
//			while(resultSet.next()){
//				System.out.println(resultSet);
//			}
//			connection.close();
//
//		} catch(Exception e){
//			System.out.println(e);
//
//		}

		SpringApplication.run(CrManagementApplication.class, args);
	}

}

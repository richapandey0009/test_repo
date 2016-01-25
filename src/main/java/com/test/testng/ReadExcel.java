package com.test.testng;

import java.io.File;
import java.io.FileInputStream;




import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ReadExcel {
	
	public static void main(String []args){
		try{
			File src = new File("C:/Users/RICHA P/Downloads/Readexcel.xlsx");	
			
		FileInputStream fis = new FileInputStream(src);
		 Workbook workbook = new XSSFWorkbook(fis);
		 Sheet sh1 = workbook.getSheetAt(0);
		 
		 WebDriver driver = new FirefoxDriver();
		 
		 String loginName;
		 String password;
		 
		 System.out.println("Enter your operation:");
		 System.out.println("1-->login Gmail");
		 System.out.println("2-->login Facebook");
		 System.out.println("3-->login naukari");
		 
		 @SuppressWarnings("resource")
		Scanner operation = new Scanner(System.in);
		 int input = operation.nextInt();
		 
		// String inputEntered;
		 
		 switch(input){
		 case 1: input = 1;
		 	loginName = sh1.getRow(1).getCell(1).getStringCellValue();
			password =  sh1.getRow(1).getCell(2).getStringCellValue();
			
			driver.get("https://www.gmail.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("Email")).sendKeys(loginName);
			driver.findElement(By.id("next")).submit();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys(password);
			driver.findElement(By.id("signIn")).submit();
			break;
			
		 case 2: input = 2;
		 	loginName = sh1.getRow(2).getCell(1).getStringCellValue();
			password =  sh1.getRow(2).getCell(2).getStringCellValue();
			
			driver.get("https://www.facebook.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys(loginName);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.id("u_0_l")).submit();
			break;
			
		 case 3: input = 3;
		 	loginName = sh1.getRow(3).getCell(1).getStringCellValue();
			password =  sh1.getRow(3).getCell(2).getStringCellValue();
			
			driver.get("https://login.naukri.com/nLogin/Login.php?msg=0&URL=http%3A%2F%2Fmy.naukri.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("emailTxt")).sendKeys(loginName);
			driver.findElement(By.id("pwd1")).sendKeys(password);
			driver.findElement(By.id("sbtLog")).submit();
			break;
		 
		 
		 }

		//System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
		//System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());

		//driver.close();

		workbook.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

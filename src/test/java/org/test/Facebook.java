package org.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook extends Baseclass {
	
	public static void main(String[] args) throws IOException {
		Facebook f = new Facebook();
		f.browserConfig();
		f.openUrl("https://www.facebook.com/");
	     WebElement txtemail = f.locateById("email");
	     f.txtInput(txtemail,f.excelRead("C:\\Users\\jasfer john\\eclipse-workspace\\Reusable\\Excel\\students excel.xlsx", "sheet1", 3, 1));
	     WebElement txtpass = f.locateById("pass");
	     f.txtInput(txtpass, f.excelRead("C:\\Users\\jasfer john\\eclipse-workspace\\Reusable\\Excel\\students excel.xlsx", "Sheet1", 10, 2));
	     WebElement login = f.btnLogin("login");
	     login.click();
	     
		
		
		
	     
		
	}

}

package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	 
	
	WebDriver driver;
	public void browserConfig() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public void openUrl(String url) {
		driver.get(url);

	}
	public  WebElement locateById(String id) {
		WebElement txtemail = driver.findElement(By.id(id));
		return txtemail;

	}
	public  void txtInput(WebElement element,String value) {
		element.sendKeys(value);
		
			}
	public WebElement btnLogin(String name) {
		WebElement login = driver.findElement(By.name(name));
		return login;
	
	}
	
	public WebElement click(WebElement element) {
		element.click();
		return element;
	}
	
public String ExcelWrite(String Url,String Sheet,int row,int cell,String value) throws IOException {
        String value1= null;
		File f = new File(Url);
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(Sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);

		  c.setCellValue(value1);
		   FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		return value1;
		   }		
		public String excelRead(String path,String Sheet,int row,int cell) throws IOException {
			String Value = null;
			File f = new File(path);
			FileInputStream fin = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fin);
			Sheet s = w.getSheet(Sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			System.out.println(c);
			int cellType = c.getCellType();
			System.out.println(cellType);
			if (cellType==1) {
				c.getStringCellValue();
				System.out.println(Value);
				
			}
			
			else if (cellType==0) {
				if(DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
					 Value = sim.format(dateCellValue);
					System.out.println(Value);
				}else {
					double numericCellValue = c.getNumericCellValue();
					long l =(long)numericCellValue;
					Value = String.valueOf(1);
					System.out.println(Value);
				}
					
				}
			return Value;
			}
}
			
			



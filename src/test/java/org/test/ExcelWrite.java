package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite extends Facebook{
	
public ExcelWrite(String Url,String Sheet,int row,int cell,String value) throws IOException {
	


		
		File f = new File(Url);
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(Sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);

		  c.setCellValue(value);
		   FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	
	   
}		
		
			
}


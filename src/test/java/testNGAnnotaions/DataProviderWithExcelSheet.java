package testNGAnnotaions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcelSheet
{
	@Test
	@DataProvider(name = "getdata")
	public String[][] getdata() throws IOException
	{
		File excelfile=new File("C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumOverallTestNGFrameWork\\data\\input.xlsx");
		System.out.println(excelfile.exists());
		FileInputStream fis=new FileInputStream(excelfile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//System.out.println(sheet.getPhysicalNumberOfRows());
		int noRows=sheet.getLastRowNum();
		int noColums=sheet.getRow(0).getLastCellNum();
		String[][] data =new String[ noRows][noColums];
		for(int i=0;i<noRows;i++)
		{
			for(int j=0;j<noColums;j++)
			{
				DataFormatter dataformate=new DataFormatter();
				data[i][j]=dataformate.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}	
		//workbook.close();
		fis.close();
		
//		for (String[] dataArr : data) 
//		{
//			System.out.println(Arrays.toString(dataArr));
//		}
//		
		return data;
		
		
	}
}

package testnglearning;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class TestParameterization {//later TestUtil in utilities
	// i guess code from net
	
	
	@DataProvider(name = "dp",parallel = true)// parallel = true for parallel execution
	public Object[][] getData(Method m) {  //Method class from reflection api
		
		String sheetName = m.getName();// sheetName to get
		System.out.println("SheetName is : "+sheetName);
		ExcelReader excel = new ExcelReader("D:\\workspaces\\Batch25thJuly2020Selenium\\SeleniumTestingMVN\\src\\test\\resources\\excel\\testdata.xlsx");
		// path where sheet is stored in excel folder/package
		
		int rowNum = excel.getRowCount(sheetName);// count of rows
		int colNum = excel.getColumnCount(sheetName);// count of col
		
		
		System.out.println("Total rows are : "+rowNum+"----Total cols are : "+colNum);
		
		System.out.println("Test Data : "+excel.getCellData(sheetName, 0, 2));
		
		Object[][] data = new Object[rowNum-1][colNum];//rowNum-1?
		/*
		data[0][0]=excel.getCellData(sheetName, 0, 2);
		data[0][1]=excel.getCellData(sheetName, 1, 2);
		
		data[1][0]=excel.getCellData(sheetName, 0, 3);
		data[1][1]=excel.getCellData(sheetName, 1, 3);
		
		data[2][0]=excel.getCellData(sheetName, 0, 4);
		data[2][1]=excel.getCellData(sheetName, 1, 4);
		*/
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				
				//data[1][0] = excel.getCellData(sheetName, 0, 3);
				
				data[rows-2][cols]=excel.getCellData(sheetName, cols, rows);//rows-2?
				//in video it is [rowNum-2] instead of [rows -2]
				
			}
			
			
		}
		
		
		return data;
		
		
	}

}

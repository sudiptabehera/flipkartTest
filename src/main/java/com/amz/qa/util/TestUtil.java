package com.amz.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.amz.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=70;
	public static long IMPLICIT_WAIT=40;//wait before throwing an exception like noSuchElementFound
	public static String TESTDATA_SHEET_PATH ="D:\\Users\\Sudipta Behera\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\contact_testdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {//switch to a different frame
		driver.switchTo().frame("mainpanel");
	}
	public void switchToWindow(boolean closeOldWindow) {
	    

	    final String currentWindow = driver.getWindowHandle();
	    

	    // switch to first window that is not equal to the current window
	    String newWindow = null;
	    for (final String handle : driver.getWindowHandles()) {
	        if (!currentWindow.equals(handle)) {
	            newWindow = handle;
	            break;
	        }
	    }

	    // if there's another window found...
	    if (newWindow != null) {
	        if (closeOldWindow) {
	            // close the current window
	            driver.close();
	        }
	        // ...switch to the new window
	        driver.switchTo().window(newWindow);
	    }
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
			
		try {
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for( int i=0; i<sheet.getLastRowNum();i++) {
			for( int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}



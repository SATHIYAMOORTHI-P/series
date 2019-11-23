package org.lab.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lab.hooks.Hooks;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait wait;
	
	public static boolean elementFound( WebElement element) {
		boolean res = false;
		//driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		try {
		res = element.isDisplayed();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return res;
		}
	
	public static void send(WebElement element,String name) {
		//boolean elementFound=false;
		if (name != null && elementFound(element)) {
			element.clear();
			element.sendKeys(name);
		}
			
	}
	
	
public static void enter() throws AWTException {
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void move(WebElement e) {
Actions ac=new Actions(Hooks.driver);
ac.moveToElement(e).perform();
		
	}
	public static List<HashMap<String,String>> getData(){
	
	List<HashMap<String,String>>mp=new ArrayList<HashMap<String,String>>();
	
	try {
		File f=new File("");
		FileInputStream ff=new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.getSheet("Sheet1");
		Row hr = s.getRow(0);
		for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(0);
			HashMap<String, String>m=new HashMap<String, String>();
			for (int j = 0; j <hr.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				
				switch (c.getCellType()) {
				case Cell.CELL_TYPE_STRING:
				m.put(hr.getCell(j).getStringCellValue(),c.getStringCellValue());
					break;

				case Cell.CELL_TYPE_NUMERIC:
					m.put(hr.getCell(j).getStringCellValue(),String.valueOf(c.getNumericCellValue()));
					break;
				}}	
		mp.add(m);
	}}
	catch(Throwable e) {
		e.printStackTrace();
	}
	return mp;	
	}	

public static void screenShot() throws IOException {
TakesScreenshot tk=(TakesScreenshot)Hooks.driver;
File source = tk.getScreenshotAs(OutputType.FILE);
File designation=new File("");
FileUtils.copyFile(source, designation);
}
public static void linkCount() throws IOException {
List<WebElement> link = Hooks.driver.findElements(By.tagName("a"));
int count=0;
for (WebElement x : link) {
	String a = x.getAttribute("href");
	URL u=new URL(a);
	URLConnection uc = u.openConnection();
	HttpURLConnection hp=(HttpURLConnection)uc;
	int i = hp.getResponseCode();
	if(i!=200) {
		count++;
		System.out.println(a);
	}
}
System.out.println(count);
}
public static boolean isElementPresent(List<WebElement> elements) {
	boolean isFound=false;
	try {
		WebElement e=elements.get(0);
		boolean b=e.isDisplayed();
		boolean b1=e.isEnabled();
	
	if(b&b1) {
		isFound=true;
	}

}
	catch (Throwable e) {
}
	return isFound;
}
public static boolean isElementPresentwithTime(List<WebElement> elements,int secs) {
	boolean isFound=false;
	for (int i = 0; i <secs; i++) {
		
	}
	try {
		WebElement e=elements.get(0);
		boolean b=e.isDisplayed();
		boolean b1=e.isEnabled();
	
	if(b&b1) {
		isFound=true;
	}

}
	catch (Throwable e) {
}
	return isFound;
}
public static void dataBase() {
Connection con=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","hr","Mithran4077");
	String sql="select * from employees";
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		String name = rs.getString("FIRST_NAME");
	}}
	catch(ClassNotFoundException e) {
		
		
	}
	catch (SQLException e) {
			}
	finally {
		try {
			con.close();
		}
		catch (SQLException e) {
		}
		}
	}

}







	
	
	
	
	


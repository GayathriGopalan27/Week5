package com.leaftaps.testng.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.ReadExcel;



public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String excelFileName;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void openAPP(String url, String username, String password) {
		System.out.println("Before Method Started");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Before Method ended");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
	}
	@AfterMethod
	public void closeApp()
	{
		System.out.println("After Method Started");
		driver.close();
		System.out.println("After Method Started");

	}
	@DataProvider(name ="ArrayData")
	public String[][] sendData()  throws IOException
	{
		
		String[][] array = ReadExcel.readExcelData(excelFileName);
		return array;
	}
		// Create 2 d array
		/*String[][] array =new String[2][3];
		array[0][0]="TestLeaf";
		array[0][1]="Gayathri";
		array[0][2]="Gopalan";
		array[1][0]="TestLeaf";
		array[1][1]="Merfina";
		array[1][2]="Paul";
            return array;	
		
	}*/
	

	

}

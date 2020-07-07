package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testng.base.ProjectSpecificMethod;

public class DuplicateLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setData()
	{
		excelFileName="TC003";
	}
	
@Test(dataProvider="ArrayData")
	public  void RCT003(String fname) throws InterruptedException {
	 System.out.println("@Test Method started for Duplicate lead");
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		//driver.findElementByXPath("//span[text()='Phone']").click();
		//driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		driver.findElementByXPath("((//label[text()='First name:'])[3]//following::input)[1]").sendKeys(fname);
		 driver.findElementByXPath("//button[contains(text(),'Find')]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
	}
}







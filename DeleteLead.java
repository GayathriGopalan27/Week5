package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testng.base.ProjectSpecificMethod;

public class DeleteLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setData()
	{
		excelFileName="TC002";
	}
	
@Test(dataProvider="ArrayData")
	public  void RCT002(String fname)  throws InterruptedException {
	 System.out.println("@Test Method started for Delete lead");
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		//driver.findElementByXPath("//span[text()='Phone']").click();
		//driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		driver.findElementByXPath("((//label[text()='First name:'])[3]//following::input)[1]").sendKeys(fname);
		 driver.findElementByXPath("//button[contains(text(),'Find')]").click();
		Thread.sleep(2000);
		String leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		 System.out.println("@Test Method started for Delete  lead");

	
}
}







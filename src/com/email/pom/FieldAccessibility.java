package com.email.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lib.ExcelLib;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class FieldAccessibility {

	private WebDriver driver;

	boolean status;

	@FindBy(id = "setupLink")
	private WebElement SetupLink;

	@FindBy(id = "Security_font")
	private WebElement SecurityControl;

	@FindBy(id = "FieldAccessibility_font")
	private WebElement FieldAccessibility;
	
	@FindBy(id = "zSelect")
	private WebElement RecordType;


	public FieldAccessibility(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public int FieldList (String RecrdType, String ObjectType, String ChooseView, String OutputSheetName, String OutputxlPath) throws Exception
	{
		driver.findElement(By.id("setupLink")).click();
		driver.findElement(By.id("Security_font")).click();
		driver.findElement(By.id("FieldAccessibility_font")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(ObjectType)).click();
		driver.findElement(By.linkText(ChooseView)).click();
		new Select (driver.findElement(By.id("zSelect"))).selectByVisibleText(RecrdType);
		Thread.sleep(5000);
		
		int RC = driver.findElements(By.xpath("//div[3]//table//tr")).size();
		
		System.out.println("Row Count is "+RC);
		
		for (int i = 6; i <= RC-1 ; i++)
		{
			int k = i-5;
			System.out.println("K is "+k);
			String field= driver.findElement(By.xpath("//div[3]//table//tr["+i+"]/th")).getText();
			ExcelLib.writeExcel(OutputxlPath, OutputSheetName, k, 0, field);
			System.out.println(field);
		}
		int NumberOfFileds = RC-6;
		return NumberOfFileds;
	}
}

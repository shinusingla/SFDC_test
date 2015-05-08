package com.email.pom;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//div[@id='User']//div[@class='displayName']//a")
	private WebElement User;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']/img")
	private WebElement Edit;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailBox;

	@FindBy(xpath = "//input [@type='button' and @value='Save All']")
	private WebElement Save;

	@FindBy(id = "transportOptionstransportEmail")
	private WebElement EmailRadio;

	@FindBy(id = "save")
	private WebElement Continue;

	@FindBy(xpath = "//input[@value='Email me a verification code']")
	private WebElement EmailMeButton;

	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement Logout;

	public FieldAccessibility(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean reset(String recordType, String ChooseView, )	throws InterruptedException {
		if (driver.getTitle().contains("salesforce.com - Enterprise Edition")) {
			SearchBox.click();
			SearchBox.sendKeys(UserName);
			SearchButton.click();
			Thread.sleep(8000);
			User.click();
			Edit.click();
			driver.switchTo().frame("contactInfoContentId");
			EmailBox.clear();
			EmailBox.sendKeys(email);
			Save.click();
			
			try
			{
				driver.switchTo().alert().accept();	
			}
			catch (NoAlertPresentException e)
			{
				e.printStackTrace();
			}
			Thread.sleep(6000);

			status = true;

		} else if (driver.getTitle().equals(
				"salesforce.com - Activation Required")) {
			try {
					EmailMeButton.click();
					Thread.sleep(40000);
			}
			catch (Exception e)
			{
			e.printStackTrace();	
			}
				SearchBox.click();
				SearchBox.sendKeys(UserName);
				SearchButton.click();
				Thread.sleep(8000);
				User.click();
				Edit.click();
				driver.switchTo().frame("contactInfoContentId");
				EmailBox.clear();
				EmailBox.sendKeys(email);
				Save.click();
				Thread.sleep(6000);
		}
		else {
			status= false;
		}
		Thread.sleep(6000);
		return status;
	}
}

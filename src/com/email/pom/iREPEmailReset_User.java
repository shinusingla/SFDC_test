package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class iREPEmailReset_User {

	private WebDriver driver;
	
	@FindBy(id = "userNavButton")
	private WebElement userNavLabel;

	@FindBy(xpath = "//h1 [@class='currentStatusUserName']/a")
	private WebElement UserName;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']/img")
	private WebElement Edit;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailBox;

	@FindBy(xpath = "//input [@type='button' and @value='Save All']")
	private WebElement Save;

	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement Logout;

	public iREPEmailReset_User(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void reset(String email) throws InterruptedException {
		UserName.click();
		Edit.click();
		
		driver.switchTo().frame("contactInfoContentId");

		EmailBox.clear();
		EmailBox.sendKeys(email);
		Save.click();
		Thread.sleep(6000);
		userNavLabel.click();
		Logout.click();
		Thread.sleep(8000);
	}
}

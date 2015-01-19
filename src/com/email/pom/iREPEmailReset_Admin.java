package com.email.pom;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iREPEmailReset_Admin {

	private WebDriver driver;

	boolean status;

	@FindBy(id = "userNavButton")
	private WebElement userNavLabel;

	@FindBy(id = "phSearchInput")
	private WebElement SearchBox;

	@FindBy(id = "phSearchButton")
	private WebElement SearchButton;

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

	public iREPEmailReset_Admin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean reset(String UserName, String email)	throws InterruptedException {
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

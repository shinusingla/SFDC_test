package com.email.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test_temp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://test.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("aayush.ravindran@abbvie.com.qa");
		driver.findElement(By.id("password")).sendKeys("abbvie789");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("setupLink")).click();
		driver.findElement(By.id("Security_font")).click();
		driver.findElement(By.id("FieldAccessibility_font")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.linkText("View by Record Types")).click();
		new Select (driver.findElement(By.id("zSelect"))).selectByVisibleText("Prescriber");
		Thread.sleep(5000);
		
		int RC = driver.findElements(By.xpath("//div[@id='fls_012A0000000eayv']/table//tr")).size();
		
		System.out.println(RC);
		
		for (int i = 6; i<RC; i++)
		{
			String field= driver.findElement(By.xpath("//div[@id='fls_012A0000000eayv']/table//tr["+i+"]/th")).getText();
			System.out.println(field);
					
		}
		
		driver.close();	
		
	}
}

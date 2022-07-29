package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class Homepage {
	
	WebDriver driver;
	
	
	public Homepage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[text()='From']")
	private WebElement source;
	

	
	public void m1(WebDriver driver) {
		
		driver.findElement(By.xpath(""));
		
	}

}

package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given("launch the {string}")
	public void launch_the(String browser) {
	  
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		
			
		}
	}
	@Given("Enter url {string}")
	public void enter_url(String url) {
	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@Then("login page should be displayed and title should contain {string}")
	public void login_page_should_be_displayed_and_title_should_contain(String string) {
		
		Assert.assertTrue(driver.getTitle().contains(string));
	 
	}
	@When("Enter valid username {string} and password {string}")
	public void enter_valid_username_and_password(String username, String password) {
     
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);

	}
	@When("Click on loginbutton")
	public void click_on_loginbutton() {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('submitButton').click();");
	   
	}
	@Then("Homepage should be displayed with Contact icon")
	public void homepage_should_be_displayed_with_contact_icon() {
		
		Assert.assertTrue(driver.getTitle().contains("Home"));
		WebElement contacts = driver.findElement(By.linkText("Contacts"));
		Assert.assertTrue(contacts.isDisplayed(), "contact is not displayed");
	   
	}
	@Then("Homepage should be displayed with Organization icon")
	public void homepage_should_be_displayed_with_organization_icon() {
	  

		Assert.assertTrue(driver.getTitle().contains("Home"));
		WebElement organizations = driver.findElement(By.linkText("Organizations"));
		Assert.assertTrue(organizations.isDisplayed(),"Org Not displayed on webpage");
		
	}

	@Then("Close the browser")
	public void close_the_browser() {
	   driver.close();
	}


}

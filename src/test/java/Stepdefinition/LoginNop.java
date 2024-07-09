package Stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class LoginNop {
	
	WebDriver driver ;
	
	@Given("the user is on the nopCommerce login page")
	public void the_user_is_on_the_nop_commerce_login_page() {
		driver = new ChromeDriver();
	    driver.get("https://demo.nopcommerce.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("gaddammounika30@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Mouni@1502");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		boolean status=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(status,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		boolean welcometext=driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).isDisplayed();
		Assert.assertEquals(welcometext,true);
		driver.quit();
	}


}

package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import base.BasePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLoginSwaglabs extends BasePO{

//	Test login feature
	@Given("Open the Para Bank Website")
	public void open_the_para_bank_website() throws Exception {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\sanke\\OneDrive\\Documents\\Selenium webdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			driver.manage().window().maximize();

			System.out.println("------------------------------------------------------------------------");
			System.out.println("Para Bank home page opened");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@When("Open the Register page and fill the form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void open_the_register_page_and_fill_the_form_with(String FirstName, String LastName, String Address, String City, String State, String ZipCode, String PhoneNo, String SSN, String UserName, String Password, String ConfirmPass) throws Exception{
		try {
			driver.findElement(By.partialLinkText("Register")).click();
			
			driver.findElement(By.id("customer.firstName")).sendKeys(FirstName);
			driver.findElement(By.id("customer.lastName")).sendKeys(LastName);
			driver.findElement(By.id("customer.address.street")).sendKeys(Address);
			driver.findElement(By.id("customer.address.city")).sendKeys(City);
			driver.findElement(By.id("customer.address.state")).sendKeys(State);
			driver.findElement(By.id("customer.address.zipCode")).sendKeys(ZipCode);
			driver.findElement(By.id("customer.phoneNumber")).sendKeys(PhoneNo);
			driver.findElement(By.id("customer.ssn")).sendKeys(SSN);
			driver.findElement(By.id("customer.username")).sendKeys(UserName);
			driver.findElement(By.id("customer.password")).sendKeys(Password);
			driver.findElement(By.id("repeatedPassword")).sendKeys(ConfirmPass);

			System.out.println("Register form is filled!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@When("Press the Register button")
	public void press_the_register_button() throws Exception {
		try {
			driver.findElement(By.cssSelector("input.button[value='Register']")).click();
			System.out.println("Register button pressed");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Then("Registered page will be visible with {string}")
	public void registered_page_will_be_visible_with(String UserName) throws Exception {
		String expectedHeader = "Welcome " + UserName;
		String expectedMsg = "Your account was created successfully. You are now logged in.";
		
		boolean condn1 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals(expectedHeader);
		boolean condn2 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals("Signing up is easy!");
		
		if(condn1) {
			if(driver.findElement(By.xpath("//p[text() = 'Your account was created successfully. You are now logged in.']")).getText().equals(expectedMsg)) {
				System.out.println("Your account was created successfully!");
			}
		}else if(condn2){
			if(driver.findElement(By.id("customer.username.errors")).getText().equals("This username already exists.")){
				System.out.println("------------------------------------------------------------------------");
				throw new Exception("This username already exists!");
			}
		}else {
			System.out.println("------------------------------------");
			throw new Exception("There is error in Account creation!");
		}
		
		System.out.println("--- Waiting for 5 Seconds ---");
		Thread.sleep(5000);
		
		driver.close();
	}
	

//	Test Login Functionality

	@When("Login to Para Bank website with {string} & {string}")
	public void login_to_para_bank_website_with(String UserID, String Password) throws Exception{
		Thread.sleep(5000);
		try {
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserID);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);

			System.out.println("Login details filled Successfully");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@And("Press the Login button")
	public void press_the_login_button() throws Exception {
		try {
			driver.findElement(By.cssSelector("input.button[value='Log In']")).click();
			System.out.println("Login button pressed");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Then("Bank Dashboard page will be visible")
	public void bank_dashboard_page_will_be_visible() throws Exception {
		String expectedHeader = "Accounts Overview";
		
		boolean condn1 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals(expectedHeader);
		boolean condn2 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals("Error!");
		
		if(condn1) {
			System.out.println("Logged in successfully!");
		}else if(condn2){
			if(driver.findElement(By.className("error")).getText().equals("An internal error has occurred and has been logged.")){
				System.out.println("------------------------------------------------------------------------");
				throw new Exception("An internal error has occurred and has been logged.");
			}
		}else {
			System.out.println("------------------------------------");
			throw new Exception("There is error in Account Logging!");
		}
		
		System.out.println("--- Waiting for 5 Seconds ---");
		Thread.sleep(5000);
		driver.close();
	}

	

//	Test Logout Functionality

	@Given("Logged in to Para Bank Website")
	public void logged_in_to_para_bank_website() throws Exception {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sanke\\OneDrive\\Documents\\Selenium webdrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sychoTester2");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@1234");
	
		System.out.println("------------------------------------------------------------------------");
		
		driver.findElement(By.cssSelector("input.button[value='Log In']")).click();
		
		System.out.println("--- Waiting for 5 Seconds ---");
		Thread.sleep(5000);
		
		String expectedHeader = "Accounts Overview";
		
		boolean condn1 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals(expectedHeader);
		boolean condn2 = driver.findElement(By.xpath("//h1[@class='title']")).getText().equals("Error!");
		
		if(condn1) {
			System.out.println("Logged in Successfully for logout!");
		}else if(condn2){
			if(driver.findElement(By.className("error")).getText().equals("An internal error has occurred and has been logged.")){
				System.out.println("------------------------------------------------------------------------");
				throw new Exception("An internal error has occurred and has been logged.");
			}
		}else {
			System.out.println("------------------------------------");
			throw new Exception("There is error in Account Logging!");
		}
		
	}

	@When("Select Logout option")
	public void select_logout_option() throws Exception {
		System.out.println("--- Waiting for 5 Seconds ---");
		Thread.sleep(5000);
		try {
			driver.findElement(By.partialLinkText("Log Out")).click();
			System.out.println("Logout option selected");
		}catch(Exception e) {
			throw new Exception("There is issue in Logout.");
		}
	}

	@Then("Redirected to Para Bank Website home page")
	public void redirected_to_para_bank_website_home_page() throws Exception {
		if(driver.findElement(By.xpath("//h2[text()= 'Customer Login']")).getText().equals("Customer Login")) {
			System.out.println("Logged out Successfully");
			System.out.println("------------------------------------------------------------------------");
		}else {
			System.out.println("You're not Logged out Successfully");
			System.out.println("------------------------------------------------------------------------");
			throw new Exception("You're not Logged out Successfully");
		}
		Thread.sleep(5000);

		driver.close();
	}

}

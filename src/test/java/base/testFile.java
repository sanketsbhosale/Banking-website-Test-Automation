package base;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class testFile extends BasePO {

	public static void main(String[] args) throws Exception {
		testFile tf = new testFile();
		tf.testRegister("sycho", "Tester", "111, st road, steveson bay", "Miami", "Florida", "40685", "8969852", "230493492", "sychoTester1", "Test@1234", "Test@1234");

	}
	
	public void testRegister(String FirstName, String LastName, String Address, String City, String State, String ZipCode, String PhoneNo, String SSN, String UserName, String Password, String ConfirmPass) throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sanke\\OneDrive\\Documents\\Selenium webdrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();

		System.out.println("------------------------------------------------------------------------");
		System.out.println("Para Bank home page opened");
		
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
	
		Thread.sleep(5000);

		System.out.println("Registered Successfully!");
		
		driver.findElement(By.cssSelector("input.button[value='Register']")).click();
		System.out.println("Register button pressed!");
		
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
}

}

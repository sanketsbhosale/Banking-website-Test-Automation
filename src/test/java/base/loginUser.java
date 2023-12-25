package base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginUser{
	
	public static ChromeDriver driver = null;
	
	@Test
	public void testLogin() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanke\\OneDrive\\Documents\\SeleniumDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
//		Using the XPath
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
//		Using the cssSelector
		driver.findElement(By.cssSelector("input[id='input-email']")).sendKeys("test463@gmail.com");
		driver.findElement(By.cssSelector("input[id='input-password']")).sendKeys("test@1234");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		String actualResult = driver.findElement(By.xpath("//A[contains(text(),'Edit your account information')]")).getText().toString();
		String expectedTitle = "Edit your account information";
		Assert.assertEquals(actualResult, expectedTitle);
		driver.close();
	}
	
	@Test
	public void testRegister() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanke\\OneDrive\\Documents\\SeleniumDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("abc");;
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("xyz");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test468@gmail.com");
		driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("123456789");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test@1234");
		driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("test@1234");
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")).getText().toString();
		String expectedTitle = "Your Account Has Been Created!";
		Assert.assertEquals(actualResult, expectedTitle);
		driver.close();
	}
}
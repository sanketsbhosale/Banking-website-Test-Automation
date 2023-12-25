package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BasePO implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		try {
			Thread.sleep(5000);
			driver.close();
			driver.quit();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

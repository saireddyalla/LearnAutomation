package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Facebook {
	 WebDriver driver;

    @Test(dataProvider="passData")
	public  void loginToFacebook(String username,String password) throws Exception
	{
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Facebook"),"user is not able to login - invalid credentails");
		System.out.println("page title verified-user is  able to login - valid credentails");
		driver.quit();
	}
	
    @DataProvider
    public Object[][] passData()
    {
    	Object[][] data=new Object[3][2];
    	data[0][0]="admin1";
    	data[0][1]="demo1";
    	
    	data[1][0]="9491108703.r@gmail.com";
    	data[1][1]="saireddy3484*";
    	
    	data[2][0]="admin2";
    	data[2][1]="demo1234";
    	
		return data;
    }
   
}

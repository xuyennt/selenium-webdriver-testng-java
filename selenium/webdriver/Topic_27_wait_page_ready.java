package webdriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_27_wait_page_ready {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
WebDriverWait explicitWait;
JavascriptExecutor jsExecutor;

Select select;
Random rand;
Alert alert;

@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
explicitWait = new WebDriverWait(driver,10);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
rand =  new Random();
jsExecutor = (JavascriptExecutor) driver;
//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Testproject() {
	driver.get("https://blog.testproject.io/");
	
	
}





@AfterClass
public void afterClass() {
//driver.quit();
	}

public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
}
}
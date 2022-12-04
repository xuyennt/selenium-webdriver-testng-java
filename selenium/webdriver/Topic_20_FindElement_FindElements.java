package webdriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
public class Topic_20_FindElement_FindElements {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
WebDriverWait explicitWait;



@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
explicitWait = new WebDriverWait(driver,10);

driver.get("http://live.techpanda.org/index.php/customer/account/login/");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_FindElement() {
	driver.findElement(By.cssSelector("input#email"));
	driver.findElement(By.cssSelector("input[type='email']")).sendKeys("xuyenhnue@gmail.com");
	
}


@Test
public void TC_02_FindElements() {
	List<WebElement> elements = driver.findElements(By.cssSelector("input#email"));
	System.out.println("List element number = " + elements.size());
	
	elements = driver.findElements(By.cssSelector("input[type='email']"));
	System.out.println("List element number = " + elements.size());
}


@Test
public void TC_03_Presence_I() {
	
	
	}


@AfterClass
public void afterClass() {
  driver.quit();
	}

public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
}
}
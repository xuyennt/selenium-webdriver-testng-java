package webdriver;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_12_alert {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;
Alert alert;

@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
rand =  new Random();

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Accept_Alert() {
	// bước 2 nhập vào url 
	driver.get("https://automationfc.github.io/basic-form/index.html");
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    sleepInSecond(3);
    alert = driver.switchTo().alert();
    //Accept 1 Alert
    alert.accept();
    sleepInSecond(3);
    Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
}


@Test
public void TC_02_Confirm_Alert() {
	driver.get("https://automationfc.github.io/multiple-fields/");
	
	
	
}
@Test
public void TC_03_Prompt_Alert() {

	
	}
@Test
public void TC_03_Authentication_Alert() {

	
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
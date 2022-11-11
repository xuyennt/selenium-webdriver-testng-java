package webdriver;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_17_window_tab {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();



//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_window() {
	// bước 2 nhập vào url 
	driver.get("https://automationfc.github.io/basic-form/index.html");
	// lay ra duoc id cua tab hien tai
	String parentPageWindowID = driver.getWindowHandle();
	System.out.println("Parent Page = " + parentPageWindowID);
	//click vao google link de bat ra 1 tab moi
	driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
	sleepInSecond(2);
	// lay ra tat ca cac ID ra
	Set<String> allWindowIDs = driver.getWindowHandles();
	System.out.println(allWindowIDs);
	
	// sau do dung vong lap duyet qua va kiem tra
	for(String id : allWindowIDs) {
		if(!id.equals(parentPageWindowID))
		{
			driver.switchTo().window(id);
			sleepInSecond(2);
		}
	}
	
	driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Selenium");
	sleepInSecond(2);
	
}
@Test
public void TC_02_dehieu() {
	driver.get("https://dehieu.vn/");
	
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
//random
public String getRandomEmailAddress() {
	Random rand = new Random();
	return "john" + rand.nextInt(99999) + "@gmail.com";
	
}


}
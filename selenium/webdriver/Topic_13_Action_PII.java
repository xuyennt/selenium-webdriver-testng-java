package webdriver;
import java.util.List;
import java.util.Random;

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
public class Topic_13_Action_PII {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;
Alert alert;
Actions action;

@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
rand =  new Random();
action = new Actions(driver);

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Drag_Drop_HTML4() {
	// bước 2 nhập vào url 
	driver.get("https://automationfc.github.io/kendo-drag-drop/");
	WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
	WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));
	action.dragAndDrop(smallCircle, bigCircle).perform();
	sleepInSecond(3);
	Assert.assertEquals(bigCircle.getText(), "You did great!");
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
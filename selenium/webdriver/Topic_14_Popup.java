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
public class Topic_14_Popup {
	
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
public void TC_01_popup() {
	// bước 2 nhập vào url 
	driver.get("https://ngoaingu24h.vn/");
	By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
	Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	//click vào button login
	driver.findElement(By.cssSelector("button.login_")).click();
	//popup login hien thi
	Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
	// nhap thong tin khong hop le
	driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("automationfc");
	driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("automationfc");
	driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-login-v1")).click();
	sleepInSecond(3);
	//Tên tài khoản không hợp lệ
	//verify error message hien thi
	Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
	
}
@Test
public void TC_01_Tiki() {
	// bước 2 nhập vào url 
	driver.get("https://tiki.vn/");
	
	
	
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
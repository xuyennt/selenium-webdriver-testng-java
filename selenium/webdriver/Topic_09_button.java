package webdriver;
import java.util.List;
import java.util.Random;

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
public class Topic_09_button {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;


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
public void TC_01_fahasa() {
	// bước 2 nhập vào url 
	driver.get("https://www.fahasa.com/customer/account/create");
	//li.popup-login-tab-login
	//chuyen qua tab login
	driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
	//verify dang nhap button is disabled
	
	Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
	//enter value to email/password textbox
	driver.findElement(By.cssSelector("input#login_username")).sendKeys("xuyennt@gmail.com");
	driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
	//verify dang nhap button laf enable
	Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
    //verify dang nhapj button mau do
	String rgbaColor = driver.findElement(By.cssSelector("button.fhs-btn-login")).getCssValue("background");
	System.out.println(rgbaColor);
	String hexaClor = Color.fromString(rgbaColor).asHex().toUpperCase();
	System.out.println(hexaClor);
	//verify backgroud color
	Assert.assertEquals(hexaClor, "#C92127");
}


@Test
public void TC_02_Dropdown() {
	
	
}
@Test
public void TC_03() {

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
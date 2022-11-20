package webdriver;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class Topic_18_Javasript_Executor {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
JavascriptExecutor jsExecutor;

Select select;


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
jsExecutor = (JavascriptExecutor) driver;


//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Tech_Panda() {
	// bước 2 nhập vào url 
	navigateToUrlByJs("http://live.techpanda.org/index.php/");
	sleepInSecond(5);
	//Assert.assertEquals(getDomainName(), "live.techpanda.org");
	//executeForBrowser("return document.URL;");
	Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
	Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/index.php/");
}
@Test
public void TC_02_dehieu() {
	
	
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
public void navigateToUrlByJs(String url) {
	jsExecutor.executeScript("Window.location = '" + url + "'");
}
public Object executeForBrowser(String javaScript) {
	return jsExecutor.executeScript(javaScript);
}

public String getDomainName() {
	return (String) jsExecutor.executeScript("return document.domain;");
}

}
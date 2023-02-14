package webdriver;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_25_Fluent_Wait {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
WebDriverWait explicitWait;
FluentWait<WebDriver>fluentDriver;


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
public void TC_01_Fluent() {
	driver.get("https://automationfc.github.io/dynamic-loading/");
	fluentDriver = new FluentWait<WebDriver>(driver);
	//set tong thoi gian va tan so
	fluentDriver.withTimeout(Duration.ofSeconds(15))
	   //1/3 giay check 1 lan
	  .pollingEvery(Duration.ofMillis(500))
	  .ignoring(NoSuchElementException.class);
	//Apply dieu kien
	fluentDriver.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.cssSelector("div#start>button"));
		}
		
	});
	
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
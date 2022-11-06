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
public class Topic_15_Popup3 {
	
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
public void TC_01_java_code_geek() {
	// bước 2 nhập vào url 
	driver.get("https://www.javacodegeeks.com/");
	sleepInSecond(15);
	//div.lepopup-popup-container>div:not([style*='display:none'])
	WebElement popup = driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style*='display:none'])"));
	//input[name='lepopup-20']
	if(popup.isDisplayed()) {
		//nhap email
		driver.findElement(By.cssSelector("input[name='lepopup-20']")).sendKeys(getRandomEmailAddress());
		sleepInSecond(3);
		driver.findElement(By.cssSelector("a[data-label='Get the Books']")).click();
		}
	//step 3
	driver.findElement(By.cssSelector("input#s")).sendKeys("Agile Testing Explained");
	sleepInSecond(3);
	driver.findElement(By.cssSelector("button.search-button")).click();
	sleepInSecond(3);
	Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='post-title']/a[text()='Agile Testing Explained']")).isDisplayed());
	
	
}
@Test
public void TC_02_dehieu() {
	driver.get("https://dehieu.vn/");
	sleepInSecond(10);
	WebElement popup = driver.findElement(By.cssSelector("div.popup-content"));
	if(popup.isDisplayed()) {
		driver.findElement(By.cssSelector("input#popup-name")).sendKeys("Jonh Wick");
		driver.findElement(By.cssSelector("input#popup-email")).sendKeys(getRandomEmailAddress());
		driver.findElement(By.cssSelector("input#popup-phone")).sendKeys("0986732105");
		sleepInSecond(3);
		driver.findElement(By.cssSelector("button#close-popup")).click();
	}
	
	driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
	driver.findElement(By.cssSelector("input#search-courses")).sendKeys("Khóa học Thiết kế tủ điện");
	driver.findElement(By.cssSelector("i.fa-search")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector("h4.name-course ")).getText(), "Khóa học Thiết kế tủ điện");
	
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
package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_05_Web_Browser {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
WebElement element;

String projectPath = System.getProperty("user.dir");


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");

// khoi tao
driver = new FirefoxDriver();

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Browser() {
	//dong trinh duyet hien tai(1 tab)
	driver.close();
    
	// dong browser nhieu tab
	driver.quit();
	
	// tim 1 element
	driver.findElement(By.cssSelector(""));
	
	// tim nhieiu element
	driver.findElements(By.cssSelector(""));
	
	// mo ra cai url truyen vao
	driver.get("");
	
	//tra ve 1 url tai page dang dung
	driver.getCurrentUrl();
	
	//source code cua page hien tai
	driver.getPageSource();
	
	// lay ra id cua tab/ window dang dung/active (windows/tab)
	driver.getWindowHandle();//1
	driver.getWindowHandles(); //all
	
	// cho element duoc tim thay trong khoang time xxs
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	
    
}


@Test
public void TC_02_Element() {
}
@Test
public void TC_03() {

	}

@AfterClass
public void afterClass() {
driver.quit();
	}
}
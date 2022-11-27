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
public class Topic_20_Element_Condition_Status {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
WebDriverWait explicitWait;

Select select;
Random rand;
Alert alert;

@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
explicitWait = new WebDriverWait(driver,10);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
rand =  new Random();

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Visible_Displayed_Visibility() {
	//1.Co tren UI (bat buoc)
	//2.Co trong HTML(bat buoc)
	// bước 2 nhập vào url 
	driver.get("https://www.facebook.com/");
	//wait cho email address textbox hien thi trong vong 10s
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    driver.findElement(By.id("email")).sendKeys("automationtest@gmail.net");
}


@Test
public void TC_02_Invisible_Undisplayed_Invisibility_I() {
	//2.khong co tren UI(bat buoc)
	//1.co trong HTML
	driver.get("https://www.facebook.com/");
    driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
  //wait cho re-enter email khong hien thi trong vong 10s
    explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	
}

@Test
public void TC_02_Invisible_Undisplayed_Invisibility_II() {
	//2.khong co tren UI(bat buoc)
	//2.khong co trong HTML
	driver.get("https://www.facebook.com/");
    
  //wait cho re-enter email khong hien thi trong vong 10s
    explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	
}
@Test
public void TC_03_Presence_I() {
	driver.get("https://www.facebook.com/");
	    //1.Co tren UI (bat buoc)
        //2.Co trong HTML(bat buoc)
		// bước 2 nhập vào url 
		driver.get("https://www.facebook.com/");
		//wait cho email address textbox hien thi trong vong 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
	
	}
@Test
public void TC_03_Presence_II() {
	//2.khong co tren UI(bat buoc)
	//1.co trong HTML
	driver.get("https://www.facebook.com/");
    driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
  //wait cho re-enter email khong hien thi trong vong 10s
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	
}

@AfterClass
public void afterClass() {
//driver.quit();
	}

public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
}
}
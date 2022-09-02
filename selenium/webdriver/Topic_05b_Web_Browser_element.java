package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_05b_Web_Browser_element {
	
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
public void TC_01_Current_Url() {
	driver.get("http://live.techpanda.org/");
	
	driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	
	//String loginPageUrl = driver.getCurrentUrl();
	
	//kiem tra dau vào đầu ra nó bằng nhau 
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	
	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    
}


@Test
public void TC_02_Page_Title() {
	//xoa du lieu trong 1 filed dang editable (co the nhap )
	// textbox/ text Area /
//	element.clear();
}
@Test
public void TC_03_Navigation() {

	}
public void TC_04_Page_Source() {

}

@AfterClass
public void afterClass() {
driver.quit();
	}
}
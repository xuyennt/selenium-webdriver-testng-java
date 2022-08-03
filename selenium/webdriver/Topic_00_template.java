package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_00_template {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
driver = new FirefoxDriver();

//bấm maximize  browser
driver.manage().window().maximize();


}

public void TC_01_() {
	// bước 2 nhập vào url 
	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	
	//<input class="is_required validate account_input form-control" 
	//data-validate="isEmail" 
   // type="text" id="email" 
    //name="email" value="">
	//xpath
	//input[@id='email']
	//input[@name='email']
	
	// bước 3 click vào my  account để mở trang login lên
	// tìm 1 element 
	driver.findElement(By.id("email"));
	driver.findElements(By.tagName("a"));
	//Link text   --text tuyet doi
	driver.findElement(By.linkText("New products"));
	
	
}


@Test
public void TC_02_() {

	}
@Test
public void TC_03() {

	}

@AfterClass
public void afterClass() {
driver.quit();
	}
}
package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_03_selenium_by {
	
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
@Test
public void TC_01() {
	// bước 2 nhập vào url 
	driver.get("http://live.techpanda.org/index.php/customer/account/login/");
	
//	<input type="email" 
//	autocapitalize="off"
//	autocorrect="off" 
//	spellcheck="false" 
//	name="login[username]" 
//	value="" id="email" 
//	class="input-text required-entry validate-email" title="Email Address">
	//xpath
	//input[@name='login[username]']
	driver.findElement(By.id("email"));
	//new-users
	driver.findElement(By.className("new-users"));
	driver.findElement(By.name("login[username]"));
	// Tagname tìm xem có bao nhiêu element/page 
    driver.findElement(By.tagName("a"));


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
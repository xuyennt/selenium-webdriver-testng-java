package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_06_textbox_textare {
	
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
public void TC_01_textbox_textarea() {
	// bước 2 nhập vào url 
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	// nhap user password
    driver.findElement(By.xpath("//input[@name='username']"));
   // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");//
    //click login
   // driver.findElement(By.xpath("//button[@type='submit']")).click();
    

}


@Test
public void TC_02_() {
}
@Test
public void TC_03() {

	}

@AfterClass
public void afterClass() {
//driver.quit();
	}
}
package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_04_Xpath2 {
	
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
public void Register_01_Empty_Data() {
	// bước 2 nhập vào url 
	driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	
	driver.findElement(By.id("txtFirstname")).sendKeys("");
	driver.findElement(By.id("txtEmail")).sendKeys("");
	driver.findElement(By.id("txtCEmail")).sendKeys("");
	driver.findElement(By.id("txtPassword")).sendKeys("");
	driver.findElement(By.id("txtCPassword")).sendKeys("");
	driver.findElement(By.id("txtPhone")).sendKeys("");
	driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
	//verify
	
	Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	
	
}
@Test
public void Register_02_Invalid_Email() {
}
@Test
public void Register_03_Incorrect_Email() {
}
@Test
public void Register_04_Password_Less_Than_6_chars() {
	
}
@Test
public void Register_05_Incorrect_Confirm_Password() {
}
@Test
public void Register_06_Invalid_Phone_Number() {
	//ttttr 
}

@AfterClass
public void afterClass() {
driver.quit();
	}
}
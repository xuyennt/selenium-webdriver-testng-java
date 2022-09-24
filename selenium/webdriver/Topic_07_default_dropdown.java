package webdriver;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_07_default_dropdown {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
rand =  new Random();

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Default_Dropdown() {
	// bước 2 nhập vào url 
	driver.get("https://demo.nopcommerce.com/");
	
	driver.findElement(By.cssSelector("a.ico-register")).click();
    driver.findElement(By.cssSelector("input#FirstName")).sendKeys("xuyen");
    //input#LastName
    driver.findElement(By.cssSelector("input#LastName")).sendKeys("nguyen");
    //select[name='DateOfBirthDay']
    //khoi tạo select thao tac dropdown
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
    //chọn item có text = 13
    select.selectByVisibleText("13");
    //làm sao biết chọn 13 rồi verify
   
   // Assert.assertEquals(select.getFirstSelectedOption().getText(), "13");
    //verify 1 dropdown là single hay multiple
   // Assert.assertFalse(select.isMultiple());
    
    //DateOfBirthMonth
    
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
    select.selectByVisibleText("May");
    
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
    select.selectByVisibleText("1993");
    
    String emailAddress = "xuyennt"+ rand.nextInt(99999) +"@gmail.com";
    
    driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
    
    driver.findElement(By.cssSelector("input#Company")).sendKeys("FPT");
    driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456"); 
    //button#register-button
    driver.findElement(By.cssSelector("button#register-button")).click();
    //Your registration completed
    
    Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
    
    driver.findElement(By.cssSelector("a.ico-account")).click();
    Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "xuyen");
    Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "nguyen");
    
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "13");
    
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "May");
    
    select= new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "1993");
    Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
    
    Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "FPT");
    
    
   
    
}


@Test
public void TC_02_Dropdown() {
	driver.get("https://rode.com/en/support/where-to-buy");
	select = new Select(driver.findElement(By.id("country"))) ;
	//Vietnam

	select.selectByValue("Vietnam");
	sleepInSecond(3);
     
	Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
	List<WebElement> dealers =  driver.findElements(By.cssSelector("div#map h4"));
	
	for(WebElement element : dealers) {
		System.out.println(element.getText());
	}
	
}
@Test
public void TC_03() {

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
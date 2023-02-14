package webdriver;
import java.io.File;
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
public class Topic_24_Explicit_Wait {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");
WebDriverWait explicitWait;
//Image name
String mot = "1.jpeg";
String hai = "2.jpeg";
String ba = "download.jpeg";
///selenium-webdriver-java-testng/UploadFiles
//upload file folder
String uploadFileFolderPath = projectPath + File.separator + "UploadFiles" + File.separator;
//image path
String motFilePath = uploadFileFolderPath + mot;
String haiFilePath = uploadFileFolderPath + hai;
String baFilePath = uploadFileFolderPath + ba;


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
//explicitWait = new WebDriverWait(driver,10);

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_02_Ajax_Loading() {
	driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
	//div.RadCalendar
	explicitWait = new WebDriverWait(driver,15);
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));
	//verify cho nhung ngay khong duoc chon ngay nao
	Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
	// wait cho ngay 19 duoc phep click
	explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='19']")));
	//clic vao ngay 19
	driver.findElement(By.xpath("//a[text()='19']")).click();
	//div[id*='RadCalendar1']>div.raDiv
	//wait cho Ajax icon loading bien mat
	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
	
	explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']/a[text()='19']")));
	
	Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, December 19, 2022");
	
}


@Test
public void TC_05_Upload_File() {
	driver.get("https://gofile.io/uploadFiles");
	// wait cho add files button duoc visible
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#rowUploadButton button.uploadButton")));
	driver.findElement(By.cssSelector("input[type='file']")).sendKeys(motFilePath + "\n" + haiFilePath + "\n" + baFilePath);
    //Your files have been successfully uploaded
	
}


@Test
public void TC_03_Enough_more_Time() {
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://automationfc.github.io/dynamic-loading/");
	driver.findElement(By.cssSelector("div#start>button")).click();
	//get text verify
	//div#finish>h4
	Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
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
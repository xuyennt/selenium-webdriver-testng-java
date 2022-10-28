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
public class Topic_13_Action {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;
Alert alert;
Actions action;

@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
rand =  new Random();
action = new Actions(driver);

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Hover() {
	// bước 2 nhập vào url 
	driver.get("https://automationfc.github.io/jquery-tooltip/");
	//hover vao element
	action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
	//div.ui-tooltip-content
	//Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");  // (driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"")
    
}


@Test
public void TC_02_Hover() {
	
	driver.get("https://www.myntra.com/");
	action.moveToElement(driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Kids']"))).perform();
	sleepInSecond(3);
	
	
	
}
@Test
public void TC_03_Hover() {
	driver.get("https://www.fahasa.com/");
	action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
	sleepInSecond(1);
	driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']")).click();
	//action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']"))).perform();
	sleepInSecond(3);
	Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']/li/strong")).getText(), "KỸ NĂNG SỐNG");
	
	}

@Test
public void TC_04_Click_and_Hold() {
	driver.get("https://automationfc.github.io/jquery-selectable/");
	//can thao tac voi 12 so
	 List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
	 System.out.println("Tong so luong number = " + listNumbers.size());
	//click vao so bat dau va giu chuot trai (chua nha chuot)
	 action.clickAndHold(listNumbers.get(0))
	 // di chuot den so ket thuc
	 .moveToElement(listNumbers.get(9))
	 //nha chuot trai ra
	 .release().perform();
	 sleepInSecond(3);
	 
	List<WebElement> listNumberSelect = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
	System.out.println("Tong so luong da chon = " + listNumberSelect.size());
	// verify ve so luong element da chon
	Assert.assertEquals(listNumberSelect.size(), 6);
	
	}
@Test
public void TC_04_Click_and_Hold_Random() {
	driver.get("https://automationfc.github.io/jquery-selectable/");
	//can thao tac voi 12 so
	 List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
	 System.out.println("Tong so luong number = " + listNumbers.size());
	//nhan crl xuong chua nha ra
	 action.keyDown(Keys.COMMAND).perform();
	 //click vao cac so can chon
	 action.click(listNumbers.get(1)).click(listNumbers.get(3)).click(listNumbers.get(10)).perform();
	 
	 sleepInSecond(3);
	 
	 // nha phim ctrl ra
	 action.keyDown(Keys.COMMAND).perform();
	
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
}
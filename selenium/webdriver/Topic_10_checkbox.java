package webdriver;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_10_checkbox {
	
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
public void TC_01_JotForm() {
	// bước 2 nhập vào url 
	driver.get("https://automationfc.github.io/multiple-fields/");
	//chon checkbox  Cancer 
	// 1 là -- //input[@value='Cancer']
	//2là -- //label[contains(text(),'Cancer')]/preceding-sibling::input
//	driver.findElement(By.xpath("//input[@value='Cancer']")).click();
//	driver.findElement(By.xpath("//input[@value='Fainting Spells']")).click();
	checkToCheckboxOrRadio("//input[@value='Cancer']");
	checkToCheckboxOrRadio("//input[@value='Fainting Spells']");
	
	//verify no duoc chon thanh cong
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cancer']")).isSelected());
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Fainting Spells']")).isSelected());
	
	// chon radio //input[@value='5+ days']   1-2 cups/day
	driver.findElement(By.xpath("//input[@value='5+ days']")).click();
	driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).click();
	//verify chon thanh cong
	
	//bo chon
	driver.findElement(By.xpath("//input[@value='Cancer']")).click();
	driver.findElement(By.xpath("//input[@value='Fainting Spells']")).click();
	//verify bo chon thanh cong
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cancer']")).isSelected());
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Fainting Spells']")).isSelected());
	
	
}


@Test
public void TC_02_Jotform_Select_All() {
	driver.get("https://automationfc.github.io/multiple-fields/");
	
	List<WebElement> allCheckboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
	// dung vong lap de duyet qua va click chon
	for(WebElement checkbox : allCheckboxes) {
		if(!checkbox.isSelected()) {
			checkbox.click();
			//sleepInSecond(1);
			}
	}
	//dung vong lap de kiem tra va duyet qua
	for(WebElement checkbox : allCheckboxes) {
		Assert.assertTrue(checkbox.isSelected());
	}
	//bo chon het
	for(WebElement checkbox : allCheckboxes) {
		uncheckToCheckbox(checkbox);
	}
	
	
}
@Test
public void TC_03() {

	}
public void checkToCheckboxOrRadio(String xpathLocator) {
	if(!driver.findElement(By.xpath(xpathLocator)).isSelected()) {
		driver.findElement(By.xpath(xpathLocator)).click();
	}
}
public void uncheckToCheckbox(String xpathLocator) {
	if(driver.findElement(By.xpath(xpathLocator)).isSelected()) {
		driver.findElement(By.xpath(xpathLocator)).click();
	}
}
public void uncheckToCheckbox(WebElement element) {
	if(element.isSelected()) {
		System.out.println("Click to element: " + element);
		element.click();
	}
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
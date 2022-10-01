package webdriver;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_08_custom_dropdown2 {
			
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
WebDriverWait explicitWait;	
//khai bao +  khoi taoj
String projectPath = System.getProperty("user.dir");
String osName = System.getProperty("os.name");

Select select;
Random rand;


@BeforeClass
public void beforeClass() {
	//b1 mở browsers lên 
System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//khoi tao 
driver = new FirefoxDriver();
//khoi tao wait
explicitWait = new WebDriverWait(driver, 30);

//bấm maximize  browser
driver.manage().window().maximize();


}
@Test
public void TC_01_Custom_Dropdown() {
	
	// bước 2 nhập vào url 
	driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	//span#number-button
	
//	selectItemInCustomDropdown("span#number-button","ul#number-menu div","7");
//	sleepInSecond(3);
//  
//	selectItemInCustomDropdown("span#number-button","ul#number-menu div","5");
//	sleepInSecond(3);
//	selectItemInCustomDropdown("span#number-button","ul#number-menu div","3");
//	sleepInSecond(3);
	driver.findElement(By.cssSelector("span#number-button")).click();
	explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
	//luu tru all cac item lai thi moi duyet qua duoc
	List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
	for(WebElement item : allItems) {
		//lay ra text
		String textiItem = item.getText();
		//kiem tra neu no bang voi text minh mong muon thi click
		if(textiItem.equals("7")) {
			item.click();
		}
	}
	

}


@Test
public void TC_02_Dropdown() {
	
	
}
@Test
public void TC_03() {

	}

@AfterClass
public void afterClass() {
driver.quit();
	}

//public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
//	//1 click vào 1 phần tử nào đó thuộc dropdown để cho nó xổ ra
//	driver.findElement(By.cssSelector(parentLocator)).click();
//	explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("childLocator")));
//	//luu tru tat ca item lai
//	List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
//	//duyet qua tung item
//	//vong lap
//	for (WebElement item : allItems) {
//		
//	String textActualItem = item.getText();
//		// kiem tra no bang voi text minh mong muon thi click vao
//	if(textActualItem.equals(textExpectedItem)) {
//		// no se nhan vao 1 điều kiện là boolean
//		// thi click vao
//		item.click();
//	}
//	}
//}

public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
}
}
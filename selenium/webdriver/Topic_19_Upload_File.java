package webdriver;
import java.io.File;
import java.util.ArrayList;
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
public class Topic_19_Upload_File {
	
//khaib báo biến đại diện cho thư viện selenium webdriver	
WebDriver driver;
String projectPath = System.getProperty("user.dir");

Select select;
Random rand;



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

List<String>fileNames = getFileNameInFolder();
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
public void TC_01_Upload_File() {
	// bước 2 nhập vào url 
	driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	//load file lên
	for(String fileName : fileNames)
	{
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(uploadFileFolderPath+fileName);
	}
	
//	driver.findElement(By.cssSelector("input[type='file']")).sendKeys(motFilePath);
//	driver.findElement(By.cssSelector("input[type='file']")).sendKeys(haiFilePath);
//	driver.findElement(By.cssSelector("input[type='file']")).sendKeys(baFilePath);
	// table button.start
	//thuc hien upload file
	List<WebElement> startButtons =driver.findElements(By.cssSelector("table button.start"));
	for(WebElement startButton : startButtons) {
		startButton.click();
		sleepInSecond(2);
	}
}


@Test
public void TC_02_Upload_multifile() {
	// bước 2 nhập vào url 
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		//load file lên
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(motFilePath + "\n" + haiFilePath + "\n" + baFilePath );
//		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(haiFilePath);
//		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(baFilePath);
		// table button.start
		//thuc hien upload file
		List<WebElement> startButtons =driver.findElements(By.cssSelector("table button.start"));
		for(WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	
}
@Test
public void TC_03() {

	}

@AfterClass
public void afterClass() {
//  driver.quit();
	}

public List<String> getFileNameInFolder(){
	File directoryPath = new File(uploadFileFolderPath);
	String contents[] = directoryPath.list();
	List<String> fileNames = new ArrayList<String>();
	for(int i= 0; i<contents.length; i++) {
		System.out.println(contents[i]);
		fileNames.add(contents[i]);
	}
	
	return fileNames;
}

public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
}
}
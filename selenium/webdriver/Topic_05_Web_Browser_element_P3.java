package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_element_P3 {

//khaib báo biến đại diện cho thư viện selenium webdriver	
	WebDriver driver;
	WebElement element;

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		// b1 mở browsers lên
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");

// khoi tao
		driver = new FirefoxDriver();

//bấm maximize  browser
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_is_displayed() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		// email textbox
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));

		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing Textbox");
			System.out.println("Email textbox is displayed");

		}

		else {
			System.out.println("Email textbox is not displayed");

		}
		WebElement radioUnder18 = driver.findElement(By.cssSelector("input#under_18"));

		if (radioUnder18.isDisplayed()) {
			radioUnder18.click();
			System.out.println("Age under 18 radio is displayed ");

		} else {
			System.out.println("Age under 18 radio is not displayed");

		}
		
		WebElement education = driver.findElement(By.cssSelector("textarea#edu"));
		if(education.isDisplayed()) {
			education.sendKeys("Automation tessting TextArea");
			System.out.println("Education TextArea is displayed");
			
		}
		else {
			System.out.println("Education TextArea is  not displayed");
			
		}
		WebElement image = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if(image.isDisplayed()) {
			
			System.out.println("Image 5 is displayed");
			
		}
		else {
			System.out.println("Image 5 is  not displayed");
			
		}

	}

	@Test
	public void TC_02_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement email = driver.findElement(By.cssSelector("input#mail"));
		if(email.isEnabled()) {
			System.out.println("email textbox is enabled");
		}
		else {
			System.out.println("email textbox is disabled");
		}
		
		WebElement password = driver.findElement(By.cssSelector("input#disable_password"));
		if(password.isEnabled()) {
			System.out.println("password textbox is enabled");
		}
		else {
			System.out.println("password textbox is disabled");
		}

	}

	@Test
	public void TC_03_selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement under18radio = driver.findElement(By.cssSelector("input#under_18"));
		under18radio.click();
		if(under18radio.isSelected()) {
			System.out.println("under18radio is isSelected");
		}else {
			System.out.println("under18radio is not isSelected");
		}
		WebElement javacheckbox = driver.findElement(By.cssSelector("input#java"));
		javacheckbox.click();
		
		if(javacheckbox.isSelected()) {
			System.out.println("java checkbox is isSelected");
		}
		else {
			System.out.println("java checkbox is not isSelected");
		}
		
		
	}
	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.net");
		sleepInSecond(3);
		
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
		
		passwordTextbox.sendKeys("aaa");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		passwordTextbox.clear();
		passwordTextbox.sendKeys("AAA");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		passwordTextbox.clear();
		passwordTextbox.sendKeys("123456");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
	}
}
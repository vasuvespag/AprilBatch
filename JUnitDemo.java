package test;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class JUnitDemo {
	
	public static WebDriver driver;
	public static String actualErrorMsg = "Invalid Login details or Your Password might have expired. Click here to reset your password";


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\ChromeNew\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		WebElement uname = driver.findElement(By.id("username"));
		uname.click();
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		WebElement pwd = driver.findElement(By.id("password"));
		//pwd.sendKeys("T0FEB8");
		pwd.sendKeys("password");
		driver.findElement(By.id("login")).click();
		
		String errorMsg = driver.findElement(By.xpath("//*[@id=\'login_form\']/table/tbody/tr[5]/td[2]/div/b")).getText();
		//System.out.println(errorMsg);
		assertEquals(actualErrorMsg,errorMsg);
		/*
		 * new
		 * Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
		 * 
		 * driver.findElement(By.id("Submit")).submit();
		 * 
		 * 
		 * 
		 * boolean selection = driver.findElement(By.id("radiobutton_2")).isSelected();
		 * System.out.println(selection);
		 * 
		 * driver.findElement(By.id("radiobutton_2")).click();
		 */
	}

}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_SetUp {
	public static WebDriver driver;

	public static void main(String[]  args) throws MalformedURLException, InterruptedException{

 		String URL = "http://adactinhotelapp.com";
 		String Node = "http://192.168.50.42:4444/wd/hub";
 		ChromeOptions opt = new ChromeOptions();

 		driver = new RemoteWebDriver(new URL(Node), opt);

 		driver.navigate().to(URL);
 		String s1 =driver.getTitle();
 		System.out.println(s1);
 		Thread.sleep(5000);
 		driver.quit();
 	}		
}
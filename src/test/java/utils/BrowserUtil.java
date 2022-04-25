package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String baseURL) {
		switch(browserName) {
			case "chrome" :
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge" :
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "safari" :
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			default :
				throw new RuntimeException("Browser not supported. Check Readme file for supported list");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		return driver;
	}
	
	public static void closeApplication(WebDriver driver) {
		driver.quit();
	}

}

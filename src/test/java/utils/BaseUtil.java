package utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

public class BaseUtil {
	public static WebDriver driver;
	protected static LoginPage loginPage;
	protected static MenuPage menuPage;
	protected static HeaderPage headerPage;
	protected static ProductPage productPage;
	protected static ManufacturingPage manufacturingPage;
	protected static HashMap<String,String> propMap;
	
	@BeforeSuite
	public void setup() {
		propMap =  CommonFunctionsUtil.loadProp();

		driver = BrowserUtil.startApplication(driver, propMap.get("browserName"), propMap.get("baseURL"));
		
		loginPage = new LoginPage(driver);
		menuPage = new MenuPage(driver);
		headerPage = new HeaderPage(driver);
		productPage = new ProductPage(driver);
		manufacturingPage = new ManufacturingPage(driver);
	}

	@AfterSuite
	public void tearDown() {
		BrowserUtil.closeApplication(driver);
	}
}

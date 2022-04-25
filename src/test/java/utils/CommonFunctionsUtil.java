package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonFunctionsUtil {
	static String userDir = System.getProperty("user.dir");

	public static HashMap<String, String> loadProp() {
		HashMap<String,String> propMap = new HashMap<String, String>();
		try {
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream(userDir + "\\src\\test\\resources\\properties.properties");
			properties.load(inputStream);
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				propMap.put(key, value);
			}
			return propMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

	public static void verifyElementDisplay(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	

    public static void captureScreenshot() {
        try {
            File screenshotFile = ((TakesScreenshot) BaseUtil.driver).getScreenshotAs(OutputType.FILE);
            File path = new File ((String)userDir + BaseUtil.propMap.get("screenshotPath") + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(screenshotFile, path);
            Reporter.log("<a href='"+ path.getAbsolutePath() + "'> <img src='"+ path.getAbsolutePath() + "' height='400' width='600'/> </a>");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctionsUtil;

public class HeaderPage {
	WebDriver driver;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	String buttonMainMenuReplaceableXpath = "//button[@title='%replaceable%']";

	String buttonSubMenuReplaceableXpath = "//a[normalize-space()='%replaceable%']";

	String labelReplaceableXpath = "//li[@class='breadcrumb-item active']//span[contains(text(),'%replaceable%')]";

	public void clickMainMenu(String mainMenuName) {
		String buttonMainMenuXpath = buttonMainMenuReplaceableXpath.replace("%replaceable%", mainMenuName);

		WebElement buttonMainMenu = driver.findElement(By.xpath(buttonMainMenuXpath));
		buttonMainMenu.click();
	}

	public void clickSubMenu(String subMenuName) {
		String buttonSubMenuXpath = buttonSubMenuReplaceableXpath.replace("%replaceable%", subMenuName);

		WebElement buttonSubMenu = driver.findElement(By.xpath(buttonSubMenuXpath));
		buttonSubMenu.click();
	}

	public void verifyLabel(String labelName) {
		String labelXpath = labelReplaceableXpath.replace("%replaceable%", labelName);

		WebElement lblName = driver.findElement(By.xpath(labelXpath));
		CommonFunctionsUtil.verifyElementDisplay(driver, lblName);
	}

}

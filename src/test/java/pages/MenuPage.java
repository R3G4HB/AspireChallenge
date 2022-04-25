package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "a[title='Home menu']")
	WebElement iconHomeMenu;
	String iconFeatureReplaceableXpath = "//div[normalize-space()='%replaceable%']//parent::a";

	public void clickHomeMenu() {
		iconHomeMenu.click();
	}

	public void clickFeature(String featureName) {
		String iconFeatureXpath = iconFeatureReplaceableXpath.replace("%replaceable%", featureName);

		WebElement iconFeature = driver.findElement(By.xpath(iconFeatureXpath));
		iconFeature.click();
	}


}

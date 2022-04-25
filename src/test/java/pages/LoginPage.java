package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsUtil;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "#login")
	WebElement inputEmail;
	@FindBy(css = "#password")
	WebElement inputPassword;
	@FindBy(css = "button[type='submit']")
	WebElement btnSubmit;
	String loginAlert = "p[role='alert']";
	@FindBy(xpath = "//div[normalize-space()='Inventory']//parent::a")
	WebElement featureInventory;

	void fillLogin(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
	}

	void clickSubmit() {
		btnSubmit.click();
	}

	public void doLogin(String email, String password) {
		fillLogin(email, password);
		clickSubmit();
	}

	public void verifyLogin() {
		boolean notExists = driver.findElements(By.cssSelector(loginAlert)).size() < 1;
		Assert.assertTrue(notExists);
		CommonFunctionsUtil.verifyElementDisplay(driver, featureInventory);
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsUtil;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "button[title='Create record']")
	WebElement btnCreate;
	@FindBy(xpath = "//input[contains(@id,'o_field' ) and contains(@placeholder,'Cheese')]")
	WebElement inputProductName;
	@FindBy(css = "button[title='Save record']")
	WebElement btnSave;
	@FindBy(css = "button[title='Edit record']")
	WebElement btnEdit;
	@FindBy(css = "button[name='action_update_quantity_on_hand']")
	WebElement btnUpdateQuantity;
	@FindBy(css = ".btn.btn-primary.o_list_button_add")
	WebElement btnCreateQuantity;	
	@FindBy(css = "input[name='inventory_quantity']")
	WebElement inputQuantity;
	@FindBy(css = "span[name='inventory_quantity']")
	WebElement spanQuantity;
	


	public void clickCreate() {
		btnCreate.click();
	}

	public void verifyNavigation() {
		CommonFunctionsUtil.verifyElementDisplay(driver, inputProductName);
	}

	public void createProduct(String productName) {
		inputProductName.sendKeys(productName);
		btnSave.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, btnEdit);
	}

	public void updateQuantity(String quantityValue) throws Exception {
		btnUpdateQuantity.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, btnCreateQuantity);
		btnCreateQuantity.click();
		inputQuantity.clear();
		checkQuantityValue(quantityValue);
		inputQuantity.sendKeys(String.valueOf(quantityValue));
		btnSave.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, btnCreateQuantity);
		verifyUpdatedQuantity(quantityValue);
	}

	void checkQuantityValue(String quantityValue) throws Exception {
		if(!(Integer.parseInt(quantityValue) > 10)) {
			throw new Exception("Quantity value should be greater than 10");
		}
	}

	void verifyUpdatedQuantity(String quantityValue) {
		String actualQty = spanQuantity.getText();
		Assert.assertTrue(actualQty.contains(quantityValue));
	}

}


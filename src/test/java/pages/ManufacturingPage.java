package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsUtil;

public class ManufacturingPage {
	WebDriver driver;

	public ManufacturingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = ".btn.btn-primary.o_list_button_add")
	WebElement btnCreate;
	@FindBy(xpath = "(//input[contains(@id, 'o_field')])[1]")
	WebElement inputProductName;
	@FindBy(css = "button[title='Save record']")
	WebElement btnSave;
	@FindBy(css = "button[title='Edit record']")
	WebElement btnEdit;
	String dropdownProductReplaceableXpath = "//a[contains(@id,'ui-id') and contains(text(),'%replaceable%')]";
	@FindBy(css = "button[name='action_confirm']")
	WebElement btnConfirm;
	@FindBy(css = "button[class='btn btn-primary']")
	WebElement btnMarkAsDone;
	@FindBy(css = "div[class='o_dialog_container'] button:nth-child(1)")
	WebElement popupBtnOk;
	@FindBy(css = "button[name='process']")
	WebElement popupBtnApply;
	@FindBy(xpath = "//button[normalize-space()='Done' and contains(@title, 'Current state')]")
	WebElement btnStatusDone;
	@FindBy(xpath = "(//a[contains(@id, 'o_field')])[2]")
	WebElement textProductName;
	

	public void clickCreate() {
		btnCreate.click();
	}

	public void verifyNavigation() {
		CommonFunctionsUtil.verifyElementDisplay(driver, btnSave);
	}

    public void createManufacturingOrder(String productName) {
		inputProductName.sendKeys(productName);
		selectDropdownProduct(productName);
		btnSave.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, btnEdit);
		btnConfirm.click();
    }

	public void markOrderAsDone() {
		CommonFunctionsUtil.verifyElementDisplay(driver, btnMarkAsDone);
		btnMarkAsDone.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, popupBtnOk);
		popupBtnOk.click();
		CommonFunctionsUtil.verifyElementDisplay(driver, popupBtnApply);
		popupBtnApply.click();
	}

	public void selectDropdownProduct(String productName) {
		String dropdownProductXpath = dropdownProductReplaceableXpath.replace("%replaceable%", productName);

		WebElement dropdownProduct = driver.findElement(By.xpath(dropdownProductXpath));
		dropdownProduct.click();
	}

	public void verifyDoneStatus() {
		String actualQty = btnStatusDone.getText();
		Assert.assertTrue(actualQty.contains("DONE"));
	}

	public void verifyCreatedOrder(String productName) {
		String actualQty = textProductName.getText();
		Assert.assertTrue(actualQty.contains(productName));
	}

}


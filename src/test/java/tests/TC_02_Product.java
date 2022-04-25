package tests;

import org.testng.annotations.Test;

import utils.BaseUtil;

public class TC_02_Product extends BaseUtil {

	@Test(priority = 1, groups = { "product" }, dependsOnGroups = { "login" })
	public void navigateToInventory() {
		menuPage.clickFeature("Inventory");
	}

	@Test(priority = 2, groups = { "product" }, dependsOnMethods = { "navigateToInventory" })
	public void navigateToProduct() {
		headerPage.clickMainMenu("Products");
		headerPage.clickSubMenu("Products");
		headerPage.verifyLabel("Products");

	}

	@Test(priority = 3, groups = { "product" }, dependsOnMethods = { "navigateToProduct" })
	public void clickCreate() {
		productPage.clickCreate();
		productPage.verifyNavigation();
	}

	@Test(priority = 4, groups = { "product" }, dependsOnMethods = { "clickCreate" })
	public void createProduct() {
		productPage.createProduct(propMap.get("productName"));
	}

	@Test(priority = 5, groups = { "product" }, dependsOnMethods = { "createProduct" })
	public void updateQuantity() throws Exception {
		productPage.updateQuantity(propMap.get("productQuantity"));
	}

}

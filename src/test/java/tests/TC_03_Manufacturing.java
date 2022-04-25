package tests;

import org.testng.annotations.Test;

import utils.BaseUtil;

public class TC_03_Manufacturing extends BaseUtil {

	@Test(priority = 1, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void navigateToManufacturing() {
		menuPage.clickHomeMenu();
		menuPage.clickFeature("Manufacturing");
	}

	@Test(priority = 2, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void clickCreate() {
		manufacturingPage.clickCreate();
		manufacturingPage.verifyNavigation();
	}

	@Test(priority = 3, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void createManufacturingOrder() {
		manufacturingPage.createManufacturingOrder(propMap.get("productName"));
	}

	@Test(priority = 4, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void markOrderAsDone() {
		manufacturingPage.markOrderAsDone();
	}

	@Test(priority = 5, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void verifyDoneStatus() {
		manufacturingPage.verifyDoneStatus();
	}

	@Test(priority = 6, groups = { "manufacturing" }, dependsOnGroups = { "product" })
	public void verifyCreatedOrder() {
		manufacturingPage.verifyCreatedOrder(propMap.get("productName"));
	}

}

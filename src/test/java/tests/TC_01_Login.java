package tests;

import org.testng.annotations.Test;

import utils.BaseUtil;

public class TC_01_Login extends BaseUtil {

	@Test(priority = 1, groups = { "login" })
	public void performLogin() {
		loginPage.doLogin(propMap.get("email"), propMap.get("password"));
	}

	@Test(priority = 2, dependsOnMethods = { "performLogin" }, groups = { "login" })
	public void verifyLogin() {
		loginPage.verifyLogin();
	}

}

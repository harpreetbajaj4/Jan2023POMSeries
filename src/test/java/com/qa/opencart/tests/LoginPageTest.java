package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = lp.getLoginPageTiltle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test
	public void loginPageUrlTest() {
		String actURL = lp.getLoginPageUrl();
		Assert.assertTrue(actURL.contains("route=account/login"));
	}

	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(lp.isForgottnPwdLinkPresent());
	}

}

package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp()
	{
//		ap = lp.login("hptest@123gmail.com", "hptest@123gmail");
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accountPageTitleTest()
	{
		String actAccPageTitle = ap.getAccountPageTitle();
		Assert.assertEquals(actAccPageTitle, "My Account");
	}
	
	@Test
	public void isLogoutLinkVisibleTest()
	{
		Assert.assertTrue(ap.isLogoutLinkVisible());
	}
	
	@Test
	public void accPageHeaderCountTest()
	{
		List<String> actAccHeaderList = ap.accountsPageHeaderLinksList();
		int actCount = actAccHeaderList.size();
		Assert.assertEquals(actCount, 4);
	}
	
	@Test
	public void accPageHeaderTest()
	{
		List<String> actAccHeaderList = ap.accountsPageHeaderLinksList();
		Collections.sort(actAccHeaderList);
		System.out.println(actAccHeaderList);
		List<String> expAccHeaderList = Arrays.asList("My Account", "My Orders", "Newsletter", "My Affiliate Account");
		Collections.sort(expAccHeaderList);
		System.out.println(expAccHeaderList);
		Assert.assertEquals(actAccHeaderList, expAccHeaderList);
	}
	
	
}

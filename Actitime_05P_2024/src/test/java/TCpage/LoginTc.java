package TCpage;

import org.openqa.selenium.WebDriver;
import org.pages.Dashboardpages;
import org.pages.LoginPages;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.utilies.GenericUtility;


public class LoginTc {
	private WebDriver driver;

	@BeforeMethod
	public void lunchedbrowser() {
		GenericUtility gu = new GenericUtility();
		WebDriver driver = gu.startUp("ch", "");

	}

	public void closeBrowser() {

		driver.close();
	}

	public void verifyLoginPages() {

		LoginPages lpobj = new LoginPages(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(lpobj.isUserNameFieldDisplyed());
		sa.assertTrue(lpobj.isPasswordFieldDisplyed());
		sa.assertTrue(lpobj.keepLoggedInCheckBoxDisplyed());
		sa.assertTrue(lpobj.LoginButtonDisplyed());
		sa.assertTrue(lpobj.LoginLogosDisplyed());
		sa.assertAll();
		Reporter.log("Login Page flield is displayedas expected");
		Reporter.log("login Tc is ends");
	}

	public void verifyLoginFuctionality() {
		LoginPages lpobj = new LoginPages(driver);
		lpobj.enterUserName("admin");
		lpobj.enterPassword("manager");
		lpobj.clickOnloginBtn();
		Dashboardpages dpobj = new Dashboardpages(driver);
		Assert.assertTrue(dpobj.isTimeTrackTabDisplyed(), "Dashboard page is not displyed");

	}

	public void verifyLoginPage() {
		LoginPages lpobj = new LoginPages(driver);
		Assert.assertEquals(lpobj.getLoginPageTitle(), "");

	}

	public void verifyLoginURL() {
		LoginPages lpobj = new LoginPages(driver);
		Assert.assertEquals(lpobj.getLoginPageTitle(), "");
	}
}

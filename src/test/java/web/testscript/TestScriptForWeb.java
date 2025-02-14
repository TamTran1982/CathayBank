package web.testscript;

import commons.AbstractTest;
import web.pages.LoginPagePO;
import web.pages.OnlineBankingPagePO;
import web.pages.PageFactoryManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScriptForWeb extends AbstractTest {
	private WebDriver driver;
	private LoginPagePO loginPage;
	private OnlineBankingPagePO onlineBankingPage;
	
	@Parameters({ "browser", "url", "version" })
	@BeforeClass
	public void beforeClass(String browser, String url, String version) {
		driver = openMultiBrowser(browser, url, version);
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		if(verifyTrue(loginPage.checkTitlePopup())) {
			loginPage.clickToIKnowChiButton();		
			loginPage.clickToLanguageENButton();
			loginPage.clickToIKnowEngButton();	
		}else {
			loginPage.clickToLanguageENButton();
		}
		
	}

	@Test
	public void TC_01_CheckScreenshot() throws Exception {
		loginPage.sleepInSeconds(1);
		loginPage.takeSnapShot(driver, "MyScreenShot/Cathaybk.png");		
	}
	
	@Test
	public void TC_02_CheckAllFieldsIsEmpty() throws Exception {		
//		loginPage.inputIDNumber("");
//		loginPage.inputUsername("");
//		loginPage.inputPassword("");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.checkIDNumberEmptyMessage());
		verifyTrue(loginPage.checkUsernameEmptyMessage());
		verifyTrue(loginPage.checkPasswordEmptyMessage());
		loginPage.sleepInSeconds(1);
	}
	
	@Test
	public void TC_03_CheckExistedPage() throws Exception {		
		loginPage.clickToApplyResetPasswordLink();
		onlineBankingPage=loginPage.clickToGoNowButton();
		
		onlineBankingPage.switchToChildWindow(driver, driver.getWindowHandle());		
		verifyTrue(onlineBankingPage.checkOnlineBankingTitle());
		onlineBankingPage.sleepInSeconds(1);
	}
	
	@Parameters({ "browser" })
	@AfterClass
	public void afterClass(String browser) {
		closeBrowser(browser);
	}

	
}

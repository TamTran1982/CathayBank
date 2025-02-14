package web.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	private static LoginPagePO loginPage;
	private static OnlineBankingPagePO onlineBankingPage;
	
	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}

	public static OnlineBankingPagePO getOnlineBankingPage(WebDriver driver_) {
		if (onlineBankingPage == null) {
			return new OnlineBankingPagePO(driver_);
		}
		return onlineBankingPage;
	}
}

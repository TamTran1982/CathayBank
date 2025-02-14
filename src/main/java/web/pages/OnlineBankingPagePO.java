package web.pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import web.interfaces.OnlineBankingPageUI;

public class OnlineBankingPagePO extends AbstractPage{
	WebDriver driver;

	public OnlineBankingPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public boolean checkOnlineBankingTitle() {
		waitForControlClickable(driver, OnlineBankingPageUI.ONLINE_BANKING_TITLE);
		return isControlDisplayed(driver, OnlineBankingPageUI.ONLINE_BANKING_TITLE);
	}
	
	
}

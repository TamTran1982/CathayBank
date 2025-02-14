package web.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import commons.AbstractPage;

import web.interfaces.LoginPageUI;

public class LoginPagePO extends AbstractPage {
	WebDriver driver;
	
	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
	}	
	
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{	
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);	
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);	
		File DestFile=new File(fileWithPath);		
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public boolean checkTitlePopup() {
		waitForControlClickable(driver, LoginPageUI.TITLE_POPUP);
		return isControlDisplayed(driver, LoginPageUI.TITLE_POPUP);
	}
	public void clickToIKnowChiButton() {
		waitForControlClickable(driver, LoginPageUI.I_KNOW_BTN_CHI);
		clickToElementByJS(driver, LoginPageUI.I_KNOW_BTN_CHI);
	}
	public void clickToIKnowEngButton() {
		waitForControlClickable(driver, LoginPageUI.I_KNOW_BTN_ENG);
		clickToElementByJS(driver, LoginPageUI.I_KNOW_BTN_ENG);
	}
	
	public void clickToLanguageENButton() {
		waitForControlClickable(driver, LoginPageUI.LANGUAGE_EN_BTN);
		clickToElement(driver, LoginPageUI.LANGUAGE_EN_BTN);
	}
	public void inputIDNumber(String idnumber) {
		waitForControlClickable(driver, LoginPageUI.ID_NUMBER_TXT);
		clearToElement(driver, LoginPageUI.ID_NUMBER_TXT);
		sendkeyToElement(driver, LoginPageUI.ID_NUMBER_TXT, idnumber);
	}
	public void inputUsername(String username) {
		waitForControlClickable(driver, LoginPageUI.USERNAME_TXT);
		clearToElement(driver, LoginPageUI.USERNAME_TXT);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TXT, username);
	}
	public void inputPassword(String password) {
		waitForControlClickable(driver, LoginPageUI.PASSWORD_TXT);
		clearToElement(driver, LoginPageUI.PASSWORD_TXT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}
	public void clickToLoginButton() {
		waitForControlClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}
	
	public boolean checkIDNumberEmptyMessage() {
		waitForControlClickable(driver, LoginPageUI.ID_NUMBER_EMPTY_MSG1);
		return isControlDisplayed(driver, LoginPageUI.ID_NUMBER_EMPTY_MSG1);
	}
	public boolean checkUsernameEmptyMessage() {
		waitForControlClickable(driver, LoginPageUI.USERNAME_EMPTY_MSG);
		return isControlDisplayed(driver, LoginPageUI.USERNAME_EMPTY_MSG);
	}
	public boolean checkPasswordEmptyMessage() {
		waitForControlClickable(driver, LoginPageUI.PASSWORD_EMPTY_MSG);
		return isControlDisplayed(driver, LoginPageUI.PASSWORD_EMPTY_MSG);
	}
	
	public void clickToApplyResetPasswordLink() {
		waitForControlClickable(driver, LoginPageUI.APPLY_RESET_PASSWORD_LINK);
		clickToElement(driver, LoginPageUI.APPLY_RESET_PASSWORD_LINK);
	}
	public OnlineBankingPagePO clickToGoNowButton() {
		waitForControlClickable(driver, LoginPageUI.GO_NOW_BTN);
		clickToElement(driver, LoginPageUI.GO_NOW_BTN);
		return PageFactoryManager.getOnlineBankingPage(driver);
	}
}

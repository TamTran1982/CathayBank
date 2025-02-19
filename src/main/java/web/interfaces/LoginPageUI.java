package web.interfaces;

public class LoginPageUI {	
	public static final String TITLE_POPUP = "//div[@id='divSystemLoginMsgList']//h5[contains(text(), '系統維護公告')]";
	public static final String I_KNOW_BTN_CHI = "//div[@id='divSystemLoginMsg']//button[contains(text(), '我知道了')]";
	public static final String I_KNOW_BTN_ENG = "//div[@id='divSystemLoginMsg']//button[contains(text(), 'I know')]";
	
	public static final String LANGUAGE_EN_BTN = "//span[contains(text(), 'EN')]";
	public static final String ID_NUMBER_TXT = "//input[@name='CustID']";
	public static final String USERNAME_TXT = "//input[@name='UserIdKeyin']";
	public static final String PASSWORD_TXT = "//input[@name='PasswordKeyin']";
	public static final String LOGIN_BTN = "//button[contains(text(), 'Login')]";
	public static final String ID_NUMBER_EMPTY_MSG1 = "//p[contains(text(), 'Please enter the ID number.')]";
	public static final String ID_NUMBER_EMPTY_MSG = "//p[contains(text(), '身分證字號請輸入英數字')]";
	public static final String USERNAME_EMPTY_MSG = "//p[contains(text(), 'Please enter 6 to 12 digit user code')]";
	public static final String PASSWORD_EMPTY_MSG = "//p[contains(text(), 'Please enter 6 to 16 digit password')]";
	public static final String APPLY_RESET_PASSWORD_LINK = "//a[contains(text(), 'Apply/ Reset Password')]";
	public static final String GO_NOW_BTN = "//h3[contains(text(), 'I only have credit card')]";
}


package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class AbstractTest extends AbstractPage {

	protected WebDriver driver;
	public final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected synchronized WebDriver openMultiBrowser(String browser, String url, String version) {
		if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}

		// url = "http://" + authenuser + ":" + authenpass + "@" +
		// "dev.smartmes.com:81/Security/Login?plugin=CorePlugin" ;
		// url = java.text.MessageFormat.format(url, authenuser, authenpass);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();

		log.info("---------- START " + browser + " SUCCESS ----------");
		return driver;
	}

	protected void closeBrowser(String browser) {
		driver.quit();
		log.info("---------- QUIT " + browser + " SUCCESS ----------");
	}

	protected void closeConnectDB() {
		log.info("---------- CLOSE CONNECTION DATABASE SUCCESS ----------");
		closeConnection();
	}

	private boolean verifyPassed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			// Verify
			try {
				if (condition == true)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			// Assert
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);
	}

	private boolean verifyFailed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				if (condition == false)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFailed(condition, false);
	}

	private boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertEquals(expected, actual);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(expected, actual);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	protected String random_Data() {
		Random rand = new Random();
		int temp = rand.nextInt(999999) + 1;
		String numberString = Integer.toString(temp);
		return numberString;
	}

}

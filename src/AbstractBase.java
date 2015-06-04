import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import java.lang.*;


/**
 * This abstrac class is used to build any other test that get extended from here
 */
public abstract class AbstractBase
{
    /**
     * Initial settings are set, however myBrowser, baseURL can be grabbed from xml file
     * myDriver is only initiliazed since main method needs to view something for WebDriver
     */
    public String SessionUserName = System.getProperty("user.name");
    protected String myBrowser = "Firefox";
    protected String myBaseURL = "https://www.code42.com";
    protected WebDriver myDriver = new FirefoxDriver();
    protected boolean myAcceptNextAlert = true;
    protected StringBuffer myVerificationErrors = new StringBuffer();
    protected String kChromeDriver = "..\\Code42Sample\\lib\\Drivers\\chromedriver_win32\\chromedriver.exe";
    protected String kIE32Driver = "..\\Code42Samples\\lib\\Drivers\\IEDriverServer_Win32_2.45.0\\IEDriverServer.exe";
    protected String kIE64Driver = "..\\Code42Sample\\lib\\Drivers\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe";

    public Screen myScreen = new Screen();
    public Pattern SaveButton = new Pattern("..\\Code42Sample\\SikuliImages\\SaveFileButton.png");


    /**
     * This is the method which sets up the webdriver
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        if (myBrowser.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", kChromeDriver);
            myDriver = new ChromeDriver();
        }
        else if (myBrowser.equals("Firefox"))
        {
            FirefoxProfile fxProfile = new FirefoxProfile();
            fxProfile.setPreference("browser.download.folderList",2);
            fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
            fxProfile.setPreference("browser.download.dir","c:\\");
            fxProfile.setPreference("browser.helperApps.neverAsk.openFile","application/x-msdownload");
            fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/x-msdownload");
            myDriver = new FirefoxDriver();
        }
        else if (myBrowser.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver", kIE32Driver);
            myDriver = new InternetExplorerDriver();
        }
        myBaseURL = "https://code42.com";
        myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Initialize Tear down of webDriver.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        myDriver.quit();
        String verificationErrorString = myVerificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    /**
     * Check if element is present
     * @param by indicate by input method. Use : XPath, CSSSelector, ID, Link, etc.
     * @return returns false if element is not present in DOM
     */
    private boolean isElementPresent(By by) {
        try {
            myDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks for alert
     * @return false if alert is not present
     */
    private boolean isAlertPresent() {
        try {
            myDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Close and get text
     * @return alertText
     */
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = myDriver.switchTo().alert();
            String alertText = alert.getText();
            if (myAcceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            myAcceptNextAlert = true;
        }
    }
}

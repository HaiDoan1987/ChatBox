package NaviBot;

import Utility.Constant;
import Utility.ExcelUtils;
import Utility.SupportMethod;
import org.omg.CORBA.Environment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by hai.dq on 11/8/2017.
 */
public class PossitiveCase {
    messageBot getMessage = new messageBot();
    ChatBox objChatBox = new ChatBox();
    expectedWelcomeLogicMessage getWelcomeMessage;
    WebDriver driver=null;
    SupportMethod getSupport = new SupportMethod();
    @BeforeTest
    public void setThingUp() throws Exception {
        System.setProperty(Constant.propertiesChromeDriver,Constant.pathToChromeDriver);
        driver = new ChromeDriver();

        driver.get(Constant.URL);

        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        getSupport.setDriver(driver);

        driver.switchTo().frame(getSupport.searchElementInFrame(objChatBox.aFirstWelcomeMessageElement));

        driver.manage().window().maximize();

        objChatBox.setDriver(driver);


    }

    @Test(priority = 1,dataProvider = "dataWelcomeMessage")
    public void getDataExpectedWelcomemessage(String firstTimesWelcome1stMessage,String firstTimesWelcome2ndtMessage,
                                       String firstTimesWelcome3rdMessage,String firstTimesWelcome4thMessage,
                                       String secondTimesWelcome1stMessage,String secondTimesWelcome2ndMessage) throws Exception {
    getWelcomeMessage = new expectedWelcomeLogicMessage(firstTimesWelcome1stMessage, firstTimesWelcome2ndtMessage,
                                                        firstTimesWelcome3rdMessage, firstTimesWelcome4thMessage,
                                                        secondTimesWelcome1stMessage,secondTimesWelcome2ndMessage  );


}

    @DataProvider
    public Object[][] dataWelcomeMessage() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\hai.dq\\Desktop\\DemoPOMSelenium\\src\\TestData\\WelcomeMessage.xlsx","Sheet1");
        return testObjArray;
    }





    @Test (priority = 1)
    public void checkeventWelcomeText() throws Exception{
        // Đến trang test URL  = https://khanhalect.sgcharo.com/
        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");

        driver.manage().window().maximize();
        Thread.sleep(5000);
        String actualFirstWelcomebackText = driver.findElement(objChatBox.aFirstWelcomeMessageElement).getText();
        String actualSecondWelcomebackText = driver.findElement(objChatBox.aSecondWelcomeMessageElement).getText();
        String actualThirdWelcomebackText = driver.findElement(objChatBox.aThirdWelcomeMessageElement).getText();
        String actualFourthWelcomebackText = driver.findElement(objChatBox.aForthWelcomeMessageElement).getText();
        Assert.assertEquals(actualFirstWelcomebackText,getWelcomeMessage.firstTimesWelcome1stMessage);
        Assert.assertEquals(actualSecondWelcomebackText,getWelcomeMessage.firstTimesWelcome2ndMessage);
        Assert.assertEquals(actualThirdWelcomebackText,getWelcomeMessage.firstTimesWelcome3rdMessage);
        Assert.assertEquals(actualFourthWelcomebackText,getWelcomeMessage.firstTimesWelcome4thMessage);
    }



    @Test (priority = 2)
    public void checkeventWelcomeBackText() throws InterruptedException{
        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");
        driver.navigate().refresh();
        Thread.sleep(5000);
        String actualFirstWelcomeBackMessage = driver.findElement(objChatBox.aWelcomeBackMessage1st).getText();
        String actualSecondWelcomeBackMessage = driver.findElement(objChatBox.aWelcomeBackMessage2nd).getText();
        Assert.assertEquals(actualFirstWelcomeBackMessage,getWelcomeMessage.secondTimesWelcome1stMessage);
        Assert.assertEquals(actualSecondWelcomeBackMessage,getWelcomeMessage.secondTimesWelcome2ndMessage);

    }
    @Test(priority = 3)
    public void notSupportWords() throws  InterruptedException{

        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");

        Thread.sleep(5000);

        driver.switchTo().frame(1);

        driver.findElement(objChatBox.inputTextBox).sendKeys("testTEstsdasdsadsadrsadsadsgfrofghergolerglfdr");

        driver.findElement(objChatBox.aSendMessageButton).click();
        Thread.sleep(2000);
        String actualNonSupportMessage = driver.findElement(objChatBox.aNonSupportMessageElement).getText();
        Assert.assertEquals(actualNonSupportMessage,getMessage.expectedNonSupportWords);

    }
    @Test (priority = 4)
    public void checkEventWelcomeQuickReplyButton() throws InterruptedException{

        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");

        Thread.sleep(5000);

        WebElement elementWelcomeBackFAQFirstQuickReplybutton = driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton);

        JavascriptExecutor js =(JavascriptExecutor)driver;

        boolean isSearchHouseDisplayed = driver.findElement(objChatBox.aSearchHouseQuickReplyButton).isDisplayed();

        String actualSearchHouseButtonText = driver.findElement(objChatBox.aSearchHouseQuickReplyButton).getText();

        Assert.assertEquals(actualSearchHouseButtonText,getMessage.expectedSearchHouseTextQuickReplyButton);

        boolean isRegisterHouseDisplayed = driver.findElement(objChatBox.aRegisterHouseQuickReplyButton).isDisplayed();

        String actualRegisterHouseButtonText = driver.findElement(objChatBox.aRegisterHouseQuickReplyButton).getText();

        Assert.assertEquals(actualRegisterHouseButtonText,getMessage.expectedRegisterHouseTextQuickReplyButton);

        js.executeScript("arguments[0].scrollIntoView(true);",elementWelcomeBackFAQFirstQuickReplybutton);

        Thread.sleep(5000);

        boolean isFAQFirstDisplayed = driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton).isDisplayed();

        String  actualFAQFirstButtonText =  driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton).getText();

        Assert.assertEquals(actualFAQFirstButtonText,getMessage.expectedWelcomeBackFaqFirstTextQuickReplyButton);

        boolean result = (isSearchHouseDisplayed &&isRegisterHouseDisplayed && isFAQFirstDisplayed );

        Assert.assertTrue(result);

    }
    @Test (priority = 5)
    public void checkEventWelcomeBackQuickReplyButton() throws InterruptedException{

        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");
        Thread.sleep(5000);
        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.switchTo().frame(1);
        WebElement elementWelcomeBackFAQFirstQuickReplybutton = driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        boolean isSearchHouseDisplayed = driver.findElement(objChatBox.aSearchHouseQuickReplyButton).isDisplayed();

        String actualSearchHouseButtonText = driver.findElement(objChatBox.aSearchHouseQuickReplyButton).getText();

        Assert.assertEquals(actualSearchHouseButtonText,getMessage.expectedSearchHouseTextQuickReplyButton);

        boolean isRegisterHouseDisplayed = driver.findElement(objChatBox.aRegisterHouseQuickReplyButton).isDisplayed();

        String actualRegisterHouseButtonText = driver.findElement(objChatBox.aRegisterHouseQuickReplyButton).getText();

        Assert.assertEquals(actualRegisterHouseButtonText,getMessage.expectedRegisterHouseTextQuickReplyButton);

        js.executeScript("arguments[0].scrollIntoView(true);",elementWelcomeBackFAQFirstQuickReplybutton);

        Thread.sleep(5000);
        boolean isFAQFirstDisplayed = driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton).isDisplayed();

        String  actualFAQFirstButtonText =  driver.findElement(objChatBox.aWelcomeBackFAQFirstQuickReplyButton).getText();

        Assert.assertEquals(actualFAQFirstButtonText,getMessage.expectedWelcomeBackFaqFirstTextQuickReplyButton);

        boolean result = (isSearchHouseDisplayed &&isRegisterHouseDisplayed && isFAQFirstDisplayed );
        Assert.assertTrue(result);


    }

    @Test(dataProvider = "dataTest", priority = 6)
    public void TestCaseFAQCommonX1(String qcInput) throws InterruptedException{

        driver.get("https://client-devnavibot.gnt.co.jp/navibot/demo.html");

        Thread.sleep(5000);

        driver.switchTo().frame(1);

        driver.findElement(objChatBox.inputTextBox).sendKeys(qcInput);

        driver.findElement(objChatBox.aSendMessageButton).click();

        Thread.sleep(3000);

        boolean isFAQCommonFirstMessageDisplayed = driver.findElement(objChatBox.a1stFAQCommon1ResponseMessage).isDisplayed();

        String faqCommonFirstMessageText = driver.findElement(objChatBox.a1stFAQCommon1ResponseMessage).getText();



        boolean isFAQCommonSecondMessageDisplayed = driver.findElement(objChatBox.a2ndFAQCommon1ResponseMessage).isDisplayed();

        String faqCommonSecondMessageText = driver.findElement(objChatBox.a2ndFAQCommon1ResponseMessage).getText();



        boolean isFAQCommonX1MessagesDisplayed = (isFAQCommonFirstMessageDisplayed && isFAQCommonSecondMessageDisplayed);

        Assert.assertTrue(isFAQCommonX1MessagesDisplayed);

        boolean isFAQGuestFirstQuickButtonDisplayed = driver.findElement(objChatBox.aFAQGuestFirstQuickReplyButton).isDisplayed();

        String  faqGuestFirstButtonText = driver.findElement(objChatBox.aFAQGuestFirstQuickReplyButton).getText();

        Assert.assertEquals(faqGuestFirstButtonText,getMessage.expectedFAQGuestFirstQuickReplyButtonText);

        boolean isFAQHostFirstQuickButtonDisplayed = driver.findElement(objChatBox.aFAQGuestFirstQuickReplyButton).isDisplayed();

        String  faqHostFirstButtonText = driver.findElement(objChatBox.aFAQHostFirstQuickReplyButton).getText();

        Assert.assertEquals(faqHostFirstButtonText,getMessage.expectedFAQHostFirstQuickReplyButtonText);

        boolean isSearchHouseQuickButtonDisplayed = driver.findElement(objChatBox.aSearchHouseFAQQuickReplyButton).isDisplayed();

        String faqCommon1SearchHouseButtonText = driver.findElement(objChatBox.aSearchHouseFAQQuickReplyButton).getText();

        Assert.assertEquals(faqCommon1SearchHouseButtonText,getMessage.expectedSearchHouseTextQuickReplyButton);

        boolean isRegisterHouseQuickButtonDisplayed = driver.findElement(objChatBox.aRegisterHouseFAQQuickReplyButton).isDisplayed();

        String faqCommon1RegisterHouseButtonText = driver.findElement(objChatBox.aRegisterHouseFAQQuickReplyButton).getText();

        Assert.assertEquals(faqCommon1RegisterHouseButtonText,getMessage.expectedRegisterHouseTextQuickReplyButton);

        boolean isFAQCommonX1QuickReplyButtonDisplayed  =(isFAQGuestFirstQuickButtonDisplayed && isFAQHostFirstQuickButtonDisplayed && isSearchHouseQuickButtonDisplayed && isRegisterHouseQuickButtonDisplayed );

        Assert.assertTrue(isFAQCommonX1QuickReplyButtonDisplayed);


    }
    @DataProvider
    public Object[][] dataTest() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\hai.dq\\Desktop\\DemoPOMSelenium\\src\\TestData\\TestData.xlsx","Sheet1");
        return testObjArray;
    }
    @DataProvider
    public Object[][] datacaseFAQcommon2() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\hai.dq\\Desktop\\DemoPOMSelenium\\src\\TestData\\FAQCommon2.xlsx","Sheet1");
        return testObjArray;
    }

    @Test (dataProvider  ="datacaseFAQcommon2",priority = 7)
    public void caseFAQcommon2(String qcInput) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Constant.URL);
        Thread.sleep(5000);
        objChatBox.sendChatBoxMessage(qcInput);
        Thread.sleep(5000);
        Assert.assertTrue(objChatBox.CheckisFAQCommonQuickButtonDisplayed());
        Assert.assertTrue(objChatBox.checkIsFAQCommon2MessageElementDisplayed());
        Assert.assertEquals(objChatBox.FAQCommon2FirstMessageText(),getMessage.expectedFAQCommon2FirstMessage);

    }

     @Test
    public void caseFAQcommon3() throws InterruptedException{
         driver.get(Constant.URL);
         Thread.sleep(5000);

     }

@AfterTest
    public void endTest() throws InterruptedException {
        driver.quit();
        Thread.sleep(5000);

}


}

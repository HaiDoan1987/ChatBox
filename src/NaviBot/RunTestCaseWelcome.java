package NaviBot;

import Utility.Constant;
import Utility.ExcelUtils;
import Utility.SupportMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNGException;
import org.testng.annotations.*;

@Listeners(NaviBotListener.class)
public class RunTestCaseWelcome {
 WebDriver myDriver;
ChatBox getChatBox = new ChatBox();
CaseWelcomeLocator getWelcomeCase = new CaseWelcomeLocator();
SupportMethod getSupport = new SupportMethod();
Object[] expectedFirstTimeWelcomeMessage;
    NaviBotListener objListener = new NaviBotListener();

@BeforeSuite
public void setupSuite(){
    System.setProperty(Constant.propertiesChromeDriver,Constant.pathToChromeDriver);

    myDriver = new ChromeDriver();
}

@BeforeTest

    public void setThingUp() throws Exception {

        getSupport.setDriver(myDriver);

        myDriver.manage().window().maximize();

        myDriver.get(Constant.URL);

        Thread.sleep(5000);

        getSupport.switchFrame(getChatBox.inputTextBox);
}

@Test(priority = 1)
    public void verifyFirstAccessMessageAndButtonText() throws Exception{

     expectedFirstTimeWelcomeMessage = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
            "Sheet26","Event-Welcome","FAQ-Common-x1","text_response");

    Object[] actualFirstTimeWelcomeMessage = getSupport.actualWebElementText(getWelcomeCase.textFirstTimeEventMessage);
    //verify
    Assert.assertEquals(actualFirstTimeWelcomeMessage,expectedFirstTimeWelcomeMessage);

    Object[] expectedFirstTimeQuickButtonText = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
            "Sheet26","Event-Welcome","FAQ-Common-x1","quick_reply");

    Object[] actualFirstTimeQuickButtonText = getSupport.actualWebElementText(getWelcomeCase.firstTimeWelcomeLocator);
    //verify
    Assert.assertEquals(actualFirstTimeQuickButtonText,expectedFirstTimeQuickButtonText);

    Object[] expectedFirstTimeQuickButtonId = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
            "Sheet26","Event-Welcome","FAQ-Common-x1","quick_reply_Id");

    Object[] actualFirstTimeQuickButtonId = getSupport.actualWebElementId(getWelcomeCase.firstTimeWelcomeLocator,Constant.idQuickButton);
    //verify
    Assert.assertEquals(actualFirstTimeQuickButtonId,expectedFirstTimeQuickButtonId);

    Assert.assertTrue(getSupport.isActualFirstTimeQuickButtonIdUnique(getWelcomeCase.firstTimeWelcomeLocator));

}

    @Test(priority = 2)
    public void verifyRegisterHouseQuickButtonFromFirstWelcome() throws Exception {

        Thread.sleep(5000);

        getSupport.scrollToElement(getWelcomeCase.buttonRegisterHouse);

        getSupport.clickElement(getWelcomeCase.buttonRegisterHouse);


        Object[] actualRegisterHouseEventMessage = getSupport.actualWebElementText(getWelcomeCase.messageRegisterHouseMessageLocator);

        Object[] expectedRegisterHouseEventMessage = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
                "Sheet26","Register-House","Search-House","text_response");

        Assert.assertEquals(actualRegisterHouseEventMessage,expectedRegisterHouseEventMessage);
        // chua lam kiem tra Register house event ID quick button

        Object[] actualRegisterHouseEventButtonText = getSupport.actualWebElementText(getWelcomeCase.buttonRegisterHouseEventLocators);

        Object[] expectedRegisterHouseEventButtonText = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
                "Sheet26","Register-House","Search-House","quick_reply");

        Assert.assertEquals(actualRegisterHouseEventButtonText,expectedRegisterHouseEventButtonText);

        Object[] actualRegisterHouseEventButtonID = getSupport.actualWebElementId(getWelcomeCase.buttonRegisterHouseEventLocators,Constant.idQuickButton);

        Object[] expectedRegisterHouseEventButtonID = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
                "Sheet26","Register-House","Search-House","quick_reply_Id");

        Assert.assertEquals(actualRegisterHouseEventButtonID,expectedRegisterHouseEventButtonID);

    }





@AfterTest
    public void endTest() throws InterruptedException {

    Thread.sleep(5000);

    myDriver.close();
    }

 @AfterSuite
 public void endTestSuite(){

 }
}

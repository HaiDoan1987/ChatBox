package NaviBot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by hai.dq on 11/8/2017.
 */
public class ChatBox {
    WebDriver driverChatBox= null;
    public By inputTextBox = By.name("input-chat-msg");

    public By aSendMessageButton = By.xpath("//*[@class='send-message']/img");

    public  By aWelcomeBackMessage1st =  By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'また、お会いできましたね')]");

    public By aWelcomeBackMessage2nd =  By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'今日はどのような御用でしょうか？')]");

    public  By aFirstWelcomeMessageElement = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'はじめまして！')]");

    public   By aSecondWelcomeMessageElement = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'私は、このサイトの案内人をしております、東京桜子と申します。')]");

    public By aThirdWelcomeMessageElement = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'よろしくお願いいたします！')]");

    public By aForthWelcomeMessageElement = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'今日はどのような御用でしょうか？')]");

    public  By aNonSupportMessageElement = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'失礼ですが、ほかの言葉で言い換えていただけますでしょうか？')]");


    // list FAQ Common message element
    public  By a1stFAQCommon1ResponseMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'すべて一室料金（ルームチャージ制）となります。各部屋に定められた一室の定員内でのご利用をお願いします。')]");

    public By a2ndFAQCommon1ResponseMessage= By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'その他に何か知りたいことはございますか？')]");

    //list quickrely button
    //list First Welcome/Welcomeback
    public  By aSearchHouseQuickReplyButton = By.xpath("//*[@class='viewList clearfix']/div[1]//*[contains(text(),'宿泊先を探す')]");

    public  By aRegisterHouseQuickReplyButton = By.xpath("//*[@class='viewList clearfix']/div[2]//*[contains(text(),'物件の登録をする')]");

    public  By aWelcomeFAQFirstQuickReplyButton= By.xpath("//*[@title='質問をする']");

    public By aWelcomeBackFAQFirstQuickReplyButton = By.xpath("//*[@title='質問をしたい']");

    // list FAQ commmon quickreply button
    public By aFAQGuestFirstQuickReplyButton  = By.xpath("//*[@title='ゲスト（旅行者）として質問をしたい']");

    public By aFAQHostFirstQuickReplyButton = By.xpath("//*[@title='ホスト（宿主）として質問をしたい']");

    public  By aSearchHouseFAQQuickReplyButton = By.xpath("//*[@class='viewList clearfix']/div[3]//*[contains(text(),'宿泊先を探す')]");

    public By aRegisterHouseFAQQuickReplyButton = By.xpath("//*[@class='viewList clearfix']/div[4]//*[contains(text(),'物件の登録をする')]");

    //list FAQ common 2 Message element
    By aFAQCommon2FirstMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'必ず宿泊する方が予約を行ってください。もし、予約した方が宿泊しない場合は、一度キャンセルし再度予約を行う必要があります。')]");

    public WebDriver setDriver(WebDriver driver){
        return this.driverChatBox = driver;
    }

    public boolean CheckisFAQCommonQuickButtonDisplayed(){
        boolean isFAQGuestFirstDisplayed = driverChatBox.findElement(this.aFAQGuestFirstQuickReplyButton).isDisplayed();
        boolean isFAQHostFirstDisplayed = driverChatBox.findElement(this.aFAQHostFirstQuickReplyButton).isDisplayed();
        boolean isFAQSearchHouseDisplayed = driverChatBox.findElement(this.aSearchHouseFAQQuickReplyButton).isDisplayed();
        boolean isFAQRegisterDisplayed = driverChatBox.findElement(this.aRegisterHouseFAQQuickReplyButton).isDisplayed();
        boolean isFAQCommonQuickButtonDisplayed = (isFAQGuestFirstDisplayed && isFAQHostFirstDisplayed && isFAQSearchHouseDisplayed &&isFAQRegisterDisplayed );
        return isFAQCommonQuickButtonDisplayed;
    }
    public boolean checkIsFAQCommon2MessageElementDisplayed(){
        boolean isFAQCommon2FirstMessageDisplayed = driverChatBox.findElement(this.aFAQCommon2FirstMessage).isDisplayed();
        boolean isFAQCommon2SeoondMessageDisplayed = driverChatBox.findElement(this.a2ndFAQCommon1ResponseMessage).isDisplayed();
        boolean isFAQCommon2MessageElementDisplayed =(isFAQCommon2FirstMessageDisplayed&&isFAQCommon2SeoondMessageDisplayed);
               return isFAQCommon2MessageElementDisplayed;
    }
    public String FAQCommon2FirstMessageText(){
         String result = driverChatBox.findElement(this.aFAQCommon2FirstMessage).getText();
         return result;
    }
    public String FAQCommonSecondMessageText(){
        String result = driverChatBox.findElement(this.a2ndFAQCommon1ResponseMessage).getText();
        return result;
    }

    public String GuestFirstQuickButtonText(){
        String result = driverChatBox.findElement(this.aFAQGuestFirstQuickReplyButton).getText();
        return result;
    }

    public String HostFirstQuickButtonText(){
        String result = driverChatBox.findElement(this.aFAQHostFirstQuickReplyButton).getText();
        return result;
    }

    public String SearchHouseQuickButtonText (){
        String result = driverChatBox.findElement(this.aSearchHouseQuickReplyButton).getText();
        return result;
    }
    public String RegisterHouseQuickButtonText (){
        String result = driverChatBox.findElement(this.aRegisterHouseFAQQuickReplyButton).getText();
        return result;
    }

    public void sendChatBoxMessage(String input){
        this.driverChatBox.findElement(this.inputTextBox).sendKeys(input);
        this.driverChatBox.findElement(this.aSendMessageButton).click();
    }





}

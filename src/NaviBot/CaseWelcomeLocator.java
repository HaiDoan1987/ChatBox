package NaviBot;

import Utility.ExcelUtils;
import Utility.SupportMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CaseWelcomeLocator {
   private static WebDriver driver = null;
    SupportMethod getSupport = new SupportMethod();
    //list first Welcome quick reply button
    By buttonSearchHouse =  By.xpath("//*[@postback='Search-House']");
    By buttonRegisterHouse =  By.xpath("//*[@postback='Register-House']");
    By buttonFirstAccessFAQFirst= By.xpath("//*[@title='質問をする']");
    By[] firstTimeWelcomeLocator = {buttonSearchHouse,buttonRegisterHouse,buttonFirstAccessFAQFirst};

    //list first time welcome message
    By textFirstMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'はじめまして！')]");
    By textSecondMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'私は、このサイトの案内人をしております、東京桜子と申します。')]");
    By textThirdMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'よろしくお願いいたします！')]");


    //list Welcome Back welcome message
    By textWelcomeBackFirstMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'また、お会いできましたね。＾＾')]");

    //Final Unique message
    By textFinalMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'今日はどのような御用でしょうか？')]");

   By[] textFirstTimeEventMessage = {textFirstMessage,textSecondMessage,textThirdMessage,textFinalMessage};

    //list  Welcome back quick reply button
    By buttonWelcomeBackFAQFirst= By.xpath("//*[@title='質問をしたい']");

    //list Register House bot response message from First time Welcome quick reply button Register
    By textRegFirstMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'ありがとうございます。それでは入力フォームに御案内します。')]" );
    By textRegSecondMessage = By.xpath("//div[@class='item-message owner clearfix ng-scope']/span[contains(text(),'物件の登録についてわからないことがありましたら御質問ください。')]");
    By[] messageRegisterHouseMessageLocator ={textRegFirstMessage,textRegSecondMessage};

    // list Register house quick button from First time Welcome quick reply button Register
    By buttonFAQHost2 = By.linkText("物件の登録について");
    By buttonFAQHostFirst=By.linkText("その他の質問（ホスト）");
    By buttonFAQGuestFirst = By.linkText("その他の質問（ゲスト）");
    By buttonRegSearchHouse = By.linkText("宿泊先を探す");
    By[] buttonRegisterHouseEventLocators ={buttonFAQHost2,buttonFAQHostFirst,buttonFAQGuestFirst,buttonRegSearchHouse};

    //





}

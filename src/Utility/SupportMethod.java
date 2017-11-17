package Utility;

import NaviBot.ChatBox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by hai.dq on 11/14/2017.
 */
public class SupportMethod {
    WebDriver driver= null;
    ChatBox objChatBox = new ChatBox();
            public WebDriver setDriver(WebDriver yourDriver){
                this.driver = yourDriver;
                return driver;
            }
            public int searchElementInFrame(By elementLocator){

                // "forloop" iterates all the iframes in the page and it prints '1' if our required iframe was found else returns '0'.
                 /*Verify the output, you can find the series of 0's and 1's.
            - Wherever you find the '1' in output that is the index of Frame by which the element is being loaded.
            -  Since the index of the iframe starts with '0' if you find the 1 in the 1stplace, then the index is 0.
            -  If you find 1 in 3rd place, the index is 2.*/
                int size = driver.findElements(By.tagName("iframe")).size();
                int result =0;
                for(int i = 0; i <size; i++){
                    driver.switchTo().frame(i);
                    int total = driver.findElements(elementLocator).size();
                    System.out.println(total);
                    if( total == 1){
                        result = i;
                    }
                    else if(total > 1){
                        System.out.println(elementLocator + " có nhiều hơn 1, search thấy "+ total);
                        break;
                    }
                    driver.switchTo().defaultContent();
                }
                return result;
            }

            public void switchFrame(By elementLocator){
                int size = driver.findElements(By.tagName("iframe")).size();
                int result =0;
                for(int i = 0; i <size; i++){
                    driver.switchTo().frame(i);
                    int total = driver.findElements(elementLocator).size();
                    System.out.println(total);
                    if( total == 1){
                        result = i;
                    }
                    else if(total > 1){
                        System.out.println(elementLocator + " có nhiều hơn 1, search thấy "+ total);
                        break;
                    }
                    driver.switchTo().defaultContent();
                }
                driver.switchTo().frame(result);
            }

            public String[] getData(Object[][] srcData, String[] assignData) {

                int srcDataLength = srcData.length;
                int assignDatalength = assignData.length;
                String[] result = new String[assignDatalength];
                String value;
                for (int i = 0; i < assignDatalength; i++) {

                    for (int j = 0; j < srcDataLength; j++) {
                        value = String.valueOf(srcData[j][i]);
                        result[i] = value;
                        break;
                    }
                }

                return result;
            }

    public  Object[][] actualArrayQuickButton(Object[] actualQuickButtonText, Object[] actualQuickButtonId){
        int arraylength = actualQuickButtonId.length;
        Object[][] result = new Object[arraylength][arraylength];
        for (int i =0; i < result.length;i++){
            result[i][0]= actualQuickButtonId[i];
            result[i][1]= actualQuickButtonText[i];
            System.out.println(result[i][0]);
            System.out.println(result[i][1]);

        }
        return result;
    }

    public Object[] actualWebElementText(By[] elementsLocator) {
        Object[] result = new Object[elementsLocator.length];
        for (int i = 0; i < elementsLocator.length; i++) {
            if (isElementDisplayed(elementsLocator[i])) {
                // System.out.println("Element "+" "+firstTimeQuickButtonText[i]+" is" +" "+ countElement(firstTimeQuickButtonText[i])) ;
                // System.out.println(firstTimeQuickButtonText[i] + " "+isElementDisplayed(firstTimeQuickButtonText[i]) );
                result[i] = getText(elementsLocator[i]);
               // System.out.println("tại i = "+i+" value = "+ result[i]);
            }else{
                // System.out.println(firstTimeQuickButtonText[i] + " "+isElementDisplayed(firstTimeQuickButtonText[i]) );
                scrollToElement(elementsLocator[i]);
                result[i] = getText(elementsLocator[i]);
              //  System.out.println("tại i = "+i+" value = "+ result[i]);
            }
        }
        return  result;
    }

    public Object[] actualWebElementId(By[] elementsLocator,String nameAttribute ) {
        Object[] result = new Object[elementsLocator.length];
        for (int i = 0; i < elementsLocator.length; i++) {
            if (isElementDisplayed(elementsLocator[i])) {
                // System.out.println("Element "+" "+firstTimeQuickButtonText[i]+" is" +" "+ countElement(firstTimeQuickButtonText[i])) ;
                // System.out.println(firstTimeQuickButtonText[i] + " "+isElementDisplayed(firstTimeQuickButtonText[i]) );
                result[i] = getIdButton(elementsLocator[i],nameAttribute);
                // System.out.println("tại i = "+i+" value = "+ result[i]);
            }else{
                // System.out.println(firstTimeQuickButtonText[i] + " "+isElementDisplayed(firstTimeQuickButtonText[i]) );
                scrollToElement(elementsLocator[i]);
                result[i] = getIdButton(elementsLocator[i],nameAttribute);;
                //  System.out.println("tại i = "+i+" value = "+ result[i]);
            }
        }
        return  result;
    }


    public boolean isElementDisplayed( By element){
        boolean result = driver.findElement(element).isDisplayed();
        return result;
    }

    public void scrollToElement(By element){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        WebElement element1 = driver.findElement(element);
        js.executeScript("arguments[0].scrollIntoView(true);",element1);
    }

    public String getText(By elementLocator){
        String result  = driver.findElement(elementLocator).getText();
        return result;
    }

    public boolean isActualFirstTimeQuickButtonIdUnique( By[] actualFirstTimeQuickButtonId ){

        for (int i =0;  i< actualFirstTimeQuickButtonId.length ; i++){
            if(countElement(actualFirstTimeQuickButtonId[i]) > 1){
                System.out.println("Element > 1 is "+actualFirstTimeQuickButtonId[i]);
                return false;
            }
        }
        return true;
    }

    public int countElement(By elementLocator){
        int result = driver.findElements(elementLocator).size();
        return result;
    }

    public void  clickElement( By locator){
        driver.findElement(locator).click();
    }

    public String getIdButton(By elementLocator, String nameAttribute){
        String result  = driver.findElement(elementLocator).getAttribute(nameAttribute);
        return result;
    }
    public void ScreenShot(WebDriver driver,String fileWithPath) throws IOException {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File(fileWithPath);

        FileUtils.copyFile(SrcFile, DestFile);
    }

    public  void logObjectArray(Object[] array){
        for( int i =0;i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public void GoToURl(String urlWeb) throws InterruptedException{
        driver.get(urlWeb);
        Thread.sleep(3000);
    }



}

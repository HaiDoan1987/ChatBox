package NaviBot;

import Utility.ExcelUtils;
import Utility.SupportMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by hai.dq on 11/14/2017.
 */
public class expectedFAQCommonMessage {

    SupportMethod getMethod = new SupportMethod();

    //list expected text FAQ common (1) message
    public String  faqCommonFirstMessage;

    //list  expected text FAQ common (2) message

    public String faqCommon2FirstMessage;

    //list expected test FAQ common(3) message

    public String faqCommon3FirstMessage;

    // list expected FAQ common final message

    public String faqFinalMessage;

    public String[] expectedFAQCommonMessage =new String[4];

    public expectedFAQCommonMessage() throws Exception {

            Object[][] getDataMessage = dataExpectedFAQCommon();
        /*int lengthOfexpectedFAQCommonMessage = expectedFAQCommonMessage.length;

        System.out.println("value of lengthOfexpectedFAQCommonMessage" +lengthOfexpectedFAQCommonMessage);
        String value;
        for(int o = 0; o <lengthOfexpectedFAQCommonMessage ;o++){

            for(int i=0; i< getDataMessage.length;i++){
                    value = String.valueOf(getDataMessage[i][o]);
                    expectedFAQCommonMessage[o]= value;
                    break;
            }
        }*/
        expectedFAQCommonMessage = getMethod.getData(getDataMessage,expectedFAQCommonMessage);
        faqCommonFirstMessage = expectedFAQCommonMessage[0];
        faqCommon2FirstMessage = expectedFAQCommonMessage[1];
        faqCommon3FirstMessage = expectedFAQCommonMessage[2];
        faqFinalMessage = expectedFAQCommonMessage[3];

        System.out.println("Value is faqCommonFirstMessage "+ faqCommonFirstMessage );
        System.out.println("Value is faqCommon2FirstMessage "+ faqCommon2FirstMessage );
        System.out.println("Value is faqCommon3FirstMessage "+ faqCommon3FirstMessage );
        System.out.println("Value is faqFinalMessage "+ faqFinalMessage );
    }
    public void verifyFAQCommonCase1(String actualFAQcommonMessage, String actualFAQFinalMessage){
        Assert.assertEquals(actualFAQcommonMessage,this.faqCommonFirstMessage);
        Assert.assertEquals(actualFAQFinalMessage,this.faqCommonFirstMessage);
    }

    public void verifyFAQCommonCase2(String actualFAQ2commonMessage, String actualFAQFinalMessage){
        Assert.assertEquals(actualFAQ2commonMessage,this.faqCommon2FirstMessage);
        Assert.assertEquals(actualFAQFinalMessage,this.faqCommonFirstMessage);
    }

    public void verifyFAQCommonCase3(String actualFAQ3commonMessage, String actualFAQFinalMessage){
        Assert.assertEquals(actualFAQ3commonMessage,this.faqCommon3FirstMessage);
        Assert.assertEquals(actualFAQFinalMessage,this.faqCommonFirstMessage);
    }

    public Object[][] dataExpectedFAQCommon() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\hai.dq\\Desktop\\DemoPOMSelenium\\src\\TestData\\ExpectedFAQCommon.xlsx","Sheet1");
        return testObjArray;
    }
    @Test
    public void testtest() throws Exception{
        expectedFAQCommonMessage getdataFAQMessage = new expectedFAQCommonMessage();
    }
}

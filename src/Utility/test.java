package Utility;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {
    @BeforeTest
    public void setUp() {
        System.out.println("Before test run ");
    }

    @DataProvider
    public Object[][] dataTest() throws Exception {
        Object[][] test = ExcelUtils.getUserSay("D:\\temp\\chatbot-system-testing\\src\\TestData\\srcNaviBot.xlsx", "Sheet26","FAQ-Common-x1","FAQ-Common-x2");

        return test;
    }

    @Test(dataProvider = "dataTest")
    public void runTest(String data) {
        System.out.println(data);

    }

    @Test
    public void testAssert(){
        Object[] testA =  new Object[3];
        testA[0]= "a";
        testA[1]= "b";
        testA[2]= "c";

        Object[] testB =  new Object[3];
        testB[0]= "b";
        testB[1]= "b";
        testB[2]= "c";

        Assert.assertEquals(testA,testB);
    }
}

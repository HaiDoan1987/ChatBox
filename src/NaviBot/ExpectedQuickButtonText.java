package NaviBot;

import Utility.ExcelUtils;
import org.testng.annotations.DataProvider;

/**
 * Created by hai.dq on 11/13/2017.
 */
public class ExpectedQuickButtonText {
    //syntax: logic first time(if any) + name button
    public String searchHouse;
    public String registerHouse;
    public String firstTimeFAQFirst;
    public String secondTimeFAQFirst;
    public String faqGuestFirst;
    public String faqHostFirst;
    public String faqGuest1;
    public String faqGuest2;
    public String faqGuest3;
    public String faqGuest4;
    public String faqGuest5;
    public String faqGuest6;

    public String faqGuest1p1;
    public String faqGuest1p2;
    public String faqGuest1p3;

    public String faqGuest2p1;
    public String faqGuest2p2;
    public String faqGuest2p3;
    public String faqGuest2p4;
    public String faqGuest2p5;
    public String faqGuest2p6;
    public String faqGuest2p7;
    public String faqGuest2p8;
    public String faqGuest2p9;


    public String faqGuest3p1;
    public String faqGuest3p2;
    public String faqGuest3p3;
    public String faqGuest3p4;
    public String faqGuest3p5;
    public String faqGuest3p6;
    public String faqGuest3p7;
    public String faqGuest3p8;

    public String faqGuest4p1;
    public String faqGuest4p2;
    public String faqGuest4p3;
    public String faqGuest4p4;
    public String faqGuest4p5;
    public String faqGuest4p6;

    public String faqGuest5p1;
    public String faqGuest5p2;
    public String faqGuest5p3;
    public String faqGuest5p4;

    public String faqGuest6p1;
    public String faqGuest6p2;
    public String faqGuest6p3;

    public String faqHost1p1;

    public String faqHost3p1;
    public String faqHost3p2;
    public String faqHost3p3;
    public String faqHost3p4;

    public String faqHostr4p1;
    public String faqHostr4p2;
    public String faqHostr4p3;
    public String faqHostr4p4;
    public String faqHostr4p5;
    public String faqHostr4p6;
    public String faqHostr4p7;

    public ExpectedQuickButtonText( ){

        System.out.println("Value is faqGuestFirst "+ faqGuestFirst );
        System.out.println("Value is faqHostFirst "+ faqHostFirst );
        System.out.println("Value is secondTimeFAQFirst "+ secondTimeFAQFirst );
        System.out.println("Value is firstTimeFAQFirst "+ firstTimeFAQFirst );
        System.out.println("Value is registerHouse " + registerHouse );
        System.out.println("Value is searchHouse "+ searchHouse );
    }

    public Object[][] dataExpectedFAQCommon() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\hai.dq\\Desktop\\DemoPOMSelenium\\src\\TestData\\ExpectedFAQCommon.xlsx","Sheet1");
        return testObjArray;
    }







}

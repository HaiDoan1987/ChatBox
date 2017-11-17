package NaviBot;

import Utility.ExcelUtils;
import org.testng.annotations.Test;

/**
 * Created by hai.dq on 11/13/2017.
 */
public class expectedWelcomeLogicMessage {
    //list first access Welcome message
    public String firstTimesWelcome1stMessage;

    public String firstTimesWelcome2ndMessage;

    public String firstTimesWelcome3rdMessage;

    public String firstTimesWelcome4thMessage;

    //list second access Welcome message
    public String secondTimesWelcome1stMessage;

    public String secondTimesWelcome2ndMessage;


    public expectedWelcomeLogicMessage(String firstTimesWelcome1stMessage, String firstTimesWelcome2ndtMessage,
                                       String firstTimesWelcome3rdMessage, String firstTimesWelcome4thMessage,
                                        String secondTimesWelcome1stMessage,String secondTimesWelcome2ndMessage) throws Exception {

        this.firstTimesWelcome1stMessage = firstTimesWelcome1stMessage;
        this.firstTimesWelcome2ndMessage = firstTimesWelcome2ndtMessage;
        this.firstTimesWelcome3rdMessage = firstTimesWelcome3rdMessage;
        this.firstTimesWelcome4thMessage = firstTimesWelcome4thMessage;
        this.secondTimesWelcome1stMessage = secondTimesWelcome1stMessage;
        this.secondTimesWelcome2ndMessage = secondTimesWelcome2ndMessage;
        System.out.println("Value is firstTimesWelcome1stMessage "+ firstTimesWelcome1stMessage );
        System.out.println("Value is firstTimesWelcome2ndtMessage "+ firstTimesWelcome2ndtMessage );
        System.out.println("Value is firstTimesWelcome3rdMessage "+ firstTimesWelcome3rdMessage );
        System.out.println("Value is firstTimesWelcome4thMessage "+ firstTimesWelcome4thMessage );
        System.out.println("Value is secondTimesWelcome1stMessage "+ secondTimesWelcome1stMessage );
        System.out.println("Value is secondTimesWelcome2ndMessage "+ secondTimesWelcome2ndMessage );


    }


}

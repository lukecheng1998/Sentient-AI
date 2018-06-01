import javax.swing.*;
import java.awt.*;


public class SentientAI {
    static Monika m = new Monika("Monika", 19, "BLUE");
    static Sayori s = new Sayori("Sayori", 15, "BROWN");
    static Object options[] = {"Monika", "Sayori"};
    public static void main(String[] args) throws Exception{
        //TODO: Add a popup dialog first before meeting another character
        int values = JOptionPane.showOptionDialog(null, "Who would you like to pick?", "Characters", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, null);
        if(values == 0) {
            if (m.FileReaderChecker("remembering.txt")) {
                m.getMonikaIntroductionImage();
                m.FileWrite("remembering.txt");
            } else if (!m.FileReaderChecker("remembering.txt")) {
                m.generateReturningToMonika("remembering.txt");
            }
            while (true) {
                m.defaultMonikaImage();
            }
        }else if(values == 1){
            //TODO: Some if value here
            s.GreetingSayori();
        }
    }
}

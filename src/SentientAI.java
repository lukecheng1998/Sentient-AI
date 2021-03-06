import javax.swing.*;
import java.awt.*;


public class SentientAI {
    static Monika m = new Monika("Monika", 19, "BLUE");
    static Sayori s = new Sayori("Sayori", 15, "BROWN");
    static Object options[] = {"Monika", "Sayori"};
    public static void main(String[] args) throws Exception{
        int values = JOptionPane.showOptionDialog(null, "Who would you like to pick?", "Characters", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, null);
        //Probably need a while true in here in order to go back
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
            //TODO: ADD if statement if we've already introduced
            s.GreetingSayori();
            while(true){
                s.DefaultSayori();
            }
        }
    }
}

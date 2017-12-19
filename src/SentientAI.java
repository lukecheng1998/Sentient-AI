import java.awt.*;


public class SentientAI {
    static Monika m = new Monika("Monika", 19, Color.BLUE);

    public static void main(String[] args) throws Exception{
        if(m.FileReaderChecker("remembering.txt")) {
            m.getMonikaIntroductionImage();
            m.FileWrite("remembering.txt");
        }else if(!m.FileReaderChecker("remembering.txt")){
            m.generateReturningToMonika("remembering.txt");
        }
        while(true){
            m.defaultMonikaImage();
            if(!m.getPhrase().equals("")){
                m.isTextFieldWritten();
            }else {
                m.generateRandomSpeechFirst();
                m.generateRandomSpeechSecond();
                m.generateRandomSpeechThird();
            }
        }
    }
}

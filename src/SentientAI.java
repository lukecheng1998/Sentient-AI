import java.awt.*;


public class SentientAI {
    static Monika m = new Monika("Monika", 19, Color.BLUE);

    public static void main(String[] args){
        m.getMonikaIntroductionImage();
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

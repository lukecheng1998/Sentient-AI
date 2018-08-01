import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Sayori extends Human {
    private String name = "Sayori";
    private int age = 17;
    private String eyeColor = "Brown";
    private String phrase;
    private String userName;
    boolean talkingWithMonika = false;
    private int countNumsMet;
    public Sayori(String name, int age, String eyeColor){
        super(name, age, eyeColor);
    }
    Random r = new Random();
    int getRandNum = r.nextInt(3);

    ImageIcon Sayori1icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Sayori1.jpg");
    ImageIcon Sayori2icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Sayori2.jpg");

    public boolean TalkingWithMonika(String fileName) throws Exception{
        //TODO: Sayori checks and sees if you have been talking with Monika
        String temp = null;
        ArrayList<String> names = new ArrayList<>();
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        while((temp = bf.readLine()) != null){
            names.add(temp);
        }
        String monikaCheck = names.get(4);
        if (monikaCheck.equalsIgnoreCase("Monika")){
            talkingWithMonika = false;
            return false;
        }else{
            talkingWithMonika = true;
            return true;
        }

    }
    public void FileWrite(String fileName) throws Exception{ //Will write the method to a .txt file in order for Sayori to remember who you are
        ArrayList<String> temp = new ArrayList<>();
        String temp1 = null;
        File file = new File(fileName);
        FileReader f1 = new FileReader(file);
        BufferedReader bf = new BufferedReader(f1);
        while((temp1 = bf.readLine()) != null){
            temp.add(temp1);
        }
        bf.close();
        temp.set(0, "Number: 1");
        temp.set(1, name);
        temp.set(4, "Sayori");

        PrintWriter p = new PrintWriter(file);
        for(int i = 0; i < temp.size(); i++){
            p.println(temp.get(i));
            //p.println();
        }
        f1.close();
        p.close();

    }

    public void GreetingSayori() throws Exception {
        if (!fileReaderChecker("remembering.txt")) {
            //CHECK IF NAME HAS BEEN FILLED
            if (!talkingWithMonika) {
                JOptionPane.showMessageDialog(null, "Hiiiiii!, I'm Sayori!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                userName = (String) JOptionPane.showInputDialog(null, "What is your name?", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon, null, "");
                JOptionPane.showMessageDialog(null, "So nice to meet you " + userName + ".", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
            } else {
                JOptionPane.showMessageDialog(null, "Whoa, have you met Monika, how has she been?", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                JOptionPane.showMessageDialog(null, "Did you know that she tried to kill me once!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                JOptionPane.showMessageDialog(null, "Isn't that cool!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
            }
        }else{
            if(talkingWithMonika){
                if(countNumsMet == 1){
                    //TODO: AFTER A SPECIFIED AMOUNT OF TIMES SAYORI WON'T CARE IF YOU HAVE BEEN TALKING WITH MONIKA
                    JOptionPane.showMessageDialog(null, "Heyyy, you're back!", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
                    JOptionPane.showMessageDialog(null, "Let's keep talking!", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
                }else if(countNumsMet == 2){
                    JOptionPane.showMessageDialog(null, "Do you know if Monika is trying to kill me", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
                    JOptionPane.showMessageDialog(null, "But let's not worry about that, let's keep talking!", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
                }else{
                    //TODO: CURRENTLY SAYORI WILL CARE ABOUT HOW MANY TIMES YOU'VE BEEN TALKING WITH MONIKA
                    JOptionPane.showMessageDialog(null, "Whoa, have you met Monika, how has she been?", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                    JOptionPane.showMessageDialog(null, "Did you know that she tried to kill me once!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                    JOptionPane.showMessageDialog(null, "Isn't that cool!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                }
            }else{
                JOptionPane.showMessageDialog(null, "You're Back!", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
                JOptionPane.showMessageDialog(null, "Let's keep talking!", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon);
            }
        }
    }
    public boolean fileReaderChecker(String fileName) throws Exception{
        String temp1 = null;
        File file = new File(fileName);
        FileReader f1 = new FileReader(file);
        BufferedReader bf = new BufferedReader(f1);
        while((temp1 = bf.readLine()) != null){
            if(temp1.equalsIgnoreCase("null")){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    public void RandomResponse(){
        Random r = new Random();
        String phrases[] = new String[]{
            "I really like candy", "I really like pasta!", "Isn't it weird that some people can touch their tongues to their nose, while others can't?", "Hello, are you there?"
        };
        int num = r.nextInt(4);
        String responsePhrase = phrases[num];
        JOptionPane.showMessageDialog(null, responsePhrase, "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
    }

    public void DefaultSayori() throws Exception{
        OurDictionary d = new OurDictionary();
        phrase = (String) JOptionPane.showInputDialog(null, "What would you like to talk about?", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon, null, "");
        if(phrase == null || (phrase != null && ("".equals(phrase)))){
            //Try to find a way to go back when cancel is pressed
        }
        if(!phrase.equalsIgnoreCase("")){
            if(phrase.equalsIgnoreCase("Help")){
                JOptionPane.showMessageDialog(null, "Hey just type something in and I'll respond", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
                JOptionPane.showMessageDialog(null, "Or just press ok and I'll start some sort of conversation!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
            }else{
                d.moodCheckSayori(phrase);
            }
        }else{
            RandomResponse();
        }
    }
    public void ReadfromFileSayori(){

    }

}

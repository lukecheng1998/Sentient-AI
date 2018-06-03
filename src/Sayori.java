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

    public void GreetingSayori() throws Exception{
        if(!talkingWithMonika) {
            JOptionPane.showMessageDialog(null, "Hiiiiii!, I'm Sayori!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
            userName = (String) JOptionPane.showInputDialog(null, "What is your name?", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon, null, "");
            JOptionPane.showMessageDialog(null, "So nice to meet you" + userName + ".", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
        }else{
            JOptionPane.showMessageDialog(null,"Whoa, have you met Monika, how has she been?", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
        }
    }
    public void DefaultSayori(){
        phrase = (String) JOptionPane.showInputDialog(null, "What would you like to talk about?", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon, null, "");
    }
}

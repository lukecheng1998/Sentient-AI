import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Sayori extends Human {
    private String name = "Sayori";
    private int age = 17;
    private String eyeColor = "Brown";
    private String userName;
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
        int monikaCheck = Integer.parseInt(names.get(4));
        if (monikaCheck == 0){
            return false;
        }else{
            return true;
        }

    }
    public void GreetingSayori() throws Exception{
        JOptionPane.showMessageDialog(null, "Hiiiiii!, I'm Sayori!", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
        userName = (String) JOptionPane.showInputDialog(null, "What is your name?", "Sayori", JOptionPane.QUESTION_MESSAGE, Sayori2icon, null, "");
        JOptionPane.showMessageDialog(null, "So nice to meet you" + userName + ".", "Sayori", JOptionPane.INFORMATION_MESSAGE, Sayori2icon);
    }
}

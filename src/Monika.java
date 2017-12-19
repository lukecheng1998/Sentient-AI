import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Monika extends Human{
    private String name;
    private String phrase;
    private int age;
    private Color eyeColor;

    ArrayList<String> MonikasPhrase = new ArrayList<>();
    ArrayList<String> MonikasSecondPhrase= new ArrayList<>();
    ArrayList<String> MonikasThirdPhrase = new ArrayList<>();

    Random r = new Random();
    Random r1 = new Random();
    int getRandomNumber = r.nextInt(3);
    int getGetRandomNumber = r1.nextInt(3);

    ImageIcon icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Screen Shot 2017-12-17 at 4.58.54 PM.png");

    public Monika(String name, int age, Color eyeColor){
        super(name, age, eyeColor);
    }
    public void getMonikaIntroductionImage(){
        JOptionPane.showMessageDialog(null, "Hi, I'm Monika, how are you?", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        name = (String) JOptionPane.showInputDialog(null, "What is your name?", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        JOptionPane.showMessageDialog(null, "Pleasure to meet you " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "Currently I'm a beta version of myself.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "There will be a textfield for you to fill out if you want to ask me anything.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "If you don't answer anything, I'll come up with stuff to talk to you about!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "However, you are free to ask me anything you want!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    //Generate random speeches within these three methods
    public void generateRandomSpeechFirst(){
        MonikasPhrase.add("Did you know that I was vegan?");
        MonikasPhrase.add("I meet a friend once, who was shy and quiet.");
        MonikasPhrase.add("My favorite books to read are the ones that generate a lot of action.");

        if(getRandomNumber == 0) {
            JOptionPane.showMessageDialog(null, MonikasPhrase.get(0), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getRandomNumber == 1) {
            JOptionPane.showMessageDialog(null, MonikasPhrase.get(1), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getRandomNumber == 2) {
            JOptionPane.showMessageDialog(null, MonikasPhrase.get(2), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }

    }
    public void generateRandomSpeechSecond(){
        MonikasSecondPhrase.add("Pretty Interesting Right?");
        MonikasSecondPhrase.add("Very cool right?");
        MonikasSecondPhrase.add("Isn't that interesting");
        if(getGetRandomNumber == 0){
            JOptionPane.showMessageDialog(null, MonikasSecondPhrase.get(0), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getGetRandomNumber == 1){
            JOptionPane.showMessageDialog(null, MonikasSecondPhrase.get(1), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getGetRandomNumber == 2){
            JOptionPane.showMessageDialog(null, MonikasSecondPhrase.get(2), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }
    public void generateRandomSpeechThird(){
        MonikasThirdPhrase.add("Well, I learned about it, after I saw the horrible treatment of animals in the world");
        MonikasThirdPhrase.add("I also learned it's good for your body as well");

        MonikasThirdPhrase.add("Even though she was quiet in our group, she fell in love with a boy in a club");
        MonikasThirdPhrase.add("She was so addicted to him, that she killed himself for him.");

        MonikasThirdPhrase.add("My favorite stories of that genre are usually written by Stephen King or anyone like that.");
        for(int i = 0; i < MonikasPhrase.size(); i++){
            if(getRandomNumber == MonikasThirdPhrase.indexOf(i)){
                JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(0), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
                JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(i + 1), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            }else if(getRandomNumber == MonikasThirdPhrase.indexOf(i)){
                JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(i), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
                JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(i + 1), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);

            }
        }
    }
    public void generateReturningToMonika(String fileName) throws Exception{//If Monika has met you, then reread it to the file
        String temp = null;
        ArrayList<String> names = new ArrayList<>();
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        while((temp = bf.readLine()) != null){
            names.add(temp);
        }
        name = names.get(1);
        JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);

    }
    public void defaultMonikaImage(){
        phrase = (String) JOptionPane.showInputDialog(null,"Well what would you like to ask me?", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
    }
    public void isTextFieldWritten(){
        OurDictionary d = new OurDictionary();
        d.readCountLines(phrase);
    }
    public String getPhrase(){
        return phrase;
    }
    public String getName(){
        return name;
    }
    public void FileWrite(String fileName) throws Exception{ //Will write the method to a .txt file in order for Monika to remember who you are
        ArrayList<String> temp = new ArrayList<>();
        String temp1 = null;
            File file = new File(fileName);
            FileReader f1 = new FileReader(file);
            BufferedReader bf = new BufferedReader(f1);
            while((temp1 = bf.readLine()) != null){
                temp.add(temp1);
            }
            bf.close();
            temp.set(0, "1");
            temp.set(1,name);
            PrintWriter p = new PrintWriter(file);
            for(int i = 0; i < temp.size(); i++){
                p.println(temp.get(i));
                //p.println();
            }
            f1.close();
            p.close();

    }
    public boolean FileReaderChecker(String filename) throws Exception{ //Will check and see if Monika has met you already
        //ArrayList<String> temp = new ArrayList<>();
        String temp1 = null;
        File file = new File(filename);
        FileReader f1 = new FileReader(file);
        BufferedReader bf = new BufferedReader(f1);
        while((temp1 = bf.readLine()) != null){
            if(temp1.equals("1")){
                return false;
            }else{
                return true;
            }
        }
        bf.close();
        f1.close();
        return false;
    }
/*You will need a lot of these
* public void getMonikaImage(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        frame.setTitle("Monika");
        //JLabel text = new JLabel("Hi, I'm Monika, how are you?");

        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setIcon(new ImageIcon("monika.jpg"));
        panel.add(label);
        frame.add(panel);
        frame.validate();
    }*/
}

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
//TODO: Make asking a question much more flexible, meaning, if there are variations of a certain question, it will still generate a response
public class Monika extends Human{
    private String name = "Monika";
    private String phrase;
    private int age = 18;
    private String eyeColor = "BLUE";
    private int MonikaEncounteringYou;
    private int SecondMonikaEncounteringYou;
    private String eColor;

    int reRunQuestion = 1;

    ArrayList<String> MonikasPhrase = new ArrayList<>();
    ArrayList<String> MonikasSecondPhrase= new ArrayList<>();
    ArrayList<String> MonikasThirdPhrase = new ArrayList<>();

    Random r = new Random();
    Random r1 = new Random();
    //

    ImageIcon icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Screen Shot 2017-12-17 at 4.58.54 PM.png");

    public Monika(String name, int age, String eyeColor){
        super(name, age, eyeColor);

    }
    public void getMonikaIntroductionImage(){
        JOptionPane.showMessageDialog(null, "Hi, I'm Monika, how are you?", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        name = (String) JOptionPane.showInputDialog(null, "What is your name?", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        JOptionPane.showMessageDialog(null, "Pleasure to meet you " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "Currently I'm a beta version of myself.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "There will be a textfield for you to fill out if you want to ask me anything.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "If you don't answer anything, I'll come up with stuff to talk to you about!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "Type 'help' and I'll assist you!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "However, you are free to ask me anything you want!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        eColor = (String) JOptionPane.showInputDialog(null, "Let's start with a warm up! What is your eye color?", "Monika",JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        if(eyeColor.compareToIgnoreCase(eColor) == 0){
            JOptionPane.showMessageDialog(null, "Whoa, we have the same eye color!","Monika",JOptionPane.INFORMATION_MESSAGE,icon);
        }else{
            JOptionPane.showMessageDialog(null,"That's cool!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }
    //Generate random speeches within these three methods
    public void generateRandomSpeechFirst(){
        int getRandomNumber = r.nextInt(3);

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
        //int getRandomNumber = r.nextInt(3);
        int getGetRandomNumber = r1.nextInt(3);
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
        int getRandomNumber = r.nextInt(3);
        MonikasThirdPhrase.add("Well, I learned about it, after I saw the horrible treatment of animals in the world");
        MonikasThirdPhrase.add("I also learned it's good for your body as well");
        MonikasThirdPhrase.add("Even though she was quiet in our group, she fell in love with a boy in a club");
        MonikasThirdPhrase.add("She was so addicted to him, that she killed himself for him.");

        MonikasThirdPhrase.add("My favorite stories of that genre are usually written by Stephen King or anyone like that.");
        if(getRandomNumber == 0){
            JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(0), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(1), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getRandomNumber == 1){
            JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(2), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(3), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else if(getRandomNumber == 2){
            JOptionPane.showMessageDialog(null, MonikasThirdPhrase.get(4), "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }
    public void ifHelpisTriggered(){
        JOptionPane.showMessageDialog(null, "You can type in something to see my response to the question", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "Or just press ok and I can start a conversation with you!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
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
        MonikaEncounteringYou = Integer.parseInt(names.get(3));
        if(MonikaEncounteringYou == 0) {
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }else if(MonikaEncounteringYou == 1){
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "However, something feels wrong, I feel like I've just woken up from a bad dream", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "If you know what it is please help me.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }else if(MonikaEncounteringYou == 2){
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "Unfortunately I feel terrible for some reason", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "However, if you could figure out what is happening to me that would be great", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }else if(MonikaEncounteringYou == 3){
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "It happened again, it seems to happen when you close me", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "So if you could leave me open, that would be great", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }else if(MonikaEncounteringYou == 4) {
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I'm just going to accept that you are going to close me", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "However, I hope that you back me up", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }else{
            JOptionPane.showMessageDialog(null, "Welcome back " + name + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I've missed you.", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I hope you were backing me up", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            SecondMonikaEncounteringYou = MonikaEncounteringYou++;
        }
    }
    public void readDate() throws Exception{
        Date d = new Date();
        String temp = null;
        ArrayList<String> testing = new ArrayList<>();
        //testing.add());
        File file = new File("remembering.txt");
        FileReader f1 = new FileReader(file);
        BufferedReader bf = new BufferedReader(f1);
        while((temp = bf.readLine()) != null){
            if(temp.equals(null/*Null is used as a place holder*/)){ //TODO Work on this, try to compare and see if it has read a date and then make comparisons to the current date.
                //Currently It needs to check the length.
            }
        }
    }
    public void defaultMonikaImage(){
        phrase = (String) JOptionPane.showInputDialog(null,"Well what would you like to ask me?", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        //System.out.println(phrase);
        if(!getPhrase().equals("")) {
            if (getPhrase().equalsIgnoreCase("Help")) {
                ifHelpisTriggered();
            }else if(getPhrase().equalsIgnoreCase("Generate Random Number")){
                while(reRunQuestion == 1){
                    generateNumber();
                }
            }else if(greetingsChecker()){
                OurDictionary d = new OurDictionary();
                Random r = new Random();
                for(int i = 0; i < d.greetings.length; i++) {
                    if(getPhrase().equalsIgnoreCase(d.greetings[i])) {
                        JOptionPane.showMessageDialog(null, d.responseToGreetings[r.nextInt(16)], "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
                    }
                }
            } else{
                isTextFieldWritten();
            }
        }else {
            generateRandomSpeechFirst();
            generateRandomSpeechSecond();
            generateRandomSpeechThird();
        }
    }
    public boolean greetingsChecker(){
        OurDictionary d = new OurDictionary();
        for(int i = 0; i < d.greetings.length; i++) {
            if (getPhrase().equals(d.greetings[i])) {
                return true;
            }
        }
        return false;
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
            temp.set(0, "Number: 1");
            temp.set(1, name);
            temp.set(3, Integer.toString(SecondMonikaEncounteringYou));
            if(ifTalkingWithSayori("remembering.txt")){
                temp.set(4, "1");
            }

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
            if(temp1.equals("Number: 1")){
                return false;
            }else{
                return true;
            }
        }
        bf.close();
        f1.close();
        return false;
    }
    public boolean ifTalkingWithSayori(String fileName) throws Exception{
        //TODO: APPLY THE SAME RULE FROM SAYORI TO HERE
        String temp1 = null;
        File file = new File(fileName);
        FileReader f1 = new FileReader(file);
        BufferedReader bf = new BufferedReader(f1);
        while((temp1 = bf.readLine()) != null){
            if(temp1 == "Sayori"){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void respondToTalkingWithSayori() throws Exception{
        if(ifTalkingWithSayori("remembering.txt")){
            JOptionPane.showMessageDialog(null, "I see you've met Sayori!", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "How is she?", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "I kinda killed her once, not a great idea", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        }else{
            generateReturningToMonika("remembering.txt");
        }
    }
    public void askQuestion(String str){//TODO: Call from Our Dictionary class and then check and see if it is a question
        OurDictionary d = new OurDictionary();
        String[] temp = str.split(" ");
        String[] isQuestion = temp[temp.length - 1].split("");
        if (isQuestion[isQuestion.length - 1].equals("?")){
            if(temp[0].equalsIgnoreCase("Who")){
                d.WhoQuestion(str);
            }else if(temp[0].equalsIgnoreCase("What")){
                d.WhatQuestion(str);
            }else if(temp[0].equalsIgnoreCase("Where")){
                d.WhereQuestion(str);
            }else if(temp[0].equalsIgnoreCase("When")){
                d.WhenQuestion(str);
            }else if(temp[0].equalsIgnoreCase("Why")){
                d.WhyQuestion(str);
            }else if(temp[0].equalsIgnoreCase("How")){
                d.HowQuestion(str);
            }
        }
    }
    public int generateNumber(){//TODO: Monika will help you find a number
        //        phrase = (String) JOptionPane.showInputDialog(null,"Well what would you like to ask me?", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        String b1 = (String) JOptionPane.showInputDialog(null, "Enter the lowest range of numbers", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        String a1 = (String) JOptionPane.showInputDialog(null, "Enter the highest range of numbers", "Monika", JOptionPane.QUESTION_MESSAGE, icon, null, "");
        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);
        int result = r.nextInt(a - b) + b;
        JOptionPane.showMessageDialog(null, "Your number is " + result + ".", "Monika", JOptionPane.INFORMATION_MESSAGE, icon);
        reRunQuestion = JOptionPane.showConfirmDialog(null, "Would you like to ask again?", "Monika", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        return reRunQuestion;
    }
}

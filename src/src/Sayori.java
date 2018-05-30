import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Sayori extends Human {
    private String name = "Sayori";
    private int age = 17;
    private String eyeColor = "Brown";
    public Sayori(String name, int age, String eyeColor){
        super(name, age, eyeColor);
    }
    Random r = new Random();
    int getRandNum = r.nextInt(3);

    ImageIcon Sayori1icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Sayori1.jpg");
    ImageIcon Sayori2icon = new ImageIcon("/Users/luke/IdeaProjects/Sentient AI/Sayori2.jpg");
    public void SayoriGreeting(){
     //TODO: SAYORI is going to greet you here!
    }
    public void TalkingWithMonika(){
        //TODO: Sayori checks and sees if you have been talking with Monika
    }
}

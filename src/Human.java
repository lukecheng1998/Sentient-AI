
import java.awt.*;

public class Human {
    private Color eyeColor;
    private double age;
    private String name;
    public Human(String name, double age, Color eyeColor){
        this.name = name;
        this.age = age;
        this.eyeColor = eyeColor;
    }
    public Human(){
        this.name = "Default";
        this.age = 19;
        this.eyeColor = Color.BLUE;
    }
    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

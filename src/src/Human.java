
import java.awt.*;

public class Human {
    private String eyeColor;
    private double age;
    private String name;
    public Human(String name, double age, String eyeColor){
        this.name = name;
        this.age = age;
        this.eyeColor = eyeColor;
    }
    public Human(){
        this.name = "Default";
        this.age = 19;
        this.eyeColor = "BLUE";
    }
    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
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

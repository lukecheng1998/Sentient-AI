import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    private int seconds = 0;
    private Timer t = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            seconds++;
            System.out.println(seconds);
        }
    };
    public void reset(){
        t.cancel();
        t.purge();
        seconds = 0;
    }
    public void start(){
        t.scheduleAtFixedRate(timerTask, 1000, 1000);
    }
    public int getSeconds(){
        return seconds;
    }
}

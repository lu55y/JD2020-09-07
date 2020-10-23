package by.it.drugov.jd02_03;


import java.util.Random;

public class Helper {
    
    private static final Random rnd = new Random();
    static int getRandom(int start, int stop){
        return start+rnd.nextInt(stop-start+1);
    }
    static void mySleep(int millis) {
        try {
            Thread.sleep(millis/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("something stupid", e);
        }
    }
}

package Utilities;

public class WaitMethodu {



    public static void bekle(int num){

        try {
            Thread.sleep(1000*num);
        } catch (InterruptedException e) {

        }
    }
}

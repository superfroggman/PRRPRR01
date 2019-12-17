

package Cloud;

public class threadTest extends Thread {

    public static void main(String[] args) {
        threadTest[] t = new threadTest[8];
        for (int i = 0; i < 8; i++) {
            t[i] = new threadTest();
            t[i].start();
        }
    }

    public void run(){
        System.out.println("thread is running...");
        for (long i = 0L; i < 100000000000L; i++) {
            int b = 10000*1000000;
        }
        System.out.println("thread is Done...");
    }
}

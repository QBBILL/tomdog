package socket;

/**
 * Created by 钱斌 on 2016/10/14.
 */
public class TestTHread {

    public static void main(String[] args) {
        Thread ok = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("ok");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ok.setDaemon(true);
        ok.start();
        System.out.println("done");
    }
}

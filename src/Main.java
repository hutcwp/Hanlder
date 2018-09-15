import hadler.Handler;
import hadler.Looper;
import hadler.Message;

public class Main {

    public static void main(String[] args) {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println("Handle ThreadName = " + Thread.currentThread().getName());
                System.out.println("msg = " + msg.what);
            }
        };

        new Thread(() -> {
            Looper looper = Looper.prepare();
            handler.setLooper(looper);
            System.out.println("init end");
            looper.loop();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("start ...");
            System.out.println("SendMessage ThreadName = " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                try {
                    handler.sendMessage(new Message(handler, "new msg " + i));
//                    System.out.println("send msg "+i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 5; i++) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("handle post msg in Thread " + Thread.currentThread().getName());
                    }
                });
            }
        }).start();

    }

}

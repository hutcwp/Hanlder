package hadler;

public class Looper {

    public MessageQueue<Message> messageQueue = new MessageQueue<>();

    public static Looper prepare() {
        return new Looper();
    }

    public void enqueue(Message message) {
        messageQueue.add(message);
//        System.out.println("enqueue ");
    }

    public void loop() {
        System.out.println("start loop");
        System.out.println("Looper ThreadName = " + Thread.currentThread().getName());
        for (; ; ) {
//            System.out.println("loop... empty? = "+messageQueue.isEmpty());
            if (!messageQueue.isEmpty()) {
                Message msg = messageQueue.get();

                if (msg.getCallable() != null) {
                    msg.getCallable().run();
                } else {
                    msg.targer.handleMessage(msg);
                }
                messageQueue.remove(msg);
            } else {
                try {
                    Thread.sleep(1000);
                    System.out.println("sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

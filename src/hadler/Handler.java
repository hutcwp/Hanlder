package hadler;

public abstract class Handler {

    private Looper mLooper;

    public void setLooper(Looper mLooper) {
        this.mLooper = mLooper;
    }

    public abstract void handleMessage(Message msg);

    public void sendMessage(Message msg) throws Exception {
        if (mLooper == null) {
            throw new Exception("Looper is null!");
        }
        mLooper.enqueue(msg);
    }

    public void post(Runnable runnable) {
        Message msg = new Message(this);
        msg.setCallable(runnable);
        mLooper.enqueue(msg);
    }


}

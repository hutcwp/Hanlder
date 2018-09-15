package hadler;

public class Message {

    Handler targer;

    private Runnable Callable = null;

    public void setCallable(Runnable callable) {
        Callable = callable;
    }

    public Message(Handler targer, String what) {
        this.targer = targer;
        this.what = what;
    }

    public Runnable getCallable() {
        return Callable;
    }

    public Message(Handler target) {
        this.targer = target;
    }

    public void setTarger(Handler targer) {
        this.targer = targer;
    }

    public String what;

}

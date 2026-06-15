package handlers;

public abstract class Handler {
    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    abstract void dispense(int amount);
}
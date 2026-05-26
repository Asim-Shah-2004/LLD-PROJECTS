package interfaces;

public interface Observer{
    public void add(Observable ob);
    public void delete(Observable ob);
    public void notifyObservable();
}
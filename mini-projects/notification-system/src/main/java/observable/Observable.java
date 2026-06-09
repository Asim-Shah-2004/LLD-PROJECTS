package observable;

import observer.Observer;

public interface Observable {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyObservers();
}
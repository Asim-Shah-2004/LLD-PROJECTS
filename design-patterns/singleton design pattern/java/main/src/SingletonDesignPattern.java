import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SingletonDesignPattern {

    static SingletonDesignPattern obj = null;

    // made static
    private static final Lock lock = new ReentrantLock();

    private SingletonDesignPattern() {

    }

    public static SingletonDesignPattern getInstance() {

        if (obj == null) {

            lock.lock();

            try {

                if (obj == null) {
                    obj = new SingletonDesignPattern();
                }

            } finally {
                lock.unlock();
            }
        }

        return obj;
    }

}

class Driver {
    public static void main(String[] args) {

        SingletonDesignPattern s1 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern s2 = SingletonDesignPattern.getInstance();

        System.out.println(s1 == s2);
    }
}
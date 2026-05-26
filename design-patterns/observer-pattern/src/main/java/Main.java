import channel.*;
import subscribers.MobileSubscriber;

public class Main{
    public static void main(String[] args) {
        YtChannel mrBeast = new YtChannel("mr beast");
        MobileSubscriber s1 = new MobileSubscriber("a", mrBeast);
        MobileSubscriber s2 = new MobileSubscriber("b", mrBeast);
        mrBeast.add(s1);
        mrBeast.add(s2);
        mrBeast.uploadVideo("1000 Dollar challange");
        mrBeast.delete(s2);
        mrBeast.uploadVideo("10 rs challange");
    }
}
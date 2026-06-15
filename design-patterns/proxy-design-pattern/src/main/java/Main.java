import protectionproxy.IDocReader;
import protectionproxy.DocReaderProxy;
import protectionproxy.models.User;
import remoteproxy.IDataService;
import remoteproxy.DataServiceProxy;
import virtualproxy.IDisplay;
import virtualproxy.ImageDisplayProxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Protection Proxy Test ---");
        User nonPremiumUser = new User("John", false);
        IDocReader nonPremiumProxy = new DocReaderProxy(nonPremiumUser);
        nonPremiumProxy.unlockDoc("John", "abcd@123");

        User premiumUser = new User("Alice", true);
        IDocReader premiumProxy = new DocReaderProxy(premiumUser);
        System.out.println("Unlocking with correct password:");
        premiumProxy.unlockDoc("Alice", "abcd@123");
        System.out.println("Unlocking with incorrect password:");
        premiumProxy.unlockDoc("Alice", "wrong_password");

        System.out.println("\n--- Remote Proxy Test ---");
        IDataService remoteService = new DataServiceProxy();
        System.out.println("First fetch call:");
        remoteService.fetchData();
        System.out.println("Second fetch call:");
        remoteService.fetchData();

        System.out.println("\n--- Virtual Proxy Test ---");
        IDisplay imageDisplay = new ImageDisplayProxy("photos/landscape.jpg");
        System.out.println("Proxy created. Image not loaded yet.");
        System.out.println("First display call:");
        imageDisplay.display();
        System.out.println("Second display call:");
        imageDisplay.display();
    }
}

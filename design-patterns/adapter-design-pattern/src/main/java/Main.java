import client.*;
import reports.*;
import thirdpartylibrary.*;
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        XmlDataProvider xmlDataProvider = new XmlDataProvider();
        Reports reports = new XmlDataAdapter(xmlDataProvider);
        System.out.println(client.getReport(reports, "JHON:123"));
    }
}

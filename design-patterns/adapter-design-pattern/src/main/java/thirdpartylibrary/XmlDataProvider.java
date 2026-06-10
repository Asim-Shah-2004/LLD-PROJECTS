package thirdpartylibrary;

public class XmlDataProvider {

    public String getXMLData(String data) {
        String name = data.split(":")[0];
        String id = data.split(":")[1];
        return "<data><name>" + name + "</name><id>" + id + "</id></data>";
    }
}
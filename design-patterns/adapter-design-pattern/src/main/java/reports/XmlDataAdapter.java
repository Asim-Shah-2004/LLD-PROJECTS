package reports;

import thirdpartylibrary.XmlDataProvider;

public class XmlDataAdapter implements Reports {

    private XmlDataProvider xmlDataProvider;

    public XmlDataAdapter(XmlDataProvider xmlDataProvider) {
        this.xmlDataProvider = xmlDataProvider;
    }

    @Override
    public String getJsonReport(String data) {
        String xmlData = xmlDataProvider.getXMLData(data);
        String name = xmlData.substring(xmlData.indexOf("<name>") + 6, xmlData.indexOf("</name>"));
        String id = xmlData.substring(xmlData.indexOf("<id>") + 4, xmlData.indexOf("</id>"));
        String jsonData = "{\"name\":\"" + name + "\",\"id\":\"" + id + "\"}";
        return jsonData;
    }
}
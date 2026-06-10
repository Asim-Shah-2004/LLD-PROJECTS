package client;

import reports.Reports;

public class Client{
    public String getReport(Reports report,String data){
        return report.getJsonReport(data);
    }
}
package remoteproxy;

public class DataServiceProxy implements IDataService{
    private DataService dataService;
    
    @Override
    public void fetchData() {
        if(dataService==null){
            System.out.println("Establishing connection to server");
            dataService = new DataService();
            System.out.println("connection established");       
        }
        dataService.fetchData();
    }
}

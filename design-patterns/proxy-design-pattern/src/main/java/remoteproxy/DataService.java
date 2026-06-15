package remoteproxy;

public class DataService implements IDataService{
    
    @Override
    public void fetchData() {
        System.out.println("Fetching data");
    }
}

package persistence;

public class PersistDatabase implements Persistance{

    @Override
    public void save(String data) {
        System.out.println("saving to database");
    }
}
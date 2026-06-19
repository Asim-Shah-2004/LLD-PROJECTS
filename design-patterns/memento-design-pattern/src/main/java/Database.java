import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String,String> mp = new HashMap<>();

    public void create(String key, String value){
        mp.put(key,value);
    }

    public void update(String key, String value){
        mp.put(key,value);
    }

    public void delete(String key){
        mp.remove(key);
    }

    public Memento saveSnapshot(){
        return new Memento(mp);
    }

    public void restoreSnapshot(Memento memento){
        mp = memento.getState();
    }

    
}
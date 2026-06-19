import java.util.HashMap;
import java.util.Map;

public class Memento {
    private Map<String,String> mp;

    public Memento(Map<String,String> mp){
        this.mp = new HashMap<>(mp);
    }

    public Map<String,String> getState(){
        return mp;
    }
}

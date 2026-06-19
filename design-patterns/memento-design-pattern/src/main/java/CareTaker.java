public class CareTaker {

    private Memento memento;
    private Database db;

    public CareTaker(Database db){
        this.db = db;
    }

    public void beginTransaction(){
        this.memento = db.saveSnapshot();
    }

    public void commitTransaction(){
        this.memento = null;
        System.out.println("Transaction committed");
    }

    public void rollbackTransaction(){
        if(memento!=null){
            db.restoreSnapshot(memento);
            this.memento = null;
        }
    }

}

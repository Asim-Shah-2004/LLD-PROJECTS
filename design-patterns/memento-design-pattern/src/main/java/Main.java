public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        CareTaker careTaker = new CareTaker(db);

        careTaker.beginTransaction();
        db.create("name", "asim");
        db.update("name", "asim");
        db.delete("name");
        careTaker.commitTransaction();

        careTaker.rollbackTransaction();
        
    }
}

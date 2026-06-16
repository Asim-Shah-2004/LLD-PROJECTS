
import car.*;
import engine.*;

public class Main {
    public static void main(String[] args){
        Car suv = new Suv(new Petrol());
        Car sedan = new Sedan(new Electric());
        suv.drive();
        sedan.drive();
    }
}

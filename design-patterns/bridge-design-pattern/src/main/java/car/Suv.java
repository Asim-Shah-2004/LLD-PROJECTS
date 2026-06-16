package car;

import engine.Engine;

public class Suv extends Car{
    public Suv(Engine engine){
        super(engine);
    }    

    public void drive(){
        engine.start();
        System.out.println("SUV is driving.");
    }

}

import handlers.*;

public class Main {
    public static void main(String[] args) {
        ThousandRupeeHandler thousandRupeeHandler = new ThousandRupeeHandler(10);
        FiveHundredRupeeHandler fiveHundredRupeeHandler = new FiveHundredRupeeHandler(20);
        HundredRupeeHandler hundredRupeeHandler = new HundredRupeeHandler(30);

        thousandRupeeHandler.setHandler(fiveHundredRupeeHandler);
        fiveHundredRupeeHandler.setHandler(hundredRupeeHandler);

        thousandRupeeHandler.dispense(1350);
    }
}
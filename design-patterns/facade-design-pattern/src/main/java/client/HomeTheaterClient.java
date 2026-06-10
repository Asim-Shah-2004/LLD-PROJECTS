package client;

import facade.HomeTheaterFacade;

public class HomeTheaterClient {

    public static void main(String[] args) {

        System.out.println("Client: I just want to watch a movie.");
        System.out.println("Client: I'll use the facade — no idea how any of this works internally.\n");

        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.start("Interstellar (2014)");

        System.out.println("\n  ... 2 hours and 49 minutes later ...\n");

        homeTheater.stop();

        System.out.println("\nClient: That was easy. The facade handled EVERYTHING.");
    }
}


package client;

import context.*;
import strategy.flying.*;
import strategy.projection.*;
import strategy.talking.*;
import strategy.walking.*;

public class Client{
    public static void main(String[] args) {
        Robot robo = new Robot(
            new CannotWalk(),
            new NormalTalk(),
            new NormalFly(),
            new CannotProjection()
        );

        robo.walk();
        robo.talk();
        robo.fly();
        robo.project();

    }
}
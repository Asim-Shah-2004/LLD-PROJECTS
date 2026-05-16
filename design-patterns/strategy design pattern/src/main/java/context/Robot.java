package context;

import strategy.flying.*;
import strategy.projection.*;
import strategy.talking.*;
import strategy.walking.*;

public class Robot{
    Walking walk;
    Talking talk;
    Flying fly;
    Projection project;

    public Robot(Walking walk,Talking talk,Flying fly, Projection projection) {
        this.walk = walk;
        this.fly = fly;
        this.talk = talk;
        this.project = projection;
    }

    public void  walk(){
        walk.walk();
    }

    public void talk(){
        talk.talk();
    }
    
    public void fly(){
        fly.fly();
    }

    public void project(){
        project.project();
    }

}
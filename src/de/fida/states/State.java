package de.fida.states;

import de.fida.tile.Handler;
import java.awt.Graphics;

 
public abstract class State {

    protected Handler handler;
    private static State currentState=null;

    public State(Handler handler) {
        this.handler = handler;
    }

    
    
    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State aCurrentState) {
        currentState = aCurrentState;
    }
    
    
    public abstract void tick();
    public abstract void render(Graphics  g);
}

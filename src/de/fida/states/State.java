package de.fida.states;

import de.fida.tile.Game;
import java.awt.Graphics;

 
public abstract class State {

    protected Game game;
    private static State currentState=null;

    public State(Game game) {
        this.game = game;
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

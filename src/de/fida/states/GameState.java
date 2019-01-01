package de.fida.states;

import de.fida.entities.Player;
import de.fida.tile.Handler;
import de.fida.world.World;
import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"resources/worlds/world.txt");
        handler.setWorld(world);
        player = new Player(handler, 00, 00);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }

}

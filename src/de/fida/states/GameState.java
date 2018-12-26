package de.fida.states;

import de.fida.entities.Player;
import de.fida.tile.Game;
import de.fida.world.World;
import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World("resources/worlds/world.txt");
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
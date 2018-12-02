package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.graphics.Graphics;
import com.draglantix.tiles.Tile;
import com.draglantix.tiles.TileColors;
import com.draglantix.window.Window;
import com.draglantix.world.World;

public class PlayState extends GameState{
	
	public World world;
	
	public PlayState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load() {
		super.load();
		TileColors.load();
		world = new World(assets);
		for(Tile t : world.tiles.getTileList()) {
			addObjects(t);
		}
		addObjects(assets.player);
		
	}

	@Override
	public void tick() {
		super.tick();
		assets.camera.move();
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			GameStateManager.setState(State.INTRO);
		}
	}
	
}

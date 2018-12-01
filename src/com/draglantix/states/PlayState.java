package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.tiles.TileColors;
import com.draglantix.window.Window;

public class PlayState extends GameState{
	
	public PlayState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load() {
		super.load();
		TileColors.load();
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

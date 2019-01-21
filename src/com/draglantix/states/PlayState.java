package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.dragonfire.window.Window;
import com.draglantix.screens.PlayScreen;
import com.draglantix.world.World;

public class PlayState extends GameState{
	
	private PlayScreen screen;
	
	public PlayState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load(Graphics g) {
		super.load(g);
		screen = new PlayScreen(assets);
		assets.world = new World(assets, g);
		
	}

	@Override
	public void tick() {
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			GameStateManager.setState(State.MENU);
			return;
		}
		assets.camera.move();
		assets.world.tick();
		screen.tick();
	}

	@Override
	public void renderScene(Graphics g) {
		assets.world.render(g);
		screen.render(g);
	}
	
}

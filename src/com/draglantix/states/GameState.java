package com.draglantix.states;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.graphics.Graphics;

public abstract class GameState {

	protected State state;
	protected Assets assets;
	
	public GameState(State state, Assets assets) {
		this.state = state;
		this.assets = assets;
	}
	
	public void load(Graphics g) {
		assets.load(state);
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		prepare();
		renderScene(g);
		finish();
	}
	
	public static void prepare() {
		GameStateManager.prepareRender();
	}
	
	public abstract void renderScene(Graphics g);
	
	public static void finish() {
		GameStateManager.finishRender();
	}
	
	public void unload() {
		assets.unload(state);
	}
}

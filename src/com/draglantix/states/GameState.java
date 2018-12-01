package com.draglantix.states;

import java.util.ArrayList;
import java.util.List;

import com.draglantix.assets.Assets;
import com.draglantix.font.Message;
import com.draglantix.graphics.Graphics;
import com.draglantix.objects.Objects;

public abstract class GameState {

	protected State state;
	protected Assets assets;

	protected List<Objects> objects = new ArrayList<Objects>();
	protected List<Message> messages = new ArrayList<Message>();	
	
	public GameState(State state, Assets assets) {
		this.state = state;
		this.assets = assets;
	}
	
	public void load() {
		assets.load(state);
	}
	
	public void render(Graphics g) {
		prepare();
		renderScene(g);
		finish();
	}
	
	public static void prepare() {
		GameStateManager.prepareRender();
	}
	
	public static void finish() {
		GameStateManager.finishRender();
	}
	
	public void unload() {
		assets.unload(state);
		objects.removeAll(objects);
		messages.removeAll(messages);
	}
	
	public void renderScene(Graphics g) {
		for(Objects o : objects) {
			o.render(g);
		}
		for(Message m : messages) {
			g.drawFont(m);
		}
	}
	
	public void tick() {
		for(Objects o : objects) {
			o.tick();
		}
	}
	
	public void addObjects(Objects... objs) {
		for(Objects o : objs) {
			objects.add(o);
		}
	}
	
	public void addMessages(Message... msgs) {
		for(Message m : msgs) {
			messages.add(m);
		}
	}
}

package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.font.Message;
import com.draglantix.main.Configs;
import com.draglantix.util.Color;
import com.draglantix.window.Window;

public class MenuState extends GameState{

	public MenuState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load() {
		super.load();
		addMessages(new Message(Configs.TITLE, new Vector2f(0, 250), new Vector2f(48, 48), new Color(0, 1, .2f, 1), 40, false, assets.font),
				new Message("Start", new Vector2f(0, 0), new Vector2f(32, 32), new Color(1, 1, 1, 1), 40, false, assets.font),
				new Message("Quit", new Vector2f(0, -100), new Vector2f(32, 32), new Color(1, 1, 1, 1), 40, false, assets.font));
	}

	@Override
	public void tick() {
		super.tick();
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			GameStateManager.setState(State.PLAY);
			assets.sfx.stop();
		}
	}

}

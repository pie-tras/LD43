package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.font.Message;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.dragonfire.window.Window;
import com.draglantix.main.Configs;
import com.draglantix.screens.MenuScreen;

public class MenuState extends GameState {

	private MenuScreen screen;

	public MenuState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load(Graphics g) {
		super.load(g);

		screen = new MenuScreen(assets);

		screen.addObjects(assets.darklandsArch);
		screen.addMessages(
				new Message(Configs.TITLE, new Vector2f(0, 250), new Vector2f(26, 26), new Color(0, 1, .2f, 1), 40,
						false, assets.font),
				new Message("Start", new Vector2f(0, 0), new Vector2f(32, 32), new Color(1, 1, 1, 1), 40, false,
						assets.font),
				new Message("Quit", new Vector2f(0, -100), new Vector2f(32, 32), new Color(1, 1, 1, 1), 40, false,
						assets.font));

	}

	@Override
	public void tick() {
		screen.tick();
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			GameStateManager.setState(State.PLAY);
			assets.sfx.stop();
			return;
		}
	}

	@Override
	public void renderScene(Graphics g) {
		screen.render(g);
	}

}

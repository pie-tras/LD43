package com.draglantix.states;

import org.joml.Vector2f;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.font.Message;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.screens.IntroScreen;

public class IntroState extends GameState{

	private IntroScreen screen;

	private String story = "Legends and tales of yore speak of great treasure in the heart of the Darklands...";
	
	
	public IntroState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load(Graphics g) {
		super.load(g);
		
		assets.sfx.setLooping(true);
		assets.sfx.play();

		screen = new IntroScreen(assets);
		screen.addObjects(assets.draglantixLogo, assets.storyGui);
		screen.addMessages(new Message(story, new Vector2f(0, -250), new Vector2f(16, 16), new Color(1, 1, 1, 0), 40, false, assets.font));
	}
	
	@Override
	public void tick() {
		screen.tick();
	}

	@Override
	public void renderScene(Graphics g) {
		screen.render(g);
	}
	
}

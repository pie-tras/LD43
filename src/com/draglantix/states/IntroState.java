package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.font.Message;
import com.draglantix.util.Color;
import com.draglantix.util.Timer;
import com.draglantix.window.Window;

public class IntroState extends GameState{

	private String story = "Legends and tales of yore speak of great treasure in the heart of the Darklands...";
	
	private Timer timer;
	private double passed;	

	private boolean introFinished, next;
	
	
	public IntroState(State state, Assets assets) {
		super(state, assets);
	}

	@Override
	public void load() {
		super.load();
		
		introFinished = false;
		next = false;
		timer = new Timer();
		passed = 0;
		
		assets.sfx.setLooping(true);
		assets.sfx.play(assets.introMusic);
		
		addObjects(assets.draglantixLogo, assets.storyGui);
		addMessages(new Message(story, new Vector2f(0, -250), new Vector2f(16, 16), new Color(1, 1, 1, 0), 40, false, assets.font));
	}
	
	@Override
	public void tick() {
		super.tick();
		passed += timer.getDelta();
		if(!introFinished) {
			doIntro();
		}else {
			doStory();
		}
	}
	
	public void doIntro() {
		float alpha = assets.draglantixLogo.getColor().getAlpha();
		
		if(!next) {
					
			if(assets.logoAnim.hasPlayed() && passed > 3) {
				next = true;
			}
			
		}else {
		
			if(alpha > 0) {
				alpha -= .02f;
			}
			
			if(alpha<=0) {
				alpha = 0;
				introFinished = true;
				next = false;
			}
		}
		
		assets.draglantixLogo.setA(alpha);
	}
	
	private void doStory() {
		float alpha = messages.get(0).getColor().getAlpha();
		
		if(!next) {
		
			if(alpha < 1) {
				alpha += .01f;
				passed = 0;
			}
			
			if(passed > 5 && alpha >= 1) {
				alpha = 1;
				next = true;
			}
			
			if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
				next = true;
			}
		
		}else {
		
			if(alpha > 0) {
				alpha -= .02f;
			}
			
			if(alpha <= 0) {
				alpha = 0;
				GameStateManager.setState(State.MENU);
				return;
			}
		}
		
		messages.get(0).setA(alpha);
		assets.storyGui.setA(alpha);
		
	}
	
}

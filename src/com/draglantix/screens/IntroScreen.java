package com.draglantix.screens;

import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.dragonfire.window.Window;
import com.draglantix.spark.util.Timer;
import com.draglantix.states.GameStateManager;
import com.draglantix.states.State;

public class IntroScreen extends Screen{

	private Timer timer;
	private double passed;	

	private boolean introFinished, next;
	
	public IntroScreen(Assets assets) {
		super(assets);
		introFinished = false;
		next = false;
		timer = new Timer();
		passed = 0;
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
		Color lastCol = messages.get(0).getColor();
		messages.get(0).setColor(new Color(lastCol.getR(), lastCol.getG(), lastCol.getB(), alpha));
		assets.storyGui.setA(alpha);
		
	}
	
}

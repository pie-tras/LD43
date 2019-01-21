package com.draglantix.states;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.spark.main.GSM;

public class GameStateManager extends GSM{

	private Assets assets;

	private static State currentState;

	private static GameState currentStateClass;

	private static IntroState introState;
	private static MenuState menuState;
	private static PlayState playState;

	public GameStateManager(State startState) {	
		currentState = startState;
	}
	
	@Override
	public void init() {
		super.init();
		
		assets = new Assets();

		introState = new IntroState(State.INTRO, assets);
		menuState = new MenuState(State.MENU, assets);
		playState = new PlayState(State.PLAY, assets);

		setState(currentState);
	}
	
	@Override
	public void update() {
		super.update();
		currentStateClass.tick();
		currentStateClass.render(g);
	}
	
	public static void setState(State state) {
		if(currentStateClass != null) {
			currentStateClass.unload();
		}

		currentState = state;

		switch(currentState) {
		case INTRO:
			currentStateClass = introState;
			break;
		case PLAY:
			currentStateClass = playState;
			break;
		default:
			currentStateClass = menuState;
			break;
		}

		currentStateClass.load(g);
	}
	
	public static void prepareRender() {
		prepare();
	}
	
	public static void finishRender() {
		GSM.getWindow().swapBuffers();
	}
	
	public static Graphics getGraphics() {
		return g;
	}
}

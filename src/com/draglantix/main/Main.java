package com.draglantix.main;

import com.draglantix.states.GameStateManager;
import com.draglantix.states.State;

public class Main {
	
	public Main() {
		GameStateManager gsm = new GameStateManager(State.PLAY);
		new SparkEngine(gsm, Configs.WIDTH, Configs.HEIGHT, Configs.TITLE + Configs.VERSION, Configs.PRINT_FPS);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}

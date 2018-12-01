package com.draglantix.assets;

import org.joml.Vector2f;

import com.draglantix.audio.AudioMaster;
import com.draglantix.audio.Source;
import com.draglantix.camera.Camera;
import com.draglantix.font.Font;
import com.draglantix.graphics.Animation;
import com.draglantix.graphics.SpriteSheet;
import com.draglantix.graphics.Texture;
import com.draglantix.guis.Gui;
import com.draglantix.states.GameStateManager;
import com.draglantix.states.State;
import com.draglantix.util.Color;

public class Assets {
	
	//////General//////
	
	public Font font;
	public SpriteSheet fontSheet;
	public Source sfx;
	public int introMusic;
	
	//////Intro////////
	
	public SpriteSheet draglantix;
	public Animation logoAnim;
	public Texture lanternTex;
	public Gui draglantixLogo, storyGui;
	
	//////Menu/////////
	
	//////Play/////////
	
	public SpriteSheet tiles;
	public Camera camera;
	
	public Assets() {
		fontSheet = new SpriteSheet("font");
		font = new Font(fontSheet, 32);
		sfx = new Source(1.5f, 1000);
		introMusic = AudioMaster.loadSound("music/fieldsOfSorrow.wav");
	}
	
	private void loadIntro() {
		draglantix = new SpriteSheet("draglantix");
		logoAnim = new Animation(3, 3, 64, 20, draglantix, false);
		draglantixLogo = new Gui(logoAnim, new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(128, 128), new Color(1, 1, 1, 1));
		lanternTex = new Texture("lantern");
		storyGui = new Gui(lanternTex, new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(32, 32), new Color(0, 1, 1, 0));
	}
	
	private void unloadIntro() {
		draglantix = null;
		logoAnim = null;
		draglantixLogo = null;
		lanternTex = null;
		storyGui = null;
	}
	
	private void loadMenu() {
		
	}

	private void unloadMenu() {
		
	}
	
	private void loadPlay() {
		camera = new Camera(new Vector2f(0, 0), 0, 0, 0.07f, 10);
		GameStateManager.getGraphics().setCurrentCamera(camera);
		tiles = new SpriteSheet("tiles");
		
	}

	private void unloadPlay() {
		
	}
	
	public void load(State state) {
		switch(state) {
			case INTRO:
				loadIntro();
				break;
			case MENU:
				loadMenu();
				break;
			case PLAY:
				loadPlay();
				break;
			default:
				break;
		}
		
	}
	
	public void unload(State state) {
		switch(state) {
		case INTRO:
			unloadIntro();
			break;
		case MENU:
			unloadMenu();
			break;
		case PLAY:
			unloadPlay();
			break;
		default:
			break;
		}
	}
	
}

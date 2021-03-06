	package com.draglantix.assets;

import org.joml.Vector2f;

import com.draglantix.camera.Camera;
import com.draglantix.dragonfire.audio.AudioMaster;
import com.draglantix.dragonfire.audio.Source;
import com.draglantix.dragonfire.font.Font;
import com.draglantix.dragonfire.graphics.Animation;
import com.draglantix.dragonfire.graphics.SpriteSheet;
import com.draglantix.dragonfire.graphics.Texture;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.main.Configs;
import com.draglantix.spark.guis.Gui;
import com.draglantix.states.State;
import com.draglantix.world.World;

public class Assets {

	////// General//////

	public Font font;
	public SpriteSheet fontSheet;
	public Source sfx;
	public int introMusic;

	////// Intro////////

	public SpriteSheet draglantix;
	public Animation logoAnim;
	public Texture lanternTex;
	public Gui draglantixLogo, storyGui;

	////// Menu/////////

	public Texture darklandsArchTex;
	public Gui darklandsArch;

	////// Play/////////

	public World world;
	public SpriteSheet tileSheet;
	public SpriteSheet psID, psIU, psIL, psIR, psD, psU, psL, psR;
	public SpriteSheet enID, enIU, enIL, enIR, enD, enU, enL, enR;
	public Animation IplayerLAnim, IplayerRAnim, IplayerUAnim, IplayerDAnim, playerLAnim, playerRAnim, playerUAnim,
			playerDAnim, monsterLAnim, monsterRAnim, monsterUAnim, monsterDAnim, IenemyLAnim, IenemyRAnim, IenemyUAnim,
			IenemyDAnim, enemyLAnim, enemyRAnim, enemyUAnim, enemyDAnim;

	public Color[] playerColors;

	public Color[] enemyColors;
	public Camera camera;

	public Assets() {
		fontSheet = new SpriteSheet("font");
		font = new Font(fontSheet, 32);
		introMusic = AudioMaster.loadSound("music/fieldsOfSorrow.wav");
		sfx = new Source(introMusic, 1.5f, 1000);
	}

	private void loadIntro() {
		draglantix = new SpriteSheet("draglantix");
		logoAnim = new Animation(3, 3, 64, 20, draglantix, false);
		draglantixLogo = new Gui(logoAnim, new Vector2f(0, 0), new Vector2f(128, 128));
		lanternTex = new Texture("lantern");
		storyGui = new Gui(lanternTex, new Vector2f(0, 0), new Vector2f(32, 32));
		storyGui.setColor(new Color(0, 1, 1, 0));
	}

	private void unloadIntro() {
		draglantix = null;
		logoAnim = null;
		draglantixLogo = null;
		lanternTex = null;
		storyGui = null;
	}

	private void loadMenu() {
		darklandsArchTex = new Texture("darklandsArch");
		darklandsArch = new Gui(darklandsArchTex, new Vector2f(-10, 0),
				new Vector2f(Configs.WIDTH / 2 + 10, Configs.HEIGHT / 2));
	}

	private void unloadMenu() {
		darklandsArch = null;
	}

	private void loadPlay() {

		tileSheet = new SpriteSheet("tiles");
		psID = new SpriteSheet("player/playerID");
		psIU = new SpriteSheet("player/playerIU");
		psIL = new SpriteSheet("player/playerIL");
		psIR = new SpriteSheet("player/playerIR");

		psD = new SpriteSheet("player/playerD");
		psU = new SpriteSheet("player/playerU");
		psL = new SpriteSheet("player/playerL");
		psR = new SpriteSheet("player/playerR");
		// monsterSheet = new SpriteSheet("monster");

		IplayerDAnim = new Animation(2, 2, 16, 2, psID, true);
		IplayerUAnim = new Animation(2, 2, 16, 2, psIU, true);
		IplayerLAnim = new Animation(2, 2, 16, 2, psIL, true);
		IplayerRAnim = new Animation(2, 2, 16, 2, psIR, true);

		playerDAnim = new Animation(2, 2, 16, 12, psD, true);
		playerUAnim = new Animation(2, 2, 16, 12, psU, true);
		playerLAnim = new Animation(2, 2, 16, 12, psL, true);
		playerRAnim = new Animation(2, 2, 16, 12, psR, true);

		playerColors = new Color[3];

		playerColors[0] = new Color(.3f, .3f, .3f, 1);
		playerColors[1] = new Color(0, 1, 1, 1);
		playerColors[2] = new Color(1, .9f, .8f, 1);

		// Enemy Load
		enID = new SpriteSheet("enemy/enemyID");
		enIU = new SpriteSheet("enemy/enemyIU");
		enIL = new SpriteSheet("enemy/enemyIL");
		enIR = new SpriteSheet("enemy/enemyIR");

		enD = new SpriteSheet("enemy/enemyD");
		enU = new SpriteSheet("enemy/enemyU");
		enL = new SpriteSheet("enemy/enemyL");
		enR = new SpriteSheet("enemy/enemyR");

		IenemyDAnim = new Animation(2, 2, 16, 2, enID, true);
		IenemyUAnim = new Animation(2, 2, 16, 2, enIU, true);
		IenemyLAnim = new Animation(2, 2, 16, 2, enIL, true);
		IenemyRAnim = new Animation(2, 2, 16, 2, enIR, true);

		enemyDAnim = new Animation(2, 2, 16, 12, enD, true);
		enemyUAnim = new Animation(2, 2, 16, 12, enU, true);
		enemyLAnim = new Animation(2, 2, 16, 12, enL, true);
		enemyRAnim = new Animation(2, 2, 16, 12, enR, true);

		enemyColors = new Color[3];

		enemyColors[0] = new Color(.1f, .1f, .1f, .6f);
		enemyColors[1] = new Color(.8f, 0, 0, .6f);
		enemyColors[2] = new Color(.4f, .4f, .4f, .6f);
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

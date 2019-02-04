package com.draglantix.world;

import org.joml.Vector2f;

import com.draglantix.assets.Assets;
import com.draglantix.camera.Camera;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.entities.Enemy;
import com.draglantix.entities.Player;
import com.draglantix.spark.tiles.Tile;
import com.draglantix.spark.tiles.TileMap;
import com.draglantix.states.GameStateManager;
import com.draglantix.tiles.TileData;
import com.draglantix.tiles.TileManager;

public class World {

	public static final int SCALE = 2;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	public static final int TILE_SIZE = 32;

	public TileManager manager;
	public TileMap map;
	private Assets assets;

	private Player player;
	private Enemy enemy;

	public World(Assets assets, Graphics g) {
		this.assets = assets;

		manager = new TileManager(assets.tileSheet, TILE_SIZE, TILE_SIZE);
		map = new TileMap(WIDTH, HEIGHT);

		player = new Player(assets.IplayerDAnim, new Vector2f(32, 32), new Vector2f(TILE_SIZE * SCALE, TILE_SIZE * SCALE),
				assets.playerColors, 10f, assets);
		enemy = new Enemy(assets.IenemyDAnim, new Vector2f(64, 64), new Vector2f(TILE_SIZE * SCALE, TILE_SIZE * SCALE),
				assets.enemyColors, 10f, assets);

		assets.camera = new Camera(player, new Vector2f(0, 0), 0, 0, 0.07f);
		GameStateManager.getGraphics().setCurrentCamera(assets.camera);

		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				Vector2f pos = new Vector2f(i * TILE_SIZE * SCALE, j * TILE_SIZE * SCALE);
				TileData data = manager.getData(0);
				map.setTile(i, j, new Tile(data.getTex(), pos, new Vector2f(TILE_SIZE * SCALE), new Vector2f(i, j)));
				if(data.getColorGrading()) {
					map.getTile(i, j).setColors(data.getColors().clone());
				} else {
					map.getTile(i, j).setColor(data.getColor().clone());
				}
			}
		}
	}

	public void tick() {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				map.getTile(i, j).tick();
			}
		}

		player.tick();
		enemy.tick(player);

		assets.camera.correctCamera(new Vector2f(0, 0),
				new Vector2f(WIDTH * TILE_SIZE * SCALE, HEIGHT * TILE_SIZE * SCALE));
	}

	public void render(Graphics g) {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				map.getTile(i, j).render(g);
			}
		}

		player.render(g);
		enemy.render(g);
	}

	public void cleanUp() {

	}

}

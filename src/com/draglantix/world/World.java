package com.draglantix.world;

import org.joml.Vector2f;

import com.draglantix.assets.Assets;
import com.draglantix.tiles.Tile;
import com.draglantix.tiles.TileColors;
import com.draglantix.tiles.TileMap;
import com.draglantix.util.Color;

public class World {

	public static final int SCALE = 2;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	public static final int TILE_SIZE = 16;

	public TileMap tiles;

	public World(Assets assets) {
		TileColors.load();
		tiles = new TileMap(assets, WIDTH, HEIGHT);
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				Vector2f pos = new Vector2f(i * TILE_SIZE * SCALE, j * TILE_SIZE * SCALE);
				tiles.setTile(i, j, new Tile(tiles.getTileManager(), 1, pos,
						new Vector2f(0, 0), new Vector2f(TILE_SIZE * SCALE), TileColors.grassColors));
			}
		}
	}

}

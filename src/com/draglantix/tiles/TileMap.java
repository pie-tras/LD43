package com.draglantix.tiles;

import org.joml.Vector2f;

import com.draglantix.assets.Assets;
import com.draglantix.world.World;

public class TileMap {
	
	private Tile[][] map;
	
	public TileMap(Assets assets, int width, int height, int[][] data) {
		TileManager manager = new TileManager(assets.tiles);
		
		map = new Tile[width][height];
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				Vector2f pos = new Vector2f(x * World.TILE_SIZE * World.SCALE, y * World.TILE_SIZE * World.SCALE);
				map[x][y] = manager.getTile(0, pos, new Vector2f(World.TILE_SIZE * World.SCALE));
			}
		}
	}

}

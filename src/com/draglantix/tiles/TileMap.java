package com.draglantix.tiles;

import java.util.ArrayList;
import java.util.List;

import com.draglantix.assets.Assets;

public class TileMap {
	
	private Tile[][] map;
	
	private TileManager manager;
	
	public TileMap(Assets assets, int width, int height) {
		manager = new TileManager(assets.tileSheet, 16, 16);
		map = new Tile[width][height];
	}
	
	public Tile getTile(int x, int y) {
		return map[x][y];
	}
	
	public TileManager getTileManager() {
		return manager;
	}
	
	public Tile[][] getTiles() {
		return map;
	}
	
	public List<Tile> getTileList() {
		List<Tile> tiles = new ArrayList<Tile>();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				tiles.add(map[i][j]);
			}
		}
		return tiles;
	}
	
	public void setTile(int x, int y, Tile tile) {
		map[x][y] = tile;
	}

}

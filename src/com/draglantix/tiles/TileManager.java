package com.draglantix.tiles;

import java.util.HashMap;
import java.util.Map;

import org.joml.Vector2f;

import com.draglantix.graphics.SpriteSheet;
import com.draglantix.graphics.Texture;

public class TileManager {
	
	private Map<Integer, Texture> textures = new HashMap<Integer, Texture>();
	
	public TileManager(SpriteSheet tiles) {
		textures.put(0, new Texture(tiles.crop(new Vector2f(0, 0), new Vector2f(32, 32))));
		textures.put(1, new Texture(tiles.crop(new Vector2f(32, 0), new Vector2f(32, 32))));
		textures.put(2, new Texture(tiles.crop(new Vector2f(64, 0), new Vector2f(32, 32))));
		textures.put(3, new Texture(tiles.crop(new Vector2f(96, 0), new Vector2f(32, 32))));
		textures.put(4, new Texture(tiles.crop(new Vector2f(128, 0), new Vector2f(32, 32))));
		textures.put(5, new Texture(tiles.crop(new Vector2f(0, 32), new Vector2f(32, 32))));
		textures.put(6, new Texture(tiles.crop(new Vector2f(32, 32), new Vector2f(32, 32))));
		textures.put(7, new Texture(tiles.crop(new Vector2f(64, 32), new Vector2f(32, 32))));
		textures.put(8, new Texture(tiles.crop(new Vector2f(96, 32), new Vector2f(32, 32))));
		textures.put(9, new Texture(tiles.crop(new Vector2f(128, 32), new Vector2f(32, 32))));
		textures.put(10, new Texture(tiles.crop(new Vector2f(0, 64), new Vector2f(32, 32))));
		textures.put(11, new Texture(tiles.crop(new Vector2f(32, 64), new Vector2f(32, 32))));
		textures.put(12, new Texture(tiles.crop(new Vector2f(64, 64), new Vector2f(32, 32))));
		textures.put(13, new Texture(tiles.crop(new Vector2f(96, 64), new Vector2f(32, 32))));
		textures.put(14, new Texture(tiles.crop(new Vector2f(128, 64), new Vector2f(32, 32))));
		textures.put(15, new Texture(tiles.crop(new Vector2f(0, 96), new Vector2f(32, 32))));
		textures.put(16, new Texture(tiles.crop(new Vector2f(32, 96), new Vector2f(32, 32))));
		textures.put(17, new Texture(tiles.crop(new Vector2f(64, 96), new Vector2f(32, 32))));
		textures.put(18, new Texture(tiles.crop(new Vector2f(96, 96), new Vector2f(32, 32))));
		textures.put(19, new Texture(tiles.crop(new Vector2f(128, 96), new Vector2f(32, 32))));
		textures.put(20, new Texture(tiles.crop(new Vector2f(0, 128), new Vector2f(32, 32))));
		textures.put(21, new Texture(tiles.crop(new Vector2f(32, 128), new Vector2f(32, 32))));
		textures.put(22, new Texture(tiles.crop(new Vector2f(64, 128), new Vector2f(32, 32))));
		textures.put(23, new Texture(tiles.crop(new Vector2f(96, 128), new Vector2f(32, 32))));
		textures.put(24, new Texture(tiles.crop(new Vector2f(128, 128), new Vector2f(32, 32))));
	}
	
	public Tile getTile(int id, Vector2f pos, Vector2f scale) {
		return new Tile(textures.get(id), pos, new Vector2f(0, 0), scale, TileColors.grassColors, true);
	}
	
	public void updateTileID(Tile t, int id) {
		
	}
	
}

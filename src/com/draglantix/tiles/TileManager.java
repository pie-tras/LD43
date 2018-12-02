package com.draglantix.tiles;

import java.util.HashMap;
import java.util.Map;

import org.joml.Vector2f;

import com.draglantix.graphics.SpriteSheet;
import com.draglantix.graphics.Texture;

public class TileManager {

	private Map<Integer, Texture> textures = new HashMap<Integer, Texture>();

	public TileManager(SpriteSheet tiles, int tileWidth, int tileHeight) {
		int id = 0;
		for(int i = 0; i < tiles.getWidth(); i += tileWidth) {
			for(int j = 0; j < tiles.getHeight(); j += tileHeight) {
				textures.put(id, new Texture(tiles.crop(new Vector2f(i, j), new Vector2f(tileWidth, tileHeight))));
				id++;
			}
		}
	}
	
	public Texture getTexture(int id){
		return textures.get(id);
	}

}

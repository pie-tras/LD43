package com.draglantix.tiles;

import java.util.HashMap;
import java.util.Map;

import org.joml.Vector2f;

import com.draglantix.dragonfire.graphics.SpriteSheet;
import com.draglantix.dragonfire.graphics.Texture;
import com.draglantix.dragonfire.util.Color;

public class TileManager {

	private Map<Integer, TileData> data;
	public int numId = 0;

	public TileManager(SpriteSheet tiles, int tileWidth, int tileHeight) {
		data = new HashMap<Integer, TileData>();
		for(int j = 0; j < tiles.getHeight(); j += tileHeight) {
			for(int i = 0; i < tiles.getWidth(); i += tileWidth) {
				Texture tex = new Texture(tiles.crop(new Vector2f(i, j), new Vector2f(tileWidth, tileHeight)));
				data.put(numId, new TileData(numId, tex, new Color(.16f, .57f, .44f, 1)));
				numId++;
			}
		}
	}

	public void addSpriteSheet(SpriteSheet tiles, int tileWidth, int tileHeight) {
		data = new HashMap<Integer, TileData>();
		for(int i = 0; i < tiles.getWidth(); i += tileWidth) {
			for(int j = 0; j < tiles.getHeight(); j += tileHeight) {
				Texture tex = new Texture(tiles.crop(new Vector2f(i, j), new Vector2f(tileWidth, tileHeight)));
				data.put(numId, new TileData(numId, tex, new Color(0, 0, 0, 1)));
				numId++;
			}
		}
	}

	public TileData getData(int id) {
		return data.get(id);
	}

	public void setData(TileData data) {
		this.data.put(data.getId(), data);
	}

}

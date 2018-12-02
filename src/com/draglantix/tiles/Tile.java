package com.draglantix.tiles;

import org.joml.Vector2f;

import com.draglantix.graphics.Animation;
import com.draglantix.objects.Objects;
import com.draglantix.util.Color;

public class Tile extends Objects{
	
	private int id;
	
	public Tile(TileManager manager, int id, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors) {
		super(manager.getTexture(id), position, rotation, scale, colors, true);
	}
	
	public Tile(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors,
			boolean usesWorldPos) {
		super(anim, position, rotation, scale, colors, usesWorldPos);
	}
	
	public Tile(TileManager manager, int id, Vector2f position, Vector2f rotation, Vector2f scale, Color color) {
		super(manager.getTexture(id), position, rotation, scale, color, true);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

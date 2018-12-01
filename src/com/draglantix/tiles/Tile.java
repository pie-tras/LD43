package com.draglantix.tiles;

import org.joml.Vector2f;

import com.draglantix.graphics.Animation;
import com.draglantix.graphics.Texture;
import com.draglantix.objects.Objects;
import com.draglantix.util.Color;

public class Tile extends Objects{

	private static Texture placeHolder = null;
	
	private int biomeID;
	private int id;
	
	public Tile(int id, int biomeID, Vector2f position, Vector2f scale) {
		super(placeHolder, position, new Vector2f(0, 0), scale, , true);
	}
	
	public Tile(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors,
			boolean usesWorldPos) {
		super(anim, position, rotation, scale, colors, usesWorldPos);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

package com.draglantix.entities;

import org.joml.Vector2f;

import com.draglantix.graphics.Animation;
import com.draglantix.objects.Objects;
import com.draglantix.util.Color;

public abstract class Entity extends Objects{

	public Entity(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors) {
		super(anim, position, rotation, scale, colors, true);
	}

}

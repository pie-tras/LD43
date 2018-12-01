package com.draglantix.guis;

import org.joml.Vector2f;

import com.draglantix.graphics.Animation;
import com.draglantix.graphics.Texture;
import com.draglantix.objects.Objects;
import com.draglantix.util.Color;

public class Gui extends Objects {

	public Gui(Texture texture, Vector2f position, Vector2f rotation, Vector2f scale, Color color) {
		super(texture, position, rotation, scale, color, false);
	}

	public Gui(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color color) {
		super(anim, position, rotation, scale, color, false);
	}

}

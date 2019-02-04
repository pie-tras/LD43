package com.draglantix.entities;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.graphics.Animation;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.dragonfire.window.Window;
import com.draglantix.spark.entities.Entity;

public class Player extends Entity {

	private Assets assets;
	private float speed;
	private boolean moved = false;
	private Vector2f last = new Vector2f();

	public Player(Animation anim, Vector2f position, Vector2f scale, Color[] colors, float speed, Assets assets) {
		super(anim, position, scale, true);
		setColors(colors);
		this.assets = assets;
		this.speed = speed;
	}

	@Override
	public void tick() {
		super.tick();

		Vector2f target = new Vector2f(0, 0);

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A)) {
			target.x -= speed;
			moved = true;
		}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_W)) {
			target.y += speed;
			moved = true;
		}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_S)) {
			target.y -= speed;
			moved = true;
		}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			target.x += speed;
			moved = true;
		}

		if(target.y > 0) {
			setAnimation(assets.playerUAnim);
		} else if(target.y < 0) {
			setAnimation(assets.playerDAnim);
		}

		if(target.x > 0) {
			setAnimation(assets.playerRAnim);
		} else if(target.x < 0) {
			setAnimation(assets.playerLAnim);
		}

		if(!moved) {
			if(getLast().y > 0) {
				setAnimation(assets.IplayerUAnim);
			} else if(getLast().y < 0) {
				setAnimation(assets.IplayerDAnim);
			}

			if(getLast().x > 0) {
				setAnimation(assets.IplayerRAnim);
			} else if(getLast().x < 0) {
				setAnimation(assets.IplayerLAnim);
			}
		}

		position.add(target);
		moved = false;
		setLast(target);
	}

	public Vector2f getLast() {
		return last;
	}

	public void setLast(Vector2f last) {
		this.last = last;
	}
	
	

}

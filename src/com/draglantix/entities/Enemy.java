package com.draglantix.entities;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.graphics.Animation;
import com.draglantix.dragonfire.objects.Obj;
import com.draglantix.dragonfire.util.Color;
import com.draglantix.dragonfire.window.Window;
import com.draglantix.spark.entities.Entity;

public class Enemy extends Entity {

	private Assets assets;
	private float speed;
	private boolean moved = false;
	private Vector2f last = new Vector2f();
	Player player = new Player(anim, last, last, colors, speed, assets);
	

	public Enemy(Animation anim, Vector2f position, Vector2f scale, Color[] colors, float speed, Assets assets) {
		super(anim, position, scale, true);
		setColors(colors);
		this.assets = assets;
		this.speed = speed;
		
		
	}

	public void tick() {
		super.tick();
		Vector2f target = new Vector2f(0, 0);
		
		
		
		Vector2f playerPos = player.getPosition();
		
		Vector2f destination = new Vector2f(playerPos.x - position.x, playerPos.y - position.y);
		
		destination.normalize(speed);
		
		if(destination.x < 0) {
			target.x -= speed;
			moved = true;
		}
		if(destination.x > 0) {
			target.x += speed;
			moved = true;
		}
		if(destination.y < 0) {
			target.y -= speed;
			moved = true;
		}
		if(destination.y < 0) {
			target.y += speed;
			moved = true;
		}
		
		

		if(target.y > 0) {
			setAnimation(assets.enemyUAnim);
		} else if(target.y < 0) {
			setAnimation(assets.enemyDAnim);
		}

		if(target.x > 0) {
			setAnimation(assets.enemyRAnim);
		} else if(target.x < 0) {
			setAnimation(assets.enemyLAnim);
		}

		if(!moved) {
			if(last.y > 0) {
				setAnimation(assets.IenemyUAnim);
			} else if(last.y < 0) {
				setAnimation(assets.IenemyDAnim);
			}

			if(last.x > 0) {
				setAnimation(assets.IenemyRAnim);
			} else if(last.x < 0) {
				setAnimation(assets.IenemyLAnim);
			}
		}
		
		
		position.add(target);
		moved = false;
		last = target;
	}
	

}

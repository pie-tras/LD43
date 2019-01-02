package com.draglantix.entities;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.graphics.Animation;
import com.draglantix.util.Color;
import com.draglantix.window.Window;

public class Enemy extends Entity {

	private Assets assets;
	private float speed;
	private boolean moved = false;
	private Vector2f last = new Vector2f();
	
	public Enemy(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors, float speed, Assets assets) {
		super(anim, position, rotation, scale, colors);
		this.assets = assets;
		this.speed = speed;
	}

	public void tick() {
		super.tick();
	//TODO Find out why its not rendering, probably because I just copied the player and making a second player doesn't work that way	
Vector2f target = new Vector2f(0, 0);
		
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_LEFT)){target.x -= speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_UP)){target.y += speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_DOWN)){target.y -= speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_RIGHT)){target.x += speed; moved = true;}
		
		if(target.y > 0) {
			setAnim(assets.enemyUAnim);
		}else if(target.y < 0){
			setAnim(assets.enemyDAnim);
		}
		
		if(target.x > 0) {
			setAnim(assets.enemyRAnim);
		}else if(target.x < 0){
			setAnim(assets.enemyLAnim);
		}
		
		if(!moved) {
			if(last.y > 0) {
				setAnim(assets.IenemyUAnim);
			}else if(last.y < 0){
				setAnim(assets.IenemyDAnim);
			}
			
			if(last.x > 0) {
				setAnim(assets.IenemyRAnim);
			}else if(last.x < 0){
				setAnim(assets.IenemyLAnim);
			}
		}
		
		position.add(target);
		moved = false;
		last = target;
	}
	
}

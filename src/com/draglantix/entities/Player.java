package com.draglantix.entities;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.Assets;
import com.draglantix.graphics.Animation;
import com.draglantix.util.Color;
import com.draglantix.window.Window;

public class Player extends Entity{

	private Assets assets;
	private float speed;
	private boolean moved = false;
	private Vector2f last = new Vector2f();
	
	public Player(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Color[] colors, float speed, Assets assets) {
		super(anim, position, rotation, scale, colors);
		this.assets = assets;
		this.speed = speed;
	}

	@Override
	public void tick() {
		super.tick();
		
		Vector2f target = new Vector2f(0, 0);
		
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A)){target.x -= speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_W)){target.y += speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_S)){target.y -= speed; moved = true;}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)){target.x += speed; moved = true;}
		
		if(target.y > 0) {
			setAnim(assets.playerUAnim);
		}else if(target.y < 0){
			setAnim(assets.playerDAnim);
		}
		
		if(target.x > 0) {
			setAnim(assets.playerRAnim);
		}else if(target.x < 0){
			setAnim(assets.playerLAnim);
		}
		
		if(!moved) {
			if(last.y > 0) {
				setAnim(assets.IplayerUAnim);
			}else if(last.y < 0){
				setAnim(assets.IplayerDAnim);
			}
			
			if(last.x > 0) {
				setAnim(assets.IplayerRAnim);
			}else if(last.x < 0){
				setAnim(assets.IplayerLAnim);
			}
		}
		
		position.add(target);
		moved = false;
		last = target;
	}
	
}

package com.draglantix.camera;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import com.draglantix.entities.Player;
import com.draglantix.graphics.ICamera;

public class Camera implements ICamera{
		
		private Vector2f position;
		private float roll, lerp, zoom;
		
		private Vector2f shake = new Vector2f(0, 0);
		
		private Player player;
		
		public Camera(Player player, Vector2f position, float roll, float zoom, float lerp) {
			this.player = player;
			this.position = position;
			this.roll = roll;
			this.zoom = zoom;
			this.lerp = lerp;
		}
		
		
		@Override
		public void move() {
			position.lerp(player.getPosition(), lerp);
		}
	
		@Override
		public Matrix4f createViewMatrix() {
			Matrix4f view = new Matrix4f();
			view.scale((float) Math.exp(zoom));
			view.rotate((float) (Math.toRadians(roll + (shake.x / 2))), 0, 0, 1);
			view.translate(-position.x, -position.y, 0);
			return view;
		}
	
		@Override
		public Vector2f getPosition() {
			return position;
		}
	
		@Override
		public float getZoom() {
			return (float) Math.exp(zoom);
		}
		
}


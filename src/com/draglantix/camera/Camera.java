package com.draglantix.camera;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.ICamera;
import com.draglantix.window.Window;

public class Camera implements ICamera{
		
		private Vector2f position;
		private float roll, lerp, zoom, sensitivity;
		
		private Vector2f lastMousePosition;
		private boolean isMouseClicked = false;
		
		private Vector2f shake = new Vector2f(0, 0);
		
		public Camera(Vector2f position, float roll, float zoom, float lerp, float sensitivity) {
			this.position = position;
			this.roll = roll;
			this.zoom = zoom;
			this.lerp = lerp;
			this.sensitivity = sensitivity;
		}
		
		
		@Override
		public void move() {
			Vector2f delta = new Vector2f();
			if (Window.getInput().isMouseButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
				if (!isMouseClicked) {
					lastMousePosition = Window.getInput().getMousePos();
					isMouseClicked = true;
				}
				Vector2f currentPos = Window.getInput().getMousePos();
				delta.x = (lastMousePosition.x - currentPos.x)*sensitivity;
				delta.y = (currentPos.y - lastMousePosition.y)*sensitivity;
				lastMousePosition = currentPos;
			} else {
				isMouseClicked = false;
			}

			Vector2f tempPosition = position.add(delta, new Vector2f());

			position.lerp(tempPosition, lerp);
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


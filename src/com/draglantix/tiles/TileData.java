package com.draglantix.tiles;

import com.draglantix.dragonfire.graphics.Animation;
import com.draglantix.dragonfire.graphics.Texture;
import com.draglantix.dragonfire.util.Color;

public class TileData {

	private int id;
	private Texture tex;
	private Animation anim;
	private Color color;
	private Color[] colors;
	private boolean colorGrading = false;
	
	public TileData(int id, Texture tex, Color[] colors) {
		this.id = id;
		this.tex = tex.clone();
		this.colors = colors.clone();
		colorGrading = true;
	}

	public TileData(int id, Texture tex, Color color) {
		this.id = id;
		this.tex = tex.clone();
		this.color = color.clone();

	}

	public TileData(int id, Animation anim, Color[] colors) {
		this.id = id;
		this.anim = anim.clone();
		this.colors = colors.clone();
		colorGrading = true;
	}

	public TileData(int id, Animation anim, Color color) {
		this.id = id;
		this.anim = anim.clone();
		this.color = color.clone();
	}

	public int getId() {
		return id;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex.clone();
	}

	public Animation getAnim() {
		return anim;
	}

	public void setAnim(Animation anim) {
		this.anim = anim.clone();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color.clone();
		colorGrading = false;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors.clone();
		colorGrading = true;
	}
	
	public boolean getColorGrading() {
		return colorGrading;
	}

}

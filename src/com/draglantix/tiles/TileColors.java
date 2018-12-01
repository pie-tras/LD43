package com.draglantix.tiles;

import com.draglantix.util.Color;

public class TileColors {

	public static Color[] grassColors;
	
	public static void load() {
		grassColors = new Color[6];
		grassColors[0] = new Color(.16f, .57f, .44f, 1);
		grassColors[1] = new Color(.26f, .67f, .54f, 1);
		grassColors[2] = new Color(.2f, .7f, .5f, 1);
		grassColors[3] = new Color(.32f, .29f, .25f, 1);
		grassColors[4] = new Color(.2f, .2f, .2f, 1);
		grassColors[5] = new Color(.4f, .4f, .4f, 1);
	}
	
}

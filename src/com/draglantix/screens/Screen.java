package com.draglantix.screens;

import java.util.ArrayList;
import java.util.List;

import com.draglantix.assets.Assets;
import com.draglantix.dragonfire.font.Message;
import com.draglantix.dragonfire.graphics.Graphics;
import com.draglantix.dragonfire.objects.Obj;

public abstract class Screen {

	protected Assets assets;
	
	protected List<Obj> objects = new ArrayList<Obj>();
	protected List<Message> messages = new ArrayList<Message>();
	
	public Screen(Assets assets) {
		this.assets = assets;
	}
	
	public void addObjects(Obj... objs) {
		for(Obj o : objs) {
			objects.add(o);
		}
	}
	
	public void addMessages(Message... msgs) {
		for(Message m : msgs) {
			messages.add(m);
		}
	}
	
	public void render(Graphics g) {
		for(Obj o : objects) {
			o.render(g);
		}
		for(Message m : messages) {
			g.drawMsg(m);
		}
	}
	
	public void tick() {
		for(Obj o : objects) {
			o.tick();
		}
	}
	
}

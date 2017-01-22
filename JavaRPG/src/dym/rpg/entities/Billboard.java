package dym.rpg.entities;

import java.awt.Graphics;

import dym.rpg.graphics.Image;
import dym.rpg.physics.Vector2;

public class Billboard extends Entity {
	Image img;
	int off_x=0;
	protected int off_y=0;
	public Billboard(Image bbimg, Vector2 pos) {
		super(pos);
		img=bbimg;
	}
	
	@Override
	public void draw(Graphics g) {	
		img.draw(g, (int)pos.x-off_x, (int)pos.y-off_y);
		
	}
}

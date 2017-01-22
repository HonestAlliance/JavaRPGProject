package dym.rpg.tile;

import java.awt.Color;
import java.awt.Graphics;

import dym.rpg.entities.Entity;
import dym.rpg.graphics.Image;
import dym.rpg.physics.Vector2;

public class Tile extends Entity {
	String name;
	private Image image;
	public Tile(Vector2 pos, Image image, String name) {
		super(pos);
		this.image = image;
		this.name = name;
	}public Tile(Vector2 pos, Image image) {
		super(pos);
		this.image = image;
		this.name = "no";
		
	}
	public String getName(){
		return name;
	}
	@Override
	public void update() {}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		System.out.println(image);
		image.draw(g, (int)pos.x, (int)pos.y);
	}

	public void drawEditor(Graphics g) {
		g.setColor(Color.WHITE);
		image.drawEditor(g, (int)pos.x, (int)pos.y);
	}
}

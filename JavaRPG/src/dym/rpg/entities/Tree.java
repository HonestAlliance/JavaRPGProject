package dym.rpg.entities;

import java.awt.Color;
import java.awt.Graphics;

import dym.rpg.Game;

public class Tree extends Entity {
	
	public Tree(int x, int y){
		pos.x=x;
		pos.y=y;
	}
	@Override
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		Game.tree.draw(g, (int)pos.x-22, (int)pos.y);
	}
}

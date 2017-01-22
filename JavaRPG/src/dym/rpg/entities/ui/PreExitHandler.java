package dym.rpg.entities.ui;


import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.scene.Scene;
import dym.rpg.scene.SceneManager;
import dym.rpg.Game;

public class PreExitHandler extends Entity{
	
	@Override
	public void update() {
		if (Input.keysDown.contains(KeyEvent.VK_X)){
			System.exit(0);
		}
	}
	@Override
	public void draw(Graphics g) {
	Game.preEx.drawUI(g, 0,0);
	}
}

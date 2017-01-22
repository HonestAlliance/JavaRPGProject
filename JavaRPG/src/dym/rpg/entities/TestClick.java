package dym.rpg.entities;

import dym.rpg.physics.Rect;
import dym.rpg.physics.Vector2;
import dym.rpg.scene.SceneManager;

public class TestClick extends Entity {
	public TestClick(Vector2 pos) {
		super(pos,new Rect(0,0,32,32));
		
	}
	@Override
	public void click() {
		SceneManager.currentScene = SceneManager.testScene2;
	}
}

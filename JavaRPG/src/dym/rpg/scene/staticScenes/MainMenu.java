package dym.rpg.scene.staticScenes;

import dym.rpg.entities.TestClick;
import dym.rpg.entities.ui.MainMenuHandler;
import dym.rpg.physics.Vector2;
import dym.rpg.scene.Scene;

public class MainMenu extends Scene {
	public MainMenu(){
		super(true);
		this.entities.add(new MainMenuHandler());
		this.entities.add(new TestClick(new Vector2(0,0)));
		}
}

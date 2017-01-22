package dym.rpg.scene.staticScenes;

import dym.rpg.entities.ui.PreExitHandler;
import dym.rpg.scene.Scene;


public class PreX extends Scene {
	public PreX(){
		super(true);
		this.entities.add(new PreExitHandler());
	}
}

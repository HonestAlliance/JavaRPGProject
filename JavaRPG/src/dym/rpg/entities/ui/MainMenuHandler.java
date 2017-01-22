package dym.rpg.entities.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.rpg.Display;
import dym.rpg.Game;
import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.scene.Scene;
import dym.rpg.scene.SceneManager;

public class MainMenuHandler extends Entity {
/* The second menu button is broken, and we do not know why at the moment. Work is being done, but it is no longer
 * top priority for us. We would rather have an actual game than UI, despite UI being really sexy.
 */
	
	public static final int menuButtons = 	1;
	private static int arrowlocation; 
	public static final Scene[] selectionDestinations = {SceneManager.testScene2, SceneManager.preX};


	public MainMenuHandler() {
		super();
		//Set the starting arrow location;
				arrowlocation = 13;
	}
	
	/*private static Scene dispose() {
		// TODO Auto-generated method stub
		dispose();
		System.out.println("DONE");
		System.exit (0);
		return null;
		
	}
*/
	public void resetSelection() {
		arrowlocation = 13;
	}
	
	@Override
	public void update() {
		Game.uiMenuArrow.animate();
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
		
			Input.keysDown.remove((Object)KeyEvent.VK_LEFT);
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			
			Input.keysDown.remove((Object)KeyEvent.VK_RIGHT);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_UP)) {
			//Move arrow up
			if (arrowlocation>13) {
				arrowlocation-=120;
			}
			Input.keysDown.remove((Object)KeyEvent.VK_UP);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_DOWN)) {
			//Move arrow down
			if (arrowlocation<13+20*(menuButtons-1)) {
				arrowlocation+=120;
			}
			
			
			Input.keysDown.remove((Object)KeyEvent.VK_DOWN);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_X)){
			//System.exit(0);
			
			SceneManager.gotoScene(selectionDestinations[(int)((arrowlocation-13)/120)]);
			Input.keysDown.remove((Object)KeyEvent.VK_X);
		}
		if (Input.keysDown.contains(KeyEvent.VK_ESCAPE)){
			System.exit(0);
		
		}
	}
	
	@Override
	public void draw(Graphics g) {
		Game.uiMainMenu.drawUI(g, 0, 0);
		Game.uiNG_u.drawUI(g, 23, 4);
		Game.uiEx.drawUI(g, 23, 150);
		Game.uiMenuArrow.drawUI(g, 20, arrowlocation);
	}
}

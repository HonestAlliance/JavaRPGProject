package dym.rpg.scene;

import dym.rpg.entities.ui.PreExitHandler;
import dym.rpg.scene.staticScenes.MainMenu;
import dym.rpg.scene.staticScenes.PreX;
import dym.rpg.scene.staticScenes.SettingsScreen;
import dym.rpg.scene.staticScenes.TestScene;
import dym.rpg.scene.staticScenes.TestScene2;

public class SceneManager {
	public static TestScene testScene1;
	public static TestScene2 testScene2;
	public static SettingsScreen settings;
	public static MainMenu mainMenu = new MainMenu();
	public static PreX preX = new PreX();
	
	
	public static Scene currentScene;
	public static Scene prevScene;
	
	public static void init() {
		testScene1 = new TestScene();
		testScene2 = new TestScene2();
		settings = new SettingsScreen();
		mainMenu = new MainMenu();
		preX = new PreX();
	}
	
	public static void gotoScene(Scene s) {
		prevScene = currentScene;
		currentScene = s;
	}
	public static void gotoPrev() {
		currentScene = prevScene;
	}
}

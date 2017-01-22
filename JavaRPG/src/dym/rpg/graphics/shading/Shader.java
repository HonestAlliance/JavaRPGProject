package dym.rpg.graphics.shading;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dym.rpg.Game;
import dym.rpg.graphics.Image;
import dym.rpg.physics.Vector2;
import dym.rpg.scene.SceneManager;

public class Shader {
	private static ArrayList<Pixel> pixels = new ArrayList<Pixel>();
	private static Color tint;
	public static void init() {
		tint = new Color(0,0,0,127);
		//Initialize a grid of pixels.
		for (int y=0;y<240;y++) {
			for (int x=0;x<320;x++) {
				pixels.add(new Pixel(new Vector2(x,y),0,0,0,127));
			}
		}
	}
	public static void update() {
		for (Pixel p : pixels) {
			int a=tint.getAlpha();
			for (Light l : SceneManager.currentScene.lights) {
				a-=l.getStrengthAtPoint(p.pos);
			}
			if (a<0)a=0;
			if (a>255) a=255;
			p.c = new Color(tint.getRed(),tint.getGreen(),tint.getBlue(),a);
		}
	}
	public static void updateNoLight() {
		for (Pixel p : pixels) {
			int a=tint.getAlpha();
			if (a<0)a=0;
			if (a>255) a=255;
			p.c = new Color(tint.getRed(),tint.getGreen(),tint.getBlue(),a);
		}
	}
	public static void setTint(Color newTint) {
		tint=newTint;
	}
	public static void draw(Graphics g) {
		for (Pixel p : pixels) {
			p.draw(g);
		}
	}
	
}

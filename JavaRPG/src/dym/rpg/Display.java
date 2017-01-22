package dym.rpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

import dym.rpg.entities.Billboard;
import dym.rpg.entities.Entity;
import dym.rpg.graphics.shading.Shader;
import dym.rpg.graphics.text.ClockText;
import dym.rpg.scene.Scene;
import dym.rpg.scene.SceneManager;


public class Display extends JPanel {
	private static final long serialVersionUID = -1960615037265171080L;
	//Width and height of the view.
	public static final int WIDTH = 320, HEIGHT = 240;
	//Width and height of the display.
	public static int width = 1280, height = 960;
	
	//Reference to the Window.
	Game game;
	public Display(Game g) {
		game = g;
	}
	//Scale coordinates from view to fit on display.
	public double ScaleCoordinateX(double x) {
		if (width>320)
			return (this.getWidth()*x/WIDTH)-1;
		return (this.getWidth()*x/WIDTH);
	}
	public double ScaleCoordinateY(double y) {
		if (height>240)
			return (this.getHeight()*y/HEIGHT)-1 ;
		return (this.getHeight()*y/HEIGHT);
	}
	public void paintComponent(Graphics g) {
		//Scale and center the display on the window;
		setSize(new Dimension(width,height));
		if (this.getWidth()>1280 || this.getHeight()>960) {
			this.setSize(new Dimension(1280, 960));
		}
		if (this.getWidth()<320 || this.getHeight()<240) {
			this.setSize(new Dimension(320, 240));
		}
		setLocation(game.getWidth()/2-getWidth()/2, game.getHeight()/2-getHeight()/2);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Draw all tiles.
		SceneManager.currentScene.tileMap.drawTiles(g);
		for (Entity e : SceneManager.currentScene.entities) {
				if (e.pos.y<Game.p.pos.y) 
					e.draw(g);
			
		}
		
		
		//Draw the player (Unless on menu)
		if (!SceneManager.currentScene.menuScene)
			Game.p.draw(g);
		
		for (Entity e : SceneManager.currentScene.entities) {
			if (e.pos.y>=Game.p.pos.y)
				e.draw(g);
		}
		
		
		//Draw Dawn/Evening/Night Shading;
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (!(SceneManager.currentScene.lighting==Scene.LIGHT)&&!SceneManager.currentScene.menuScene) {
			if (hour<9 || hour>19 || SceneManager.currentScene.lighting==Scene.DARK) {
				Shader.setTint(new Color(0,0,0,230));
				Shader.update();
				Shader.draw(g);
			} else if (hour<7||hour>=21) {
				Shader.setTint(new Color(20,0,0,127));
				Shader.update();
				Shader.draw(g);
			}
		}
		g.setColor(Color.WHITE);
		//Draw clock
		if (!SceneManager.currentScene.menuScene) {
			Game.uiClock.drawUI(g, 0, 0);
			String ampm="am";
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>=12) {
				ampm="pm";
			}
			int hours = Calendar.getInstance().get(Calendar.HOUR);
			String hourText;
			if (hours<10) {
				hourText = "0"+hours;
			} else {
				hourText = hours+"";
			}
			if (hourText.equals("00")) {
				hourText="12";
			}
			int minutes = Calendar.getInstance().get(Calendar.MINUTE);
			String minuteText;
			if (minutes<10) {
				minuteText = "0"+minutes;
			} else {
				minuteText = minutes+"";
			}
			String timeText=hourText+":"+minuteText+ampm;
			int pos = 0;
			for (char c:timeText.toUpperCase().toCharArray()) {
				if (ClockText.getCharacterImage(c)!=null)
					ClockText.getCharacterImage(c).drawUI(g, pos*6+5, 2);
				pos++;
			}
		}
		//Draw pop-up menu;
		if (Game.p.menu) {
			Game.menu.draw(g);
		}
		if (MessageHandler.busy) {
			MessageHandler.draw(g);
		}
		
	}
}

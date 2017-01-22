package dym.rpg.scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dym.rpg.entities.Entity;
import dym.rpg.graphics.shading.Light;
import dym.rpg.physics.Collision;
import dym.rpg.physics.CollisionMap;
import dym.rpg.physics.Vector2;
import dym.rpg.physics.CollisionMap.CollisionType;
import dym.rpg.tile.Tile;
import dym.rpg.tile.TileMap;
import dym.rpg.tile.Tiles;

public abstract class Scene {
	public TileMap tileMap;
	public CollisionMap collisionMap;
	public ArrayList<Entity> entities;
	public ArrayList<Light> lights;
	public boolean menuScene=false;
	public int lighting=TIME_BASED;
	
	public static final int TIME_BASED=0,DARK=1,LIGHT=2;
	public Scene() {
		menuScene = false;
		tileMap = new TileMap();
		collisionMap = new CollisionMap();
		entities = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
	}
	public Scene(File f) {
		this();
		
			try {
				BufferedReader r = new BufferedReader(new FileReader(f));
				String line = "";
				while ((line=r.readLine())!=null) {
					String[] splt = line.split(" ");
					if (splt[0].equals("t")) {
						tileMap.mainTiles.add(new Tile(new Vector2(Double.parseDouble(splt[1]), Double.parseDouble(splt[2])), Tiles.images[Integer.parseInt(splt[3])]));
					}
					if (splt[0].equals("c")) {
						collisionMap.collisions.add(new Collision(CollisionType.SOLID, Integer.parseInt(splt[1]), Integer.parseInt(splt[2])));
					}
				}
				
			} catch (FileNotFoundException e) {
				System.err.println("File not found.");
			} catch (IOException e) {
				System.err.println("Cannot read line.");
			}
			System.out.print(tileMap.mainTiles);
		
	}
	public Scene(boolean menuScene) {
		this();
		this.menuScene = menuScene;
	}
	public Scene(boolean menuScene, int lighting) {
		this();
		this.menuScene = menuScene;
		this.lighting = lighting;
	}
}

package dym.rpg.scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dym.rpg.entities.Entity;
import dym.rpg.graphics.shading.Light;
import dym.rpg.physics.Collision;
import dym.rpg.physics.CollisionMap;
import dym.rpg.physics.CollisionMap.CollisionType;
import dym.rpg.physics.Vector2;
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
	public Scene(String s) {
		this();
		//TODO: LOAD SCENE DATA FROM FILE
		try {
            BufferedReader in=new BufferedReader(new FileReader(s));
           	String line;
           	//Set line equal to the next line and only do the loop if it has a value
            while ((line=in.readLine())!=null) {
           		String[] splt = line.split(" ");
           		if (splt[0]=="t") {
           			if (splt.length!=4) {
           				System.err.println("Incorrect format!");
           			} else {
           				tileMap.mainTiles.add(new Tile(new Vector2(Integer.parseInt(splt[1]), Integer.parseInt(splt[2])), Tiles.tiles.get(splt[3])));
           			}
           		} else if (splt[0]=="c") {
           			if (splt.length!=4) {
           				System.err.println("Incorrect format!);");
           			} else {
           				collisionMap.collisions.add(new Collision(CollisionType.SOLID,Integer.parseInt(splt[1]), Integer.parseInt(splt[2])));
           			}
           		}
           	}
            in.close();
        } catch (IOException e) {
            System.out.println("Cannot open file.");
        }
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

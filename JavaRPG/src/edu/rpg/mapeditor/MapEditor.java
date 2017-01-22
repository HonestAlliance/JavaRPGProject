package edu.rpg.mapeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.graphics.Image;
import dym.rpg.graphics.shading.Light;
import dym.rpg.physics.Collision;
import dym.rpg.physics.CollisionMap;
import dym.rpg.physics.Vector2;
import dym.rpg.physics.CollisionMap.CollisionType;
import dym.rpg.tile.Tile;
import dym.rpg.tile.TileMap;
import dym.rpg.tile.Tiles;

public class MapEditor extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5156583402135090840L;
	private static Input i;
	
	
	Image[] tileArray = {
			Tiles.tile_grass1,
			Tiles.tile_boulder_brown,
			Tiles.tile_boulder_grey,
			Tiles.tile_lamp_base,
			Tiles.tile_lamp_post,
			Tiles.tile_lamp,
			Tiles.tile_sign1
		};
	String[] names = {
			"grass1",
			"boulder_brown",
			"boulder_grey",
			"lamp_base",
			"lamp_post",
			"lamp",
			"sign1"
	};
	int index = 0;
	JFrame frame;
	int x = 0;
	int y = 0;
	JFileChooser chooser = new JFileChooser(); 
	boolean m1d = false; //as in Mouse Button 1 down
	boolean m2d = false; //as in Mouse Button 2 down
	boolean m3d = false; //as in Mouse Button 3 down
	boolean col = false; //as in Collisions
	
	
	public TileMap tileMap;
	public CollisionMap collisionMap;
	public ArrayList<Entity> entities;
	public ArrayList<Light> lights;
	
	public MapEditor() {
		super();
		Tiles.init();
		i = new Input();
		tileMap = new TileMap();
		collisionMap = new CollisionMap();
		entities = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
		
		frame = new JFrame("Map Editor V1.0");
		//frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(1280,720);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.addKeyListener(i);
		
		while (true) {
			tileSelect();
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]) {
		new MapEditor();
	}
	@Override
	public void paintComponent(Graphics g) {
		Iterator<Tile> iter = tileMap.mainTiles.iterator();
		Iterator<Collision> itera = collisionMap.collisions.iterator();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setColor(Color.WHITE);
		/*for (int x = 0; x<1280; x+=16) {
			g.drawLine(x, 0, x, 720);
		}
		for (int y = 0; y<720; y+=16) {
			g.drawLine(0, y, 1280, y);
		}*/
		tileMap.drawTilesEditor(g);
		g.setColor(new Color(0xFF,0x00,0x00,0x7F));
		for (Collision c : collisionMap.collisions) {
			g.fillRect(c.x, c.y, 16, 16);
		}
		g.setColor(Color.CYAN);
		x = 0;
		y = 0;
		try {
			x = getMousePosition().x;
			x=x-x%16;
			y = getMousePosition().y;
			y=y-y%16;
			g.drawRect(x-1, y-1, 18, 18);
			if (col) {
				if (m3d == true){
	
				}
				if (m2d == true){
					while (itera.hasNext()){
						Collision u = itera.next();
						if (u.x==x&&u.y==y) {
							itera.remove();				
						}
					}
				}
				if (m1d == true){
					while (itera.hasNext()){
						Collision u = itera.next();
						if (u.x==x&&u.y==y) {
							itera.remove();				
						}
					}
	
					collisionMap.collisions.add(new Collision(CollisionType.SOLID, x, y));
				}
			} else {
				if (m3d == true){
					tileMap.mainTiles.add(new Tile(new Vector2(x,y), tileArray[index], ""+index));
	
				}
				if (m2d == true){
					while (iter.hasNext()){
						Tile t = iter.next();
						if (t.pos.x==x&&t.pos.y==y) {
							iter.remove();				
						}
					}
				}
				if (m1d == true){
					while (iter.hasNext()){
						Tile t = iter.next();
						if (t.pos.x==x&&t.pos.y==y) {
							iter.remove();				
						}
					}
	
					tileMap.mainTiles.add(new Tile(new Vector2(x,y), tileArray[index], ""+index));
				}
			}
		} 
		catch (NullPointerException e) {
			System.err.println("Null Mouse Pointer Exception");
		}
	}
	public void save() {
		chooser.showSaveDialog(frame);
		try {
            PrintWriter out= new PrintWriter(chooser.getSelectedFile().getPath());
            for (Tile t :tileMap.mainTiles){
            	out.println("t "+t.pos.x +" " +t.pos.y +" " +t.getName());
            	
            }
            for (Collision c : collisionMap.collisions){
            	out.println("c "+c.x +" " +c.y +" " +c.cType.toString());
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Cannot open file.");
        }
	}
	
	public void tileSelect(){
		/*
		 * DO NOT PUT ANYTHING ON C I SWEAR TO GOD YOU WILL BREAD EVERYTHING
		 * ~a self note from Jordan
		 */
		if(Input.keysDown.contains(KeyEvent.VK_1)){
			index = 0;
		}
		if(Input.keysDown.contains(KeyEvent.VK_2)){
			index = 1;
		}
		if(Input.keysDown.contains(KeyEvent.VK_3)){
			index = 2;
		}
		if(Input.keysDown.contains(KeyEvent.VK_4)){
			index = 3;
		}
		if(Input.keysDown.contains(KeyEvent.VK_5)){
			index = 4;
		}
		if(Input.keysDown.contains(KeyEvent.VK_6)){
			index = 5;
		}
		if(Input.keysDown.contains(KeyEvent.VK_7)){
			index = 6;
		}
		if(Input.keysDown.contains(KeyEvent.VK_ENTER)){
			save();
			Input.keysDown.remove((Object)KeyEvent.VK_ENTER);
		}
		if(Input.keysDown.contains(KeyEvent.VK_C)){
			col = !col;//ANYTHING
			Input.keysDown.remove((Object)KeyEvent.VK_C);
		}
	/*	if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
			if (index>0)
			index--;
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			if (index<=tileArray.length)
				index++;
		} */
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		//place tileArray[index]; at pos x,y
		if (e.getButton()==MouseEvent.BUTTON1){
			m1d = true;
			System.out.println(index);
			System.out.println(tileArray);
		}
		
		if (e.getButton()==MouseEvent.BUTTON3) {
			m2d = true;

		}
		
		if (e.getButton()==MouseEvent.BUTTON2){
			m3d = true;
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		m1d = false;
		m2d = false;
		m3d = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}

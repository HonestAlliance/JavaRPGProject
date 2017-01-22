package dym.rpg.tile;

import java.io.File;
import java.util.HashMap;

import dym.rpg.graphics.Image;

public class Tiles {
	public static Image tile_grass1 = new Image(new File("res"+File.separator+"tiles"+File.separator+"grass1.png"));
	public static Image tile_rock = new Image(new File("res"+File.separator+"tiles"+File.separator+"rock.png"));
	public static Image tile_boulder_brown = new Image(new File("res"+File.separator+"tiles"+File.separator+"brown_boulder.png"));
	public static Image tile_boulder_grey = new Image(new File("res"+File.separator+"tiles"+File.separator+"grey_boulder.png"));
	public static Image tile_lamp_base = new Image(new File("res"+File.separator+"tiles"+File.separator+"lampbase.png"));
	public static Image tile_lamp_post = new Image(new File("res"+File.separator+"tiles"+File.separator+"lamppost.png"));
	public static Image tile_lamp= new Image(new File("res"+File.separator+"tiles"+File.separator+"lamp.png"));

	public static Image[] images = {
			tile_grass1,
			tile_boulder_brown,
			tile_boulder_grey,
			tile_lamp_base,
			tile_lamp_post,
			tile_lamp
		};
}

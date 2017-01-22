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
	public static Image tile_lamp = new Image(new File("res"+File.separator+"tiles"+File.separator+"lamp.png"));
	public static Image tile_asphalt_b = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_b.png"));
	public static Image tile_asphalt_dl_in = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_dl_in.png"));
	public static Image tile_asphalt_dl_out = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_dl_out.png"));
	public static Image tile_asphalt_dr_in = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_dr_in.png"));
	public static Image tile_asphalt_dr_out = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_dr_out.png"));
	public static Image tile_asphalt_l = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_l.png"));
	public static Image tile_asphalt_r = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_r.png"));
	public static Image tile_asphalt_u = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_u.png"));
	public static Image tile_asphalt_ul_in = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_ul_in.png"));
	public static Image tile_asphalt_ul_out = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_ul_out.png"));
	public static Image tile_asphalt_ur_in = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_ur_in.png"));
	public static Image tile_asphalt_ur_out = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt_ur_out.png"));
	public static Image tile_asphalt = new Image(new File("res"+File.separator+"tiles"+File.separator+"asphalt.png"));
	public static Image tile_sign1 = new Image(new File("res"+File.separator+"tiles"+File.separator+"sign1.png"));
	
	public static HashMap<Integer, Image> tiles;
	
	public static void init() {
		tiles = new HashMap<Integer, Image>();
		/*
		 * NOTE: Dylan, I'm sorry, but I shortened "asphalt" to "as". Otherwise, I'd go completely insane.
		 * I do kind of want to continue that naming convention, but it's alright for right now.
		 * ~Jordan
		 */
		tiles.put(0, tile_grass1);
		tiles.put(-1, tile_rock);
		tiles.put(1, tile_boulder_brown);
		tiles.put(2, tile_boulder_grey);
		tiles.put(3, tile_lamp_base);
		tiles.put(4, tile_lamp_post);
		tiles.put(5, tile_lamp);
		tiles.put(6, tile_asphalt_b);
		tiles.put(7, tile_asphalt_dl_in);
		tiles.put(8, tile_asphalt_dl_out);
		tiles.put(9, tile_asphalt_dr_in);
		tiles.put(10, tile_asphalt_dr_out);
		tiles.put(11, tile_asphalt_l);
		tiles.put(12, tile_asphalt_r);
		tiles.put(13, tile_asphalt_u);
		tiles.put(14, tile_asphalt_ul_in);
		tiles.put(15, tile_asphalt_ul_out);
		tiles.put(16, tile_asphalt_ur_in);
		tiles.put(17, tile_asphalt_ur_out);
		tiles.put(18, tile_asphalt);
		tiles.put(19, tile_sign1);
	}
}

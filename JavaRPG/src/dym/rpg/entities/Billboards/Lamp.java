package dym.rpg.entities.Billboards;

import dym.rpg.Game;
import dym.rpg.entities.Billboard;
import dym.rpg.physics.Vector2;

public class Lamp extends Billboard {
	public Lamp(int x, int y) {
		super(Game.lamp, new Vector2(x, y));
		off_y=32;
	}
}

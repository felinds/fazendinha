package br.dipierro.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Tile {

	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(129, 1, 16, 16);
	public static BufferedImage TILE_FLOOR2 = Game.spritesheet.getSprite(97, 1, 16, 16);
	public static BufferedImage TILE_FLOOR3 = Game.spritesheet.getSprite(113, 1, 16, 16);
	public static BufferedImage TILE_FLOOR_GROUND = Game.spritesheet.getSprite(145, 1, 16, 16);
	public static BufferedImage TILE_WALL = Game.spritesheet.getSprite(161, 1, 16, 16);
	public static BufferedImage TILE_FENCE = Game.spritesheet.getSprite(49, 17, 16, 16);
	public static BufferedImage TILE_FENCELEFTDOWNCORNER = Game.spritesheet.getSprite(32, 17, 16, 16);
	public static BufferedImage TILE_FENCERIGHTDOWNCORNER = Game.spritesheet.getSprite(66, 17, 16, 16);
	public static BufferedImage TILE_FENCELEFTUPCORNER = Game.spritesheet.getSprite(32, 1, 16, 16);
	public static BufferedImage TILE_FENCERIGHTUPCORNER = Game.spritesheet.getSprite(66, 1, 16, 16);
	public static BufferedImage TILE_FENCEUP = Game.spritesheet.getSprite(49, 1, 16, 16);
	
	private BufferedImage sprite;
	private int x, y;
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}
	
}

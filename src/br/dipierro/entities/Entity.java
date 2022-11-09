 package br.dipierro.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import br.dipierro.main.Game;
import br.dipierro.world.Camera;


public class Entity {
	
	private int frames = 0, maxFrames = 20, index = 0;

	public static BufferedImage WELL_EN = Game.spritesheet.getSprite(145, 369, 32, 64);
	public static BufferedImage SPRAY_EN = Game.spritesheet.getSprite(145, 321, 32, 32);
	public static BufferedImage WATERCAN_RIGHT = Game.spritesheet.getSprite(177, 273, 32, 32);
	public static BufferedImage WATERCAN_LEFT = Game.spritesheet.getSprite(145, 273, 32, 32);
	public static BufferedImage HOUSE_EN = Game.spritesheet.getSprite(273, 113, 96, 96);
	public static BufferedImage POISON_EN = Game.spritesheet.getSprite(17, 1, 16, 16);
	public static BufferedImage BEETROOT_EN = Game.spritesheet.getSprite(1, 225, 32, 32);
	public static BufferedImage BELLPEPPER_EN = Game.spritesheet.getSprite(1, 321, 32, 32);
	public static BufferedImage CARROT_EN = Game.spritesheet.getSprite(1, 177, 32, 32);
	public static BufferedImage CAT_EN = Game.spritesheet.getSprite(145, 225, 32, 32);
	public static BufferedImage CHICKEN_EN = Game.spritesheet.getSprite(145, 129, 32, 32);
	public static BufferedImage COW_EN = Game.spritesheet.getSprite(145, 33, 32, 32);
	public static BufferedImage DOG_EN = Game.spritesheet.getSprite(145, 177, 32, 32);
	public static BufferedImage PIG_EN = Game.spritesheet.getSprite(145, 81, 32, 32);
	public static BufferedImage LETTUCE_EN = Game.spritesheet.getSprite(1, 369, 32, 32);
	public static BufferedImage TOMATO_EN = Game.spritesheet.getSprite(1, 273, 32, 32);
	public static BufferedImage FENCE_EN = Game.spritesheet.getSprite(49, 1, 32, 16);
	public static BufferedImage FENCE_WO = Game.spritesheet.getSprite(65, 17, 27, 16);
	public static BufferedImage FENCE_UP = Game.spritesheet.getSprite(49, 17, 16, 16);
	public static BufferedImage FLY_EN = Game.spritesheet.getSprite(321, 33, 32, 32);
	public static BufferedImage GRASSHOPPER_EN = Game.spritesheet.getSprite(433, 33, 32, 32);
	public static BufferedImage FLY_FEEDBACKRIGHT = Game.spritesheet.getSprite(321, 1, 32, 32);
	public static BufferedImage FLY_FEEDBACKLEFT = Game.spritesheet.getSprite(385, 1, 32, 32);
	public static BufferedImage GRASSHOPPER_FEEDBACKRIGHT = Game.spritesheet.getSprite(433, 1, 32, 32);
	public static BufferedImage GRASSHOPPER_FEEDBACKLEFT = Game.spritesheet.getSprite(497, 1, 32, 32);
	public static BufferedImage WATERINGCAN = Game.spritesheet.getSprite(145, 273, 32, 32);
	public static BufferedImage SHOOT_RIGHT = Game.spritesheet.getSprite(177, 321, 32, 32);
	public static BufferedImage SHOOT_LEFT = Game.spritesheet.getSprite(209, 321, 32, 32);
	public static BufferedImage SHOOT_UP = Game.spritesheet.getSprite(273, 321, 32, 32);
	public static BufferedImage SHOOT_DOWN = Game.spritesheet.getSprite(241, 321, 32, 32);
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	private BufferedImage[] sprites;
	private int spriteIndex;
	
	private BufferedImage sprite;
	
	public Entity(int x, int y, int width, int height, BufferedImage[] sprites, int frames) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprites = sprites;
		this.spriteIndex = 0;
		this.maxFrames = frames;
	}
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprites = new BufferedImage[] {sprite};
		this.spriteIndex = 0;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void tick() {

		frames++;
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index >= this.sprites.length)
				index = 0;
		}
}

public void render(Graphics g) {
	
	g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

}
	
}
package br.dipierro.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import br.dipierro.main.Game;
import br.dipierro.world.Camera;
import br.dipierro.world.World;

public class Farmer extends Entity {
	
	public boolean right, up, left, down;
	public int right_dir = 0, left_dir = 1, up_dir = 2, down_dir = 3;
	public int dir = down_dir;
	public double speed = 1.4;
	
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 3;
	private boolean moved = false;
	private BufferedImage[] rightFarmer;
	private BufferedImage[] leftFarmer;
	private BufferedImage[] upFarmer;
	private BufferedImage[] downFarmer;

	public Farmer(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightFarmer = new BufferedImage[4];
		leftFarmer = new BufferedImage[4];
		upFarmer = new BufferedImage[4];
		downFarmer = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
		rightFarmer[i] = Game.spritesheet.getSprite(1 + (i*32), 97, 32, 32);
		}
		for(int i = 0; i < 4; i++) {
		leftFarmer[i] = Game.spritesheet.getSprite(1 + (i*32), 129, 32, 32);
		}
		for(int i = 0; i < 4; i++) {
		upFarmer[i] = Game.spritesheet.getSprite(1 + (i*32), 65, 32, 32);
		}
		for(int i = 0; i < 4; i++) {
		downFarmer[i] = Game.spritesheet.getSprite(1 + (i*32), 33, 32, 32);
		}
	}
	
	public void tick() {
		moved = false;
		if(right && World.isFree((int)(x+speed), this.getY())) {
			moved = true;
			dir = right_dir;
			x+= speed;
		}else if(left && World.isFree((int)(x-speed), this.getY())) {
			moved = true;
			dir = left_dir;
			x-= speed;
		}
		if(up &&  World.isFree(this.getX(), (int)(y-speed))) {
			moved = true;
			dir = up_dir;
			y-= speed;
		}
		else if(down &&  World.isFree(this.getX(), (int)(y+speed))) {
			moved = true;
			dir = down_dir;
			y+= speed;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex)
					index = 0;
			}
		}
	
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2), 0, World.WIDTH*16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2), 0, World.HEIGHT*16 - Game.HEIGHT);
	}
	
	public void render(Graphics g) {
		if(dir == right_dir) {
		g.drawImage(rightFarmer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}else if(dir == left_dir) {
		g.drawImage(leftFarmer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}else if(dir == up_dir) {
		g.drawImage(upFarmer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}else if(dir == down_dir) {
		g.drawImage(downFarmer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
	
	}
}

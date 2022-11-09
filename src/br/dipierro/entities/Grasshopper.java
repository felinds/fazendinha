package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;
import br.dipierro.world.World;

public class Grasshopper extends Entity {
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(433+(tileSize*0), 33, tileSize, tileSize),
			Game.spritesheet.getSprite(433+(tileSize*1), 33, tileSize, tileSize)
	};

	private double speed = 0.1;
	
	public Grasshopper(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20);
	}

	public void tick() {
		//NO LUGAR DE FARMER PRECISA COLOCAR OS VEGETAIS!
		if((int)x < Game.farmer.getX() && World.isFree((int)(x+speed), this.getY())) {
			x+=speed; 
		}
		else if((int)x > Game.farmer.getX() && World.isFree((int)(x-speed), this.getY())) {
			x-=speed;
		}
		//Se colocar outro 'if' ao inves de 'else if' ele anda em diagonal
		if((int)y < Game.farmer.getY() && World.isFree(this.getX(),(int)(y+speed))) {
			y+=speed; 
		}
		else if((int)y > Game.farmer.getY() && World.isFree(this.getX(),(int)(y-speed))) {
			y-=speed;
		}
		super.tick();
	}
}

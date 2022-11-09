package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Lettuce extends Entity{
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(1+(tileSize*0), 369, tileSize, tileSize),
			Game.spritesheet.getSprite(1+(tileSize*1), 369, tileSize, tileSize)
	};

	public Lettuce(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20); 
	}

}

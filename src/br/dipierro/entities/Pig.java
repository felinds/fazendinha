package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Pig extends Entity{
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(145+(tileSize*0), 81, tileSize, tileSize),
			Game.spritesheet.getSprite(145+(tileSize*1), 81, tileSize, tileSize)
	};

	public Pig(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20);
	}

}

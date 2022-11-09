package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Tomato extends Entity{
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(1+(tileSize*0), 273, tileSize, tileSize),
			Game.spritesheet.getSprite(1+(tileSize*1), 273, tileSize, tileSize)
	};

	public Tomato(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20);
	}

}

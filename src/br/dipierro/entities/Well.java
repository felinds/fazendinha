package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Well extends Entity{
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(145+(tileSize*0), 369, 32, 64),
			Game.spritesheet.getSprite(146+(tileSize*1), 369, 32, 64)
	};

	public Well(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20);
	}

}

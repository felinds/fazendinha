package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class House extends Entity{

	private static int tileSize = 96;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(273+(tileSize*0), 113, tileSize, tileSize),
			Game.spritesheet.getSprite(273+(tileSize*1), 113, tileSize, tileSize),
			Game.spritesheet.getSprite(273+(tileSize*2), 113, tileSize, tileSize),
			Game.spritesheet.getSprite(273+(tileSize*3), 113, tileSize, tileSize),
			Game.spritesheet.getSprite(273+(tileSize*4), 113, tileSize, tileSize)
	};
	
	public House(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,40);
	}

}

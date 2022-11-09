package br.dipierro.entities;

import java.awt.image.BufferedImage;

import br.dipierro.main.Game;

public class Cow extends Entity{
	
	private static int tileSize = 32;
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(145, 33, 32, 32),
			Game.spritesheet.getSprite(145+tileSize, 33, 32, 32)
	};


	public Cow(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprites,20);
	}

}

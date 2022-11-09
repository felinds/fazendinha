package br.dipierro.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import br.dipierro.main.Game;
import br.dipierro.world.Camera;
import br.dipierro.world.World;

public class Beetroot extends Entity{
	
	private static int tileSize = 32;
	
	private static BufferedImage[] sprites = {
			Game.spritesheet.getSprite(1, 225, 32, 32),
			Game.spritesheet.getSprite(1+tileSize, 225, 32, 32)
		
	};

	public Beetroot(int x, int y, int width, int height) {
		super(x, y, width, height, sprites, 20);
		
	}
	
	
}

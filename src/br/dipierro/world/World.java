package br.dipierro.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.dipierro.entities.Beetroot;
import br.dipierro.entities.BellPepper;
import br.dipierro.entities.Carrot;
import br.dipierro.entities.Cat;
import br.dipierro.entities.Chicken;
import br.dipierro.entities.Cow;
import br.dipierro.entities.Dog;
import br.dipierro.entities.Entity;
import br.dipierro.entities.Fly;
import br.dipierro.entities.Grasshopper;
import br.dipierro.entities.House;
import br.dipierro.entities.Lettuce;
import br.dipierro.entities.Pig;
import br.dipierro.entities.Poison;
import br.dipierro.entities.Spray;
import br.dipierro.entities.Tomato;
import br.dipierro.entities.WateringCan;
import br.dipierro.entities.Well;
import br.dipierro.main.Game;

public class World {

	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	//TILE_SIZE � uma variavel para dar o tamanho do TILE que vai colidir. Ser� que � 16 mesmo?
	public static final int TILE_SIZE = 16;
	
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			//ESSE CALCULO SERVE PARA SABER QUANTOS PIXELS TEM NA IMAGEM
			int[] pixels = new int[map.getWidth()* map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight(); //CONSTANTES 
			//A FORMULA DENTRO DO [] � PARA CONTROLAS AS POSI��ES NO TILE
			tiles = new Tile[map.getWidth()* map.getHeight()];
			//PROXIMO PASSO � PEGAR OS PIXELS E JOGAR DENTRO DO ARRAY
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			for(int xx = 0; xx < map.getWidth(); xx++) {
				//map.getWidth serve para pegar o tamanho do mundo
				//ESTOU PERCORRENDO CADA PIXEL DO MEU MAPA
				for(int yy = 0; yy < map.getHeight(); yy++) {
					//CRIEI O PIXELATUAL PARA FACILITAR A VIDA
					int pixelAtual = pixels[xx + (yy*map.getWidth())];
					//SEMPRE VAI SER FLOOR (PQ?)
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR);
					if(pixelAtual == 0xFF000000) {
						//Floor
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR);
					}else if(pixelAtual == 0xFFFFFFFF) {
						//Wall
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_WALL);

					}else if(pixelAtual == 0xFF404040) {
						//Floor2
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR2);

					}else if(pixelAtual == 0xFF808080) {
						//Floor 3
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR3);

					}else if(pixelAtual == 0xFF7F3300) {
						//FloorGround
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR_GROUND);

					}else if(pixelAtual == 0xFF7F593F) {
						//Fence
						//S� o Fence no TILE que deu o problema, pq? Devo fazer outro 16x16 para completa-lo?
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCE);
					}else if(pixelAtual == 0xFF7F743F) {
						//FenceUp
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCEUP);
						
					}
					else if(pixelAtual == 0xFF4F3F3F) {
						//FENCELEFTDOWNCORNER
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCELEFTDOWNCORNER);
					}
					else if(pixelAtual == 0xFF5F3F3F) {
						//FENCERIGHTUPCORNER
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCERIGHTUPCORNER);

					}else if(pixelAtual == 0xFF6F3F3F) {
						//FENCERIGHTDOWNCORNER
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCERIGHTDOWNCORNER);
					}else if(pixelAtual == 0xFF7F3F3F) {
						//FENCELEFTUPCORNER
						tiles[xx + (yy * WIDTH)] = new WallTile(xx*16, yy*16, Tile.TILE_FENCELEFTUPCORNER);
					}
					
					
					else if(pixelAtual == 0xFFFF7FB6) {
						//Farmer
						Game.farmer.setX(xx*32);
						Game.farmer.setY(yy*32);
					}else if(pixelAtual == 0xFFA17FFF) {
						//Fly
						//16 e 16 � a posi��o que esta atualmente?
						Game.entities.add(new Fly(xx*16, yy*16, 32, 32, Entity.FLY_EN));
					}else if(pixelAtual == 0xFFD67FFF) {
						//Grasshopper
						Game.entities.add(new Grasshopper(xx*16, yy*16, 32, 32, Entity.GRASSHOPPER_EN));
					}else if(pixelAtual == 0xFF4800FF) {
						//Spray 
						Game.entities.add(new Spray(xx*16, yy*16, 32, 32, Entity.SPRAY_EN));
					}else if(pixelAtual == 0xFF21007F) {
						//Poison
						Game.entities.add(new Poison(xx*16, yy*16, 32, 32, Entity.POISON_EN));
					}else if(pixelAtual == 0xFF0026FF) {
						//Well
						Game.entities.add(new Well(xx*16, yy*16, 32, 64, Entity.WELL_EN));
					}else if(pixelAtual == 0xFF0094FF) {
						//Watering can
						Game.entities.add(new WateringCan(xx*16, yy*16, 32, 32, Entity.WATERCAN_LEFT));
					}else if(pixelAtual == 0xFFFF6A00) {
						//Carrot
						Game.entities.add(new Carrot(xx*16, yy*16, 32, 32, Entity.CARROT_EN));
					}else if(pixelAtual == 0xFFFF006E) {
						//Beetroot
						Game.entities.add(new Beetroot(xx*16, yy*16, 32, 32));
					}else if(pixelAtual == 0xFFFF0000) {
						//Tomato
						Game.entities.add(new Tomato(xx*16, yy*16, 32, 32, Entity.TOMATO_EN));
					}else if(pixelAtual == 0xFF7F0000) {
						//Bell Pepper
						Game.entities.add(new BellPepper(xx*16, yy*16, 32, 32, Entity.BELLPEPPER_EN));
					}else if(pixelAtual == 0xFF4CFF00) {
						//Lettuce
						Game.entities.add(new Lettuce(xx*16, yy*16, 32, 32, Entity.LETTUCE_EN));
					}else if(pixelAtual == 0xFFFFB27F) {
						//Cow
						Game.entities.add(new Cow(xx*16, yy*16, 32, 32, Entity.COW_EN));
					}else if(pixelAtual == 0xFFFF7F7F) {
						//Pig
						Game.entities.add(new Pig(xx*16, yy*16, 32, 32, Entity.PIG_EN));
					}else if(pixelAtual == 0xFFFFD800) {
						//Chicken
						Game.entities.add(new Chicken(xx*16, yy*16, 32, 32, Entity.CHICKEN_EN));
					}else if(pixelAtual == 0xFF7F6A00) {
						//Dog
						Game.entities.add(new Dog(xx*16, yy*16, 32, 32, Entity.DOG_EN));
					}else if(pixelAtual == 0xFFB6FF00) {
						//Cat
						Game.entities.add(new Cat(xx*16, yy*16, 32, 32, Entity.CAT_EN));
					}else if(pixelAtual == 0xFF7F0037)
						//House
						Game.entities.add(new House(xx*16, yy*16, 96, 96, Entity.HOUSE_EN));
					}
				
				
				
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isFree(int xnext, int ynext) {
		//ESSE CALCULO PODE FERRAR COM TUDO, FIQUE ESPERTO
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
		
	}
	
	public void render(Graphics g) {
		//Ser� que � 16 mesmo????
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
}

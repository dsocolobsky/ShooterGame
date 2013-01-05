package com.dysoco.redshooter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	// Array of blocks in world
	Array<Block> blocks = new Array<Block>();
	// The player
	Player player;
	
	// Accessors and Mutators
	public Array<Block> getBlocks() {
		return blocks;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	// Constructor
	public World() {
		createWorld();
	}
	
	private void createWorld() {
		player = new Player(new Vector2(1, 1));
		
		for(int i = 0; i < 10; i++) {
			blocks.add(new Block(new Vector2(i, 0))); // Floor
			blocks.add(new Block(new Vector2(i, 7))); // Ceiling
			
		}
		blocks.add(new Block(new Vector2(4, 1))); // Obstacle
		
		// Floating thing
		blocks.add(new Block(new Vector2(2, 4)));
		blocks.add(new Block(new Vector2(2, 5)));
	}
}

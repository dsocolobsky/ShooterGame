package com.dysoco.redshooter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {
	static final float SIZE = 1f;
	
	Vector2 position;
	Rectangle bounds;
	
	public Block(Vector2 pos) {
		position = new Vector2();
		bounds = new Rectangle();
		
		position = pos;
		bounds.height = SIZE; // 1f
		bounds.width = SIZE;
	}
	
	// Accessors and Mutators
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
}

package com.dysoco.redshooter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	public enum State {
		IDLE, WALKING, JUMPING, DEAD
	}
	
	static final float SPEED = 2f; // Units per second
	static final float JUMP_SPEED = 1f;
	static final float SIZE = 0.5f; // Half a unit
	
	Vector2 position;
	Vector2 acceleration;
	Vector2 speed;
	Rectangle bounds;
	State state;
	boolean facingRight;
	
	public Player(Vector2 pos) {
		position = new Vector2();
		acceleration = new Vector2();
		speed = new Vector2();
		bounds = new Rectangle();
		state = State.IDLE;
		facingRight = true;
		
		position = pos;
		bounds.height = SIZE; // 0.5f
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

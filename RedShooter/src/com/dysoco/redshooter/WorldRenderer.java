package com.dysoco.redshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	
	public static final float CAMERA_WIDTH = 10f;
	public static final float CAMERA_HEIGHT = 7f;
	
	private Player player;
	private World world;
	private OrthographicCamera camera;
	
	// Debug rendering
	ShapeRenderer debugRenderer = new ShapeRenderer();
	
	// Textures
	private Texture playerTexture; // Player texture
	private Texture blockTexture; // Block texture
	
	private SpriteBatch sBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX; // Pixels Per Unit in X axis
	private float ppuY; // Pixels Per Unit in Y axis
	
	public void setSize(int wd, int ht) {
		this.width = wd;
		this.height = ht;
		
		ppuX = (float) width / CAMERA_WIDTH;
		ppuY = (float) height / CAMERA_HEIGHT;
	}
	
	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.camera.update();
		
		this.debug = debug;
		sBatch = new SpriteBatch();
		
	}
	
	public void loadTextures() {
		playerTexture = new Texture(Gdx.files.internal("images/player_1.png"));
		blockTexture = new Texture(Gdx.files.internal("images/block.png"));
	}
	
	public void render() {
		sBatch.begin();
			//drawBlocks();
			//drawPlayer();
			if(debug)
				drawDebug();
		sBatch.end();
	}
	
	private void drawBlocks() {
		for(Block block : world.getBlocks()) {
			sBatch.draw(blockTexture, block.getPosition().x * ppuX,
					block.getPosition().x * ppuY, Block.SIZE * ppuX
					, Block.SIZE * ppuY);
			
		}
	}
	
	private void drawPlayer() {
		player = world.getPlayer();
		
		sBatch.draw(playerTexture, player.getPosition().x * ppuX,
				player.getPosition().x * ppuY, Player.SIZE * ppuX
				, Player.SIZE * ppuY);
	}
	
	public void drawDebug() {
		// Set cameras
		debugRenderer.setProjectionMatrix(camera.combined);
		debugRenderer.begin(ShapeType.Rectangle);
		
		// For each block in world, render it
		for(Block block : world.getBlocks()) {
			Rectangle rect = block.getBounds();
			float x1 = block.getPosition().x + rect.x;
			float y1 = block.getPosition().y + rect.y;
			
			debugRenderer.setColor(new Color(0, 1, 0, 1));
			debugRenderer.rect(x1, y1, rect.width, rect.height);
		}
		
		// Render the player
		player = world.getPlayer();
		Rectangle rect = player.getBounds();
		float x1 = player.getPosition().x + rect.x;
		float y1 = player.getPosition().y + rect.y;
		
		debugRenderer.setColor(new Color(1, 0, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
}

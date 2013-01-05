package com.dysoco.redshooter;

import com.badlogic.gdx.Game;
import com.dysoco.redshooter.GameScreen;	

public class Shooter extends Game {
	
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
	
}

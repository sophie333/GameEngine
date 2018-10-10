package ue01;

import at.fhooe.mtd.sgl.app.Game;

public class HelloWorld extends Game{

	@Override
	public void create() {
		switchState(new MainGameState(this));
	}
	
}

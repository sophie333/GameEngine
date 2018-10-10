package ue01;

import java.awt.Color;
import java.awt.Graphics2D;

import at.fhooe.mtd.sgl.Sgl;
import at.fhooe.mtd.sgl.app.Game;
import at.fhooe.mtd.sgl.app.GameState;
import at.fhooe.mtd.sgl.graphics.Alignment;
import at.fhooe.mtd.sgl.graphics.TextRenderer;

public class TestState2 extends GameState {

	private static final double DISPLAY_TIME = 2.0;
	private double displayTime;
	private TextRenderer txRender = new TextRenderer();
	
	public TestState2(Game context) {
		super(context);
	}

	public void enter() {
		Sgl.graphics.setClearColor(Color.BLUE);
		displayTime = DISPLAY_TIME;
		txRender.setAlignment(Alignment.CENTER);
		txRender.setColor(Color.WHITE);
	}

	public void update(double dt) {
		displayTime -= dt;
		
		if(displayTime <= 0){
			getContext().switchState(new TestState(getContext()));
		}
		
		Graphics2D g = Sgl.graphics.beginUpdate();
		txRender.reset();
		txRender.render(g, "State Two");
		txRender.render(g, String.format("%.2f seconds", displayTime));
		Sgl.graphics.endUpdate();
	}

	@Override
	public void resize(int width, int height) {
		txRender.setPos(width * 0.5, height * 0.5);
	}

}

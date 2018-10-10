package ue01;

import java.awt.Color;
import java.awt.Graphics2D;

import at.fhooe.mtd.sgl.Sgl;
import at.fhooe.mtd.sgl.app.Game;
import at.fhooe.mtd.sgl.app.GameState;
import at.fhooe.mtd.sgl.graphics.Alignment;
import at.fhooe.mtd.sgl.graphics.TextRenderer;
import at.fhooe.mtd.sgl.input.InputListener;

public class TestState extends GameState implements InputListener{

	private static final double DISPLAY_TIME = 20.0;
	private double displayTime;
	private TextRenderer txRender = new TextRenderer();
	private String inputText = "";
	
	public TestState(Game context) {
		super(context);
	}

	public void enter() {
		Sgl.input.addInputListener(this);
		Sgl.graphics.setClearColor(Color.RED);
		displayTime = DISPLAY_TIME;
		txRender.setAlignment(Alignment.CENTER);
		txRender.setColor(Color.WHITE);
	}
	
	public void exit() {
		Sgl.input.removeInputListener(this);
	}

	public void update(double dt) {
		displayTime -= dt;
		
		if(displayTime <= 0){
			getContext().switchState(new TestState2(getContext()));
		}
		
		Graphics2D g = Sgl.graphics.beginUpdate();
		txRender.reset();
		txRender.render(g, "State One");
		txRender.render(g, String.format("%.2f seconds", displayTime));
		txRender.render(g, "Input: " + inputText);
		txRender.render(g, "Mouse: " + Sgl.input.getMouseX() + ", " + Sgl.input.getMouseY());
		Sgl.graphics.endUpdate();
	}

	@Override
	public void resize(int width, int height) {
		txRender.setPos(width * 0.5, height * 0.5);
	}
	
	
	
	/////////////////////////////////////////////////
	///// Interface InputListener
	////////////////////////////////////////////////

	@Override
	public boolean keyDown(int keycode, char arg1) {
		inputText += (char)keycode + " ";
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseDown(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseUp(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(double arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}

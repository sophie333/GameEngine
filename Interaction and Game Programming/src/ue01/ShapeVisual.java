package ue01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class ShapeVisual extends Component implements Visual{
	private Shape shape;
	private Color color = Color.CYAN; //default
	private Pose pose;
	
	public ShapeVisual(Shape shape) {
		this.shape = shape;
	}
	
	public ShapeVisual setShape(Shape shape) { //new ShapeVisual.setColor -> methodChaining
		this.shape = shape;
		return this;
	}
	
	public ShapeVisual setColor(Color color) { //new ShapeVisual.setColor -> methodChaining
		this.color = color;
		return this;
	}
	
	protected void activate() {
		this.pose = getComponent(Pose.class);
		getService(VisualSystem.class).addVisual(this);
	}
	
	protected void deactivate() {
		getService(VisualSystem.class).removeVisual(this);
	}
	
	public void render(Graphics2D g) {
		// Apply transform of entity
		g.translate(pose.getPosX(), pose.getPosY());
		g.rotate(pose.getAngle());
		
		// Render shape
		g.setColor(color);
		g.fill(shape);
	}
}

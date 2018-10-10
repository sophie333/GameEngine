package ue01;

public interface Collider {

	public void setMidpoint(int x, int y);
	
	public double getMidX();
	
	public double getMidY();
	
	public void setRadius(double r);
	
	public double getRadius();
	
	public void collisionBehavior(Collider col);
	
	public StaticPose getPose();
}

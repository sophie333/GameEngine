package ue01;

public interface Pose {
	
	public double getPosX();
	public double getPosY();
	public void setAngle(double a);
	public double getAngle();
	public void addToPosX(double x);
	public void addToPosY(double y);
	public void setPosX(double x);
	public void setPosY(double y);
}

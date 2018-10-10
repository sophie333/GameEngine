package ue01;


public class StaticPose extends Component implements Pose{

	private double x;
	private double y;
	private double a;
	
	public StaticPose(double x, double y, double a){
		this.x = x;
		this.y = y;
		this.a = a;
	}

	public void setPosX(double x) {
		this.x = x;
	}

	public void setPosY(double y) {
		this.y = y;
	}
	
	public void addToPosX(double x) {
		this.x += x;
	}

	public void addToPosY(double y) {
		this.y += y;
	}
	
	public double getPosX() {
		return x;
	}

	public double getPosY() {
		return y;
	}

	public void setAngle(double angle) {
		a = angle;
	}
	
	public double getAngle() {
		return a;
	}
	
	void activate() {
		// TODO Auto-generated method stub
	}

	void deactivate() {
		// TODO Auto-generated method stub
	}
}
package ue01;

public class AsteroidEdgeHandler extends Component implements EdgeHandler{
	private int width = 110;
	private int height = 90;
	double angle, x, y;
	StaticPose pose;
	boolean isSmall = false;
	
	AsteroidEdgeHandler(boolean isSmall) {
		this.isSmall = isSmall;
	}
	
	public void activate() {
		pose = getComponent(StaticPose.class);
		
		if (!isSmall) {
			//position
			int wMax = width/2;
			int wMin = -width/2;
			int hMax = height/2;
			int hMin = -height/2;
			
			x = (Math.random() * ((wMax - wMin) + 1)) + wMin;
			y = (Math.random() * ((hMax - hMin) + 1)) + hMin;
			//angle = (Math.random() * ((100 - 10) + 1)) + 10;
			
			boolean switchIt = true;
			
			if (x > 0 && x < wMax && switchIt) {
				x += wMax - x;
				switchIt = false;
			} 
			else if (x < 0 && x > wMin & switchIt){
				x += wMin - x;
				switchIt = false;
			}
			if (y > 0 && y < hMax && !switchIt) {
				y += hMax - y;
				switchIt = true;
			} 
			else if (y < 0 && y > hMin & !switchIt){
				y += hMin - y;
				switchIt = true;
			}
		}		
		
		pose.setPosX(x);
		pose.setPosY(y);
		pose.setAngle(Math.random() * 360);
		
		getService(EdgeSystem.class).addEdgeHandler(this);
	}
	
	public void update(double dt) {
		if(pose.getPosX() > width/2){
			pose.setPosX(-width/2);
		}
		else if (pose.getPosX() < -(width/2)){
			pose.setPosX(width/2);
		}
		if(pose.getPosY() > height/2){
			pose.setPosY(-height/2);
		} 
		else if (pose.getPosY() < -(height/2)){
			pose.setPosY(height/2);
		}
		
		getComponent(PhysicsBody.class).applyForceForward(10);
	}

	public void deactivate() {
	}
	
	public void setPosXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

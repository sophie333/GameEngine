package ue01;

public class BulletEdgeHandler extends Component implements EdgeHandler{
	private int width = 110;
	private int height = 90;
	
	double speed, x, y;
	double angle;
	StaticPose pose;
	
	public BulletEdgeHandler(double speed, double x, double y, double angle) {
		this.angle = angle;
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	
	public void activate() {
		pose = getComponent(StaticPose.class);
		
		pose.setPosX(x);
		pose.setPosY(y);
		pose.setAngle(angle);
		
		getService(EdgeSystem.class).addEdgeHandler(this);
	}
	
	public void update (double dt) {
	//remove Entity
		/*
		if(pose.getPosX() > width/2){
			getEntity().deactivate();
		}
		else if (pose.getPosX() < -(width/2)){
			getEntity().deactivate();
		}
		if(pose.getPosY() > height/2){
			getEntity().deactivate();
		} 
		else if (pose.getPosY() < -(height/2)){
			getEntity().deactivate();
		}*/
		//pBody.applyForce(directionVec.set(FORWARD).rotate(angle).scale(10));
		getComponent(PhysicsBody.class).applyForceForward(speed);
	}

	public void deactivate() {
		//getService(BulletSystem.class).removeBullet(this);	
	}

}

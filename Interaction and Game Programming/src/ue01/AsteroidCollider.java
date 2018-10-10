package ue01;

import java.awt.Point;

public class AsteroidCollider extends Component implements Collider{

	private double radius;
	private Point midPoint;
	public StaticPose pose;
	
	public void collisionBehavior(Collider col) {
		if(col instanceof BulletCollider) { 
			if(radius == 5) {
				//add small Asteroids			
				new Asteroid(getEntity().getServiceManager(), 2, getComponent(Pose.class).getPosX(), getComponent(Pose.class).getPosY());
				new Asteroid(getEntity().getServiceManager(), 2, getComponent(Pose.class).getPosX(), getComponent(Pose.class).getPosY());
			}
			//destroy Asteroid
			getEntity().getServiceManager().asteroidsCount--;
			getEntity().deactivate();
			//destroy Bullet
			((BulletCollider) col).getEntity().deactivate();
			getEntity().getServiceManager().score++;
			System.out.println("Score: " + getEntity().getServiceManager().score);
		} 
		else if (col instanceof AsteroidCollider) {
		} 
		else if (col instanceof ShipCollider) {
		} 
		else {
			System.out.println("Asteroid collided with Something Else");
		}
	}
	
	public AsteroidCollider(int x, int y, double mradius) {
		midPoint = new Point(x,y);
		radius = mradius;
	}
	
	void activate() {
		getService(CollisionSystem.class).addCollider(this);
		pose = getComponent(StaticPose.class);
	}

	void deactivate() {
		getService(CollisionSystem.class).removeCollider(this);
	}

	public void setMidpoint(int x, int y) {
		midPoint.x = x;
		midPoint.y = y;
	}
	
	public double getMidX() {
		return midPoint.x;
	}
	
	public double getMidY() {
		return midPoint.y;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public StaticPose getPose() {
		return pose;
	}
}

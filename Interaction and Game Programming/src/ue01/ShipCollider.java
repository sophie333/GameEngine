package ue01;

import java.awt.Point;

public class ShipCollider extends Component implements Collider {
	private double radius;
	private Point midPoint;
	public StaticPose pose;
	Collider oldCol = null;

	public void collisionBehavior(Collider col) {;
		if(col instanceof BulletCollider) {
		} 
		else if (col instanceof AsteroidCollider ) {
			if (oldCol != null) {
				if (!(oldCol.equals(col))) {
					getEntity().getServiceManager().life--;
					System.out.println("Lives: " + getEntity().getServiceManager().life);
				}
			} else if(oldCol == null) {
				getEntity().getServiceManager().life--;
				System.out.println("Lives: " + getEntity().getServiceManager().life);
			}
		} 
		else if (col instanceof ShipCollider) {
		} else {
			System.out.println("Ship collided with Something Else");
		}

		oldCol = col;
	}
	
	public ShipCollider(int x, int y, double mradius) {
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

package ue01;

import java.util.ArrayList;
import java.util.List;

import at.fhooe.mtd.sgl.math.Vector2d;

public class PhysicsSystem implements Service{
	Vector2d gravity;
	private List<PhysicsBody> physicsList = new ArrayList<PhysicsBody>();
	
	public PhysicsSystem(){
		this.gravity = new Vector2d();
	}
	public PhysicsSystem(double i, double j) {
		this.gravity = new Vector2d(i, j);
	}
	
	public Vector2d getGravity() {
		return gravity;
	}

	public void setGravity(Vector2d gravity) {
		this.gravity = gravity;
	}
	
	public void addPhysicsBody (PhysicsBody b) {
		physicsList.add(b);
	}
	
	public void removePhysicsBody (PhysicsBody b) {
		physicsList.remove(b);
	}

	@Override
	public void update(double dt) {
		for(PhysicsBody body : physicsList) {
			body.applyForce(new Vector2d(gravity.x * body.getMass(), gravity.y * body.getMass()));
			body.update(dt);
		}
	}

	@Override
	public void startup(ServiceManager s) {
		
	}

	@Override
	public void shutdown() {
		physicsList.clear();
		
	}
}

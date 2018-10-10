package ue01;

import at.fhooe.mtd.sgl.math.Vector2d;

public class PhysicsBody extends Component implements IBody2D{
	Pose pose;
	private Vector2d acceleration, velocity, position;
	private double inverseMass, torque, torqueVelocity, angle, dmp;
	private double MOI = 1.0;

	private static final Vector2d FORWARD = new Vector2d(0, 1);
	private Vector2d tmpVec = new Vector2d();
	
	public PhysicsBody(double mass) {
		inverseMass = (mass == 0) ? 0 : 1 / mass;
		acceleration = new Vector2d();
		velocity = new Vector2d();
		position = new Vector2d();
		dmp = 0.9;
	}
	
	public void update(double dt) {
		position.x = pose.getPosX();
		position.y = pose.getPosY();
		angle = pose.getAngle();
		//adding damping
		acceleration.x -= velocity.x * dmp;
		acceleration.y -= velocity.y * dmp;
		torque -= torqueVelocity * dmp;
		
		//calculating velocity & resulting position
		velocity.mulAdd(acceleration, dt);
		position.mulAdd(velocity, dt);
		
		torqueVelocity += torque * dt ;
		angle += torqueVelocity *dt;
		
		//setting position
		pose.setPosX(position.x);
		pose.setPosY(position.y);
		pose.setAngle(angle);
		
		torque = 0;
		acceleration.x = 0;
		acceleration.y = 0;
	}
	
	public void applyForce(Vector2d force) {
		acceleration.mulAdd(force, inverseMass);	
	}
	
	public void applyForceForward(double value) {
		applyForce(tmpVec.set(FORWARD).rotate(angle).scale(value));
	}

	public void applyTorque(double t) {
		torque += t / MOI;
	}
	
	public double getMass() {
		return inverseMass;
	}
	
	public double getAngle() {
		return angle;
	}

	void activate() {
		this.pose = getComponent(Pose.class);
		getService(PhysicsSystem.class).addPhysicsBody(this);
	}

	void deactivate() {
		getService(PhysicsSystem.class).removePhysicsBody(this);
	}
}

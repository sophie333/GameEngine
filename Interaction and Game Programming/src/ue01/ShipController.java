package ue01;

import java.awt.event.KeyEvent;

import at.fhooe.mtd.sgl.Sgl;
import at.fhooe.mtd.sgl.math.Vector2d;

public class ShipController extends Component {

	private static final Vector2d FORWARD = new Vector2d(0, 1);
	public Vector2d tmpVec = new Vector2d();
	
	double interval = 0.3;
	double time = interval; 
	
	void activate() {
		getService(ShipSystem.class).addShip(this);
	}

	public void update(double dt) {
		if(Sgl.input.isKeyPressed(KeyEvent.VK_UP)) 
		{
			double angle = getComponent(PhysicsBody.class).getAngle();
			getComponent(PhysicsBody.class).applyForce(tmpVec.set(FORWARD).rotate(angle).scale(200));
		} 
		else if (Sgl.input.isKeyPressed(KeyEvent.VK_RIGHT)) 
		{
			getComponent(PhysicsBody.class).applyTorque(-5);
		} 
		else if (Sgl.input.isKeyPressed(KeyEvent.VK_LEFT)) 
		{
			getComponent(PhysicsBody.class).applyTorque(5);
		}
		if (Sgl.input.isKeyPressed(KeyEvent.VK_SPACE) && interval <= time) {
			new Bullet(getEntity());
			//getService(BulletSystem.class).addBullet(new Bullet(100, tmpVec, getEntity()));
			time = 0;
		} 
		else {
			time += dt;
		}
	}
	
	void deactivate() {	
		getService(ShipSystem.class).removeShip(this);	
	}
}

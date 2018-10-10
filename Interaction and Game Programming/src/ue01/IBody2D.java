package ue01;

import at.fhooe.mtd.sgl.math.Vector2d;

public interface IBody2D {

	public void applyForce(Vector2d f);
	public void applyTorque(double t);
}

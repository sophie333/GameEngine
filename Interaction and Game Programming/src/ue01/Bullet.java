package ue01;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Bullet {

	public Bullet(Entity ship) {
		double radius = 0.5;
		double speed = 1000;
		
		ServiceManager sManager = ship.getServiceManager();
		double angle = ship.getComponent(PhysicsBody.class).getAngle();
		double x = ship.getComponent(StaticPose.class).getPosX();
		double y = ship.getComponent(StaticPose.class).getPosY();

		Shape shp = new Ellipse2D.Double(0-radius, 0-radius, radius*2, radius*2); 
		ShapeVisual bulletVisual = new ShapeVisual(shp);
		bulletVisual.setColor(Color.GRAY);
		PhysicsBody pBody = new PhysicsBody(1);
		StaticPose pose = new StaticPose(0, 0, 0);
		BulletCollider col = new BulletCollider(0, 0, radius);
		BulletEdgeHandler bulMove = new BulletEdgeHandler(speed, x, y, angle);
		
		Entity bullet = new Entity();
		bullet.setServiceManager(sManager);
				
		EntityManager eManager = sManager.getService(EntityManager.class);
		eManager.addEntity(bullet);
		bullet.addComponent(pose);
		bullet.addComponent(bulletVisual);
		bullet.addComponent(pBody);
		bullet.addComponent(col);
		bullet.addComponent(bulMove);
	}
}

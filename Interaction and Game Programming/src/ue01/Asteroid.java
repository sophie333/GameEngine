package ue01;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Asteroid {

	AsteroidEdgeHandler edge;

	public Asteroid(ServiceManager sManager, int radius, double x, double y) {
		sManager.asteroidsCount++;
		//components
		Shape shp = new Ellipse2D.Double(0-radius, 0-radius, radius*2, radius*2); 
		ShapeVisual rockVisual = new ShapeVisual(shp);
		rockVisual.setColor(Color.ORANGE);
		PhysicsBody pBody = new PhysicsBody(1);
		StaticPose pose = new StaticPose(0, 0, 0);
		AsteroidCollider col = new AsteroidCollider(0, 0, radius);
		if(radius == 2) {
			edge = new AsteroidEdgeHandler(true);
			edge.setPosXY(x, y);
		} 
		else {
			edge = new AsteroidEdgeHandler(false);
		}
		
		Entity asteroid = new Entity();
		asteroid.setServiceManager(sManager);
		
		EntityManager eManager = sManager.getService(EntityManager.class);
		eManager.addEntity(asteroid);
		asteroid.addComponent(pose);
		asteroid.addComponent(rockVisual);
		asteroid.addComponent(pBody);
		asteroid.addComponent(col);
		asteroid.addComponent(edge);
	}
}

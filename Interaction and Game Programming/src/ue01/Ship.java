package ue01;

import java.awt.Color;
import java.awt.geom.GeneralPath;

public class Ship {
	
	public Ship(ServiceManager sManager) {
		ShapeVisual shipVisual = new ShapeVisual(getShape());
		StaticPose shipPosition = new StaticPose(0,0,0);
		ShipController playerController = new ShipController();
		PhysicsBody pBody = new PhysicsBody(10);
		ShipCollider shipCol = new ShipCollider(0,0,2);
		ShipEdgeHandler shipEdge = new ShipEdgeHandler();
		
		//SPACESHIP
		Entity ship = new Entity();
		ship.setServiceManager(sManager);
		
		EntityManager eManager = sManager.getService(EntityManager.class);
		eManager.addEntity(ship);
		ship.addComponent(shipPosition);
		ship.addComponent(shipVisual);	shipVisual.setColor(Color.GRAY);
		ship.addComponent(playerController);
		ship.addComponent(pBody);		
		ship.addComponent(shipCol);
		ship.addComponent(shipEdge);		
	}
	
	public static GeneralPath getShape() {
		int[] shpX = {0,2,0,-2};
		int[] shpY = {2,-2,-1,-2};
		GeneralPath shp = new GeneralPath();
		shp.moveTo(shpX[0], shpY[0]);
		
		 for (int i = 0; i < shpX.length; i++) 
			 shp.lineTo(shpX[i], shpY[i]);
			 
		 shp.closePath();
		return shp;
	}
}

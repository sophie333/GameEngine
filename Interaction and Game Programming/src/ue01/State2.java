package ue01;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import at.fhooe.mtd.sgl.app.GameState;
import at.fhooe.mtd.sgl.math.Vector2d;

public class State2 extends GameState<HelloWorld>{

	ServiceManager srvManager;
	
	public State2(HelloWorld context) {
		super(context);
	}
	
	//viewwidth = z.B. 100 ; Höhe ergibt sich aus Bildschirmverhältnis
	//s = screenwidth/viewwidth
	
	public void enter() {
		srvManager = new ServiceManager();
		GraphicsSystem graphicsSys = new GraphicsSystem();
		StaticPose sPose = new StaticPose(500, 400, 0);
		PhysicsSystem physicsSys = new PhysicsSystem(6, 1);
		VisualSystem visualSys = new VisualSystem(1);
		EntityManager eManager = new EntityManager();
		
		SomeGraphicsLayer sLayer = new SomeGraphicsLayer(2, 30, 50, 40, 80);
		
		Entity entity = new Entity();
		ShapeVisual sVisual = new ShapeVisual(new Rectangle2D.Float(-25, -25, 50, 50));
		PhysicsBody pBody = new PhysicsBody(1);
		
		entity.setServiceManager(srvManager);
		
		srvManager.addService(graphicsSys);
		srvManager.addService(physicsSys);
		srvManager.addService(visualSys);
		srvManager.addService(eManager);
		srvManager.addService(sLayer);

		eManager.addEntity(entity);
		entity.addComponent(sPose);
		entity.addComponent(sVisual);
		entity.addComponent(pBody);

		physicsSys.addPhysicsBody(pBody);
		//pBody.applyForce(new Vector2d(0, 0));
		
		srvManager.startupAll(srvManager);	
	}
	
	@Override
	public void resize(int width, int height) {
		double s = width/ 100;
		AffineTransform tx = new AffineTransform();
		tx.setToIdentity();
		tx.translate(width * 0.5f,  height * 0.5f);
		tx.scale(s, -s);
		
		srvManager.getService(VisualSystem.class).setTransform(tx);
	}

	public void exit() {
		super.exit();
	}

	public void update(double dt) {
		srvManager.updateAll(dt);
	}
}

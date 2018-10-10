package ue01;

import java.awt.geom.AffineTransform;
import at.fhooe.mtd.sgl.app.GameState;

public class Level2 extends GameState<HelloWorld>{ //wenn was passiert switchstate
	ServiceManager sManager = new ServiceManager();
	private static int asteroidsNr = 5;

	public Level2(HelloWorld context, int score, int life) {
		super(context);
		sManager.score = score;
		sManager.life = life;
	}
	
	public void enter() {
		
		EntityManager entityManager = new EntityManager();
		GraphicsSystem gSystem = new GraphicsSystem();
		VisualSystem playground = new VisualSystem(2);
		PhysicsSystem physicsSys = new PhysicsSystem(0, 0); //gravity6,1
		CollisionSystem colSystem = new CollisionSystem();
		ShipSystem shipSys = new ShipSystem();
		EdgeSystem edgeSys = new EdgeSystem();
		
		sManager.addService(gSystem);
		sManager.addService(entityManager);
		sManager.addService(playground);
		sManager.addService(colSystem);
		sManager.addService(physicsSys);
		sManager.addService(shipSys);
		sManager.addService(edgeSys);

		new Ship(sManager);
		
		for(int i = 0; i < asteroidsNr; i++) {
			new Asteroid(sManager, 5, 0, 0);
		}
		
		sManager.startupAll(sManager);
	}
	
	@Override
	public void resize(int width, int height) {
		double s = width/ 100.0;
		AffineTransform tx = new AffineTransform();
		tx.setToIdentity();
		tx.translate(width * 0.5f,  height * 0.5f);
		tx.scale(s, -s);
		
		sManager.getService(VisualSystem.class).setTransform(tx);
	}

	public void exit() {
		super.exit();
	}

	public void update(double dt) {
		if(sManager.life <= 0) {
			getContext().switchState(new MainGameState(getContext()));
		}
		if(sManager.asteroidsCount == 0) {
			getContext().switchState(new Level3(getContext(), sManager.score, sManager.life));
		}
		sManager.updateAll(dt);
	}
}
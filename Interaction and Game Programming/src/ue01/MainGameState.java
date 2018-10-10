package ue01;

import java.awt.geom.AffineTransform;

import at.fhooe.mtd.sgl.app.GameState;

public class MainGameState extends GameState<HelloWorld>{ //wenn was passiert switchstate
	ServiceManager sManager = new ServiceManager();
	//private TextRenderer txRender = new TextRenderer();
	private static int asteroidsNr = 3;

	public MainGameState(HelloWorld context) {
		super(context);
	}
	
	public void enter() {
		/*Sgl.graphics.setClearColor(Color.BLACK);
		txRender.setAlignment(Alignment.TOP_LEFT);
		txRender.setColor(Color.WHITE);*/
		
		EntityManager entityManager = new EntityManager();
		GraphicsSystem gSystem = new GraphicsSystem();
		VisualSystem playground = new VisualSystem(2);
		PhysicsSystem physicsSys = new PhysicsSystem(0, 0); //gravity6,1
		CollisionSystem colSystem = new CollisionSystem();
		ShipSystem shipSys = new ShipSystem();
		EdgeSystem edgeSys = new EdgeSystem();
		
		TextLayer txtLayer = new TextLayer();
		Entity txt = new Entity();
		txt.setServiceManager(sManager);
		txt.addComponent(txtLayer);
		entityManager.addEntity(txt);
		
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
		//txRender.setPos(width * 0.5, height * 0.5);
	}

	public void exit() {
		super.exit();
	}

	public void update(double dt) {
		if(sManager.life <= 0) {
			getContext().switchState(new MainGameState(getContext()));
		}
		if(sManager.asteroidsCount == 0) {
			getContext().switchState(new Level2(getContext(), sManager.score, sManager.life));
		}
		sManager.updateAll(dt);
		/*Graphics2D g = Sgl.graphics.beginUpdate();
		txRender.reset();
		txRender.render(g, "Lives: " + asteroidsNr);
		Sgl.graphics.endUpdate();*/
	}
}
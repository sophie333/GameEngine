package ue01;

import java.util.List;
import java.util.ArrayList;

public class EntityManager implements Service {
	
	//private List<Command> commandList = new ArrayList<Command>();
	private List<Entity> entityList = new ArrayList<Entity>();

	public void addEntity(Entity e) {
		entityList.add(e);
		e.activate();
	}
	
	public void removeEntity(Entity e) {
		entityList.remove(e);
		e.deactivate();
	}
	
	public void removeAll() {
		entityList.removeAll(entityList);
	}
	
	public void update(double real) {
		
	}

	public void startup(ServiceManager s) {
		
	}

	public void shutdown() {

	}
}

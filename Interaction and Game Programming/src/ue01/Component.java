package ue01;

import java.util.NoSuchElementException;

public abstract class Component {
	
	private Entity entity;
	
	public Entity getEntity() {
		return entity;
	}
	
	protected final <T> T getService(Class<T> type) throws IllegalArgumentException {
		return getEntity().getServiceManager().getService(type);
	}
	
	protected final <T> T getComponent(Class<T> type) throws NoSuchElementException {
		return entity.getComponent(type);
	}
	
	protected void setEntity(Entity e) {
		entity = e;
	}
	abstract void activate();
	abstract void deactivate();
}

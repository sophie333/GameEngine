package ue01;

import java.util.List;
import java.util.ArrayList;

public final class Entity {
	
	private List<Component> compList = new ArrayList<Component>();
	private ServiceManager sManager;
	private boolean isActive;
	
	public void addComponent(Component c) {
		if(!this.hasComponent(c.getClass())) {
			compList.add(c);
			c.setEntity(this);
			c.activate();
		}
	}
	
	public <T> T getComponent(Class<T> type) {
		for(Component comp : compList) {
			if(type.isInstance(comp)) {
				return type.cast(comp);
			}
		}
		throw new IllegalArgumentException("Component doesn't exist in this Entity");
	}
	
	public <T> T findComponent(Class<T> type) {
		for(Component comp : compList) {
			if(type.isInstance(comp)) {
				return type.cast(comp);
			}
		}
		return null;
	}
	
	public <T> boolean hasComponent(Class<T> type) {
		for(Component comp : compList) {
			if(type.isInstance(comp)) {
				return true;
			}
		}
		return false;
	}
	
	protected void activate() { //bringt nichts, weil zu dem zeitpunkt noch keine components geadded sind?
		for(Component comp : compList) {
			comp.activate();
		}
		isActive = true;
	}
	
	public void deactivate() {
		for(Component comp : compList) {
			comp.deactivate();
		}
		isActive = false;
	}
	
	public ServiceManager getServiceManager() {
		return sManager;
	}
	
	protected void setServiceManager(ServiceManager msmanager) {
		sManager = msmanager;
	}
	
	public boolean getActive() {
		return isActive;
	}
}

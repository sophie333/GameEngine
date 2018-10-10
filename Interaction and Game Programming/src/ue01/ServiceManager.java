package ue01;
import java.util.*;


public class ServiceManager {
	
	List<Service> serviceList = new ArrayList<Service>();
	public int asteroidsCount = 0;
	public int life = 3;
	public int score = 0;

	public void addService(Service s) {
		serviceList.add(s);
	}
	
	public <T> T getService(Class<T> type) {
		
		for (Service service : serviceList) {
			if(type.isInstance(service)) {
				return type.cast(service);
			}
		}
		return null;
	}
	
	public GraphicsSystem getGS() {
		for (Service service : serviceList) {
			if(GraphicsSystem.class.isInstance(service)) {
				return GraphicsSystem.class.cast(service);
			}
		}
		return null;
	}
	
	public VisualSystem getVS() {
		for (Service service : serviceList) {
			if(VisualSystem.class.isInstance(service)) {
				return VisualSystem.class.cast(service);
			}
		}
		return null;
	}
	
	public void updateAll(double Real) {
		for (Service service : serviceList) {
			service.update(Real);
		}
	}
	
	public void startupAll(ServiceManager s){
		for (Service service : serviceList) {
			service.startup(s);
		}
	}
	
	public void shutdownAll(){
		//iterate in reversed order
	}
	
}
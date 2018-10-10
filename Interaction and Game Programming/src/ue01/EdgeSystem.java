package ue01;

import java.util.ArrayList;
import java.util.List;

public class EdgeSystem implements Service{
	public List<EdgeHandler> edgeList = new ArrayList<EdgeHandler>();
	List<EdgeHandler> tobeAdded = new ArrayList<EdgeHandler>(); 
	
	public void addEdgeHandler(EdgeHandler a) {
		tobeAdded.add(a);
	}
	
	public void removeEdgeHandler(EdgeHandler a) {
		edgeList.remove(a);
	}
	
	public void update(double dt) {
		for(EdgeHandler a : edgeList) {
			a.update(dt);
		}
		edgeList.addAll(tobeAdded);
		tobeAdded.clear();
	}

	public void startup(ServiceManager s) {
		for(EdgeHandler a : edgeList) {
			a.activate();
		}
		edgeList.addAll(tobeAdded);
		tobeAdded.clear();
	}

	public void shutdown() {
		for(EdgeHandler a : edgeList) {
			a.deactivate();
		}
		edgeList.clear();
	}
}

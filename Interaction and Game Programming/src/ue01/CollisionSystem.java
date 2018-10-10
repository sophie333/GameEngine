package ue01;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem implements Service{

	List<Collider> colList = new ArrayList<Collider>();
	StaticPose pose;
	Collider col1;
	Collider col2;
	
	public void addCollider(Collider col) {
		colList.add(col);
	}
	
	public void removeCollider(Collider col) {
		colList.remove(col);
	}
	
	public void update(double real) {
		/*if(collisionDetection()) {
			System.out.println("collisiondetection");
			col1.collisionBehavior(col2);
		}		*/
		collisionDetection();
	}

	public void startup(ServiceManager s) {
		
	}

	public void shutdown() {
		colList.clear();
	}
	
	public void collisionDetection(){
		for(int i = 0; i < colList.size(); i++) {
			double firstRad = colList.get(i).getRadius();
			double x1 = colList.get(i).getPose().getPosX();
			double y1 = colList.get(i).getPose().getPosY();
			col1 = colList.get(i);
			
			for(int j = i + 1; j < colList.size(); j++) {
				double secRad = colList.get(j).getRadius();
				double x2 = colList.get(j).getPose().getPosX();
				double y2 = colList.get(j).getPose().getPosY();
				col2 = colList.get(j);
				
				double distX = x1 - x2;
				double distY = y1 - y2;
				
				double sqrdist = ((distX * distX) + (distY * distY));
				//return sqrdist <= (firstRad * firstRad) + (secRad * secRad);
				if(sqrdist <= (firstRad * firstRad) + (secRad * secRad)) {
					col1.collisionBehavior(col2);					
				}
			}
		}
	}
}

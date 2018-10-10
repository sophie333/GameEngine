package ue01;

public class ShipEdgeHandler extends Component implements EdgeHandler{
	private int width = 110;
	private int height = 90;
	StaticPose pose;
	
	public void activate() {
		pose = getComponent(StaticPose.class);
		pose.setPosX(0);
		pose.setPosY(0);
		
		getService(EdgeSystem.class).addEdgeHandler(this);
	}
	
	public void update(double dt) {
		if(pose.getPosX() > width/2){
			pose.setPosX(-width/2);
		}
		else if (pose.getPosX() < -(width/2)){
			pose.setPosX(width/2);
		}
		if(pose.getPosY() > height/2){
			pose.setPosY(-height/2);
		} 
		else if (pose.getPosY() < -(height/2)){
			pose.setPosY(height/2);
		}
	}

	public void deactivate() {
	}
}

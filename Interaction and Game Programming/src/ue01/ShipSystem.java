package ue01;

public class ShipSystem implements Service
{
	ShipController shipControl;
	
	public void addShip(ShipController ship) {
		if (shipControl == null) {
			shipControl = ship;			
		} else {
			System.out.println("There can only be one ship");
		}
	}
	
	public void removeShip(ShipController ship) {
		shipControl = null;
	}
	
	public void update(double dt) {
		if (shipControl != null) {
			shipControl.update(dt);
		}
	}

	public void startup(ServiceManager s) {

	}

	public void shutdown() {
		shipControl = null;
	}
}

package ue01;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class VisualSystem extends AbstractGraphicsLayer {
	
	private int ordinalNr;
	private List<Visual> visualList = new ArrayList<Visual>();

	public VisualSystem(int mordinalNr) {
		super(mordinalNr);
	}
	
	public void addVisual(Visual v) {
		visualList.add(v);
	}
	
	public void removeVisual(Visual v) {
		visualList.remove(v);
	}
	
	public int getLayerOrdinal() {
		return ordinalNr;
	}

	public void setTransform(AffineTransform transf) {
		super.setTransform(transf);
	}

	public void render(Graphics2D g) {
		//AffineTransform oldTransf = g.getTransform();
		
		for(Visual v : visualList) {
			g.setTransform(transform);
			v.render(g);
		}
	}	

	public void update(double real) {
		
	}

	public void startup(ServiceManager s) {
		super.startup(s);
	}

	public void shutdown() {
		super.shutdown();
	}
}

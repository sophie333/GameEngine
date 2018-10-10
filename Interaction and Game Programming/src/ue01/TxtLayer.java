package ue01;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TxtLayer implements GraphicsLayer{

	protected AffineTransform transform;
	
	@Override
	public int getLayerOrdinal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTransform(AffineTransform transf) {
		this.transform = transf;
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}

package ue01;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public interface GraphicsLayer {
	
	public int getLayerOrdinal();
	public void setTransform(AffineTransform transf);
	public void render(Graphics2D g);
}
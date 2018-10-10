package ue01;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public abstract class AbstractGraphicsLayer implements Service, GraphicsLayer {

	private int layerOrdinal;
	protected AffineTransform transform;
	private GraphicsSystem graphicsSys;
	
	public AbstractGraphicsLayer(int mlayerOrdinal){
		layerOrdinal = mlayerOrdinal;
	}
	
	public int getLayerOrdinal() {
		return layerOrdinal;
	}

	public void setTransform(AffineTransform transf) {
		transform = transf;
	}

	public void render(Graphics2D g) {
		g.drawLine(0, 0, 20, 20);
	}

	public void update(double real) {
		//intentionally left empty
	}

	public void startup(ServiceManager s) {
		graphicsSys = s.getGS();
		graphicsSys.addLayer(this);
	}

	public void shutdown() {
		graphicsSys.removeLayer(this);
	}

}
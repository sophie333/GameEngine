package ue01;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//import java.util.ListIterator;

import at.fhooe.mtd.sgl.Sgl;

public class GraphicsSystem implements Service {

	List<GraphicsLayer> layerList = new ArrayList<GraphicsLayer>();
	
	public void addLayer(GraphicsLayer layer) {
		
		if(layerList.isEmpty()) {
			layerList.add(layer);
		} 
		else {
			layerList.add(layer);
			Collections.sort(layerList, new Comparator<GraphicsLayer>() {

				public int compare(GraphicsLayer g1, GraphicsLayer g2) {
					return g1.getLayerOrdinal() - g2.getLayerOrdinal();
				}
				
			});
		}
	}
	
	public void removeLayer(GraphicsLayer layer) {
		layerList.remove(layer);
	}
	
	public void update(double real) {
		Graphics2D g = Sgl.graphics.beginUpdate();
		for (GraphicsLayer layer : layerList) {
			layer.render(g);
		}
		Sgl.graphics.endUpdate();
	}

	public void startup(ServiceManager s) {

	}

	public void shutdown() {
		layerList.clear();
	}

}

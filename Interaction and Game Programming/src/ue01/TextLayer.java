package ue01;

import java.awt.Color;
import java.awt.Graphics2D;

public class TextLayer extends Component implements Visual{
	
	private String text;
	
	public TextLayer() {
	}

	@Override
	public void render(Graphics2D g) {
		String text = "Lives: " + getEntity().getServiceManager().life;
		g.setColor(Color.GREEN);
		g.drawString(text, 0, 0);
	}

	@Override
	void activate() {
		//getComponent(VisualSystem.class).addVisual(this);
		
	}

	@Override
	void deactivate() {

		//getComponent(VisualSystem.class).removeVisual(this);
		
	}
}

package ue01;

import java.awt.Color;
import java.awt.Graphics2D;

public class SomeGraphicsLayer extends AbstractGraphicsLayer{

	private int a,b,c,d;
	
	public SomeGraphicsLayer(int mlayerOrdinal, int a, int b, int c, int d) {
		super(mlayerOrdinal);
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawRect(a, b, c, d);
	}
}

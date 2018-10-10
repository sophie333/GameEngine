package ue01;

import at.fhooe.mtd.sgl.app.Java2dApplication;
import at.fhooe.mtd.sgl.app.Java2dApplicationConfig;
import at.fhooe.mtd.sgl.graphics.GfxConfigurator;

public class GameLauncher {

	public static void main(String[] args) {
		GfxConfigurator gfxc = new GfxConfigurator();
		gfxc.setTitle("Hello Sgl Graphics Configuration");
		gfxc.runDialog();
		
		Java2dApplicationConfig config = Java2dApplicationConfig.create(gfxc);
		config.title = "Asteroids";
		new Java2dApplication(config, new HelloWorld());
	}

}

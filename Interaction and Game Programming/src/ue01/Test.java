package ue01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceManager sManager = new ServiceManager();
		GraphicsSystem graphicsSys = new GraphicsSystem();
		
		MyService myService = new MyService();
		sManager.addService(myService);
		sManager.startupAll(sManager);
		long oldTime = System.nanoTime();
		while(true) {
			long newTime = System.nanoTime();
			double difference = (newTime - oldTime)/1000000000.0;
			sManager.updateAll(difference);
			oldTime = newTime;
		}
		//sManager.get(LineRenderer.class).drawCircle(1, 1, 4);
	}

}

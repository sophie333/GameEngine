package ue01;

public class MyService implements Service{

	double time;
	
	public void update(double real){
		time = time + real;
		if(time >= 5) {
			System.out.println("5 Sekunden sind vergangen");
			time = 0;
		}
	}
	//started wie init
	public void startup(ServiceManager s){
		time = 0;
	}
	//gibt alles frei, niemand kann es mehr benutzen
	public void shutdown(){
		
	}
}

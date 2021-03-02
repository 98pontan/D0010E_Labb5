package lab5.sim;

import java.util.Random;

public class Event {
	double time;
	
	Event(){
		Random r = new Random();
		time = r.nextDouble();
	}

}

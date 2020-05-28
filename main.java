

import interfaceGraphique.*;

/**
 * On créer nos 3 fenetres et on les dispose sur l'écran à l'aide de coordonnées.
 */

public class main {

	public static void main(String[] args){
	

		
		  Simulation fen = new Simulation();
		  Monitoring a = new MoniteurA("ecologie");
		  Monitoring b = new MoniteurB("pompier");
		  
		  a.setLocation(20,280);
		  b.setLocation(900,280);
		  
		  fen.addA(a);
		  fen.addB(b);
		  
	}

}

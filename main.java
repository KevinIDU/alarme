

import interfaceGraphique.*;

public class main {

	public static void main(String[] args){
	

		
		  Simulation fen = new Simulation();
		  Monitoring A = new MoniteurA("ecologie");
		  Monitoring B = new MoniteurB("pompier");
		  
		  fen.addA(A);
		  fen.addB(B);
		  
	}

}

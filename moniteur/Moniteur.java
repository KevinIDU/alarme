package moniteur;
import event.*;
import listener.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe héritant des interfaces "Listener"
 */

public class Moniteur implements IncendieListener,GazListener,RadiationListener {
	protected String type;

	public Moniteur(String type) {
		super();
		this.type = type;
	}
	
	/**
	 * @return l'atribut type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return la description de l'event (incendie)
	 */
	@Override
	public void attentionFume(IncendieEvent event) {
			System.out.println("Alarme FEU : " + event.toString());
			

	}
	/**
	 * @return la description de l'event (gaz)
	 */
	public void attentionGaz(GazEvent event) {
		System.out.println("Alarme GAZ : " + event.toString());	
	}

	/**
	 * @return la description de l'event (radiation)
	 */
	@Override
	public void attentionRadiation(RadiationEvent event) {
		System.out.println("Alarme RADIATION : " + event.toString());
		
	}
}


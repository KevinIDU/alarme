package event;

import java.time.LocalDateTime;
import java.util.EventObject;

/**
 * Classe specifique aux incendies, heritant de la classe AlarmeEvent
 *  @see AlarmeEvent
 */

public class IncendieEvent extends AlarmeEvent{

	

	public IncendieEvent(Object source, String localisation, int importance,LocalDateTime date, boolean traite){
		super(source,  localisation, importance, date, traite);
		
	}


	/**
	 * @return la description de l'event
	 */
	@Override
	public String toString() {
		return "Capteur incendie \n� la date "+ this.date + " \nlocalis�e "+this.localisation +" \net est jug� d'importance "+this.importance;
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return le type d'alarme (ici incendie)
	 */
	public String toInfo() {
		return "Detection d'un INCENDIE";
	}

	/**
	 * @return l'�tat du traitement de l'alarme
	 */
	public boolean toTraite() {
		return this.traite;
	}
	

}

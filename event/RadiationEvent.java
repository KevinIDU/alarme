package event;
import java.time.LocalDateTime;

/**
 * Classe specifique aux radiations, heritant de la classe AlarmeEvent
 *  @see AlarmeEvent
 */

public class RadiationEvent extends AlarmeEvent{
	private int niveau;

	public RadiationEvent(Object source, LocalDateTime localDateTime, int importance, int niveau, String localisation, boolean traite) {
		super(source, localisation,importance, localDateTime, traite);
		if(niveau<=100 & niveau>=0) {
			this.niveau = niveau;
			
		}
		else {
			System.out.println("erreur mauvais niveau de radiation");
		}
	}
	/**
	 * @return la description de l'event
	 */
	@Override
	public String toString() {
		return "Capteur radiation \nà la date "+ this.date + " \nlocalisée "+this.localisation +" \net est jugé d'importance "+this.importance +"\nde niveau "+this.niveau;
		
	}
	/**
	 * @return le type d'alarme (ici radiations)
	 */
	public String toInfo() {
		return "Detection de RADIATION";
	}
	
	/**
	 * @return l'état du traitement de l'alarme
	 */
	public boolean toTraite() {
		return this.traite;
	}
	
}

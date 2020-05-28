package event;
import java.time.LocalDateTime;
import java.util.EventObject;

/**
 * Classe specifique au gaz, heritant de la classe AlarmeEvent
 *  @see AlarmeEvent
 */
public class GazEvent extends AlarmeEvent{
	protected String type;
	
	public GazEvent(Object source, LocalDateTime localDateTime, int importance,String localisation, String type, boolean traite) {
		super(source, localisation,importance,localDateTime, traite);
		this.type = type;
	}

	/**
	 * @return l'atribut type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type
	 * 	valeur du type que l'on veut ajouter
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return la description de l'event
	 */
	@Override
	
	public String toString() {
		
		return "Capteur : "+this.type+" \n� la date "+ this.date + " \nlocalis�e "+this.localisation +" \net est jug� d'importance "+this.importance;
	}
	
	/**
	 * @return le type d'alarme (ici gaz)
	 */
	
	public String toInfo() {
		return "Detection de GAZ";
	}
	
	/**
	 * @return l'�tat du traitement de l'alarme
	 */

	public boolean toTraite() {
		return this.traite;
	}
	

	


}

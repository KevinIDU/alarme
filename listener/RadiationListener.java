package listener;
import event.RadiationEvent;
import java.util.EventListener;


/**
 * Interface dont va hériter SourceRadiation.
 * @see SourceRadiation
 */

public interface RadiationListener extends EventListener{
	
	/**
	 * Méthode abstraite qui va servir à générer l'événement de l'alarme Radiations.
	 */
	public void attentionRadiation(RadiationEvent event);

}

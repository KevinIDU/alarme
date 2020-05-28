package listener;
import event.RadiationEvent;
import java.util.EventListener;


/**
 * Interface dont va h�riter SourceRadiation.
 * @see SourceRadiation
 */

public interface RadiationListener extends EventListener{
	
	/**
	 * M�thode abstraite qui va servir � g�n�rer l'�v�nement de l'alarme Radiations.
	 */
	public void attentionRadiation(RadiationEvent event);

}

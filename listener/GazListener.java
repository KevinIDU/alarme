package listener;
import event.GazEvent;
import java.util.EventListener;

/**
 * Interface dont va h�riter SourceGaz.
 * @see SourceGaz
 */
public interface GazListener extends EventListener{
	
	/**
	 * M�thode abstraite qui va servir � g�n�rer l'�v�nement de l'alarme Gaz.
	 */
	public void attentionGaz(GazEvent event);
}

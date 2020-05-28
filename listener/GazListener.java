package listener;
import event.GazEvent;
import java.util.EventListener;

/**
 * Interface dont va hériter SourceGaz.
 * @see SourceGaz
 */
public interface GazListener extends EventListener{
	
	/**
	 * Méthode abstraite qui va servir à générer l'événement de l'alarme Gaz.
	 */
	public void attentionGaz(GazEvent event);
}

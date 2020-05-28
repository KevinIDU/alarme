package listener;
import event.GazEvent;
import event.IncendieEvent;
import java.util.EventListener;


/**
 * Interface dont va hériter SourceIncendie.
 * @see SourceIncendie
 */

public interface IncendieListener extends EventListener{
	
	
	/**
	 * Méthode abstraite qui va servir à générer l'événement de l'alarme Incendie.
	 */
	public void attentionFume(IncendieEvent event) ;

}

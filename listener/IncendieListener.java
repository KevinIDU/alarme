package listener;
import event.GazEvent;
import event.IncendieEvent;
import java.util.EventListener;


/**
 * Interface dont va h�riter SourceIncendie.
 * @see SourceIncendie
 */

public interface IncendieListener extends EventListener{
	
	
	/**
	 * M�thode abstraite qui va servir � g�n�rer l'�v�nement de l'alarme Incendie.
	 */
	public void attentionFume(IncendieEvent event) ;

}

package source;
import event.IncendieEvent;
import listener.IncendieListener;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe symbolisant le capteur Incendie, qui va g�rer la liste des listeners et g�n�rer les �v�nements.
 */

public class SourceIncendie{
	private ArrayList<IncendieListener> listenerList = new ArrayList<IncendieListener>(); 
	
	/**
	 * @param listener 
	 *  Objet de type IncendieListener que l'on veut ajouter � la liste des listeners. 
	 */
	
		public void addIncendieListener(IncendieListener listener) {
			if (listener == null) {
				return;
			}
			listenerList.add(listener);
		}
		
		/**
		 * @param listener 
		 *  Objet de type IncendieListener que l'on veut ajouter � la liste des listeners. 
		 */
		
	 public void removeIncendieListener(IncendieListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	 
	 /**
		 *  @return l'�v�nement IncendieEvent que l'on a cr��.
		 *  
		 */
	public IncendieEvent generateIncendieEvent(String localisation, int importance,LocalDateTime date) {
		IncendieEvent event = new IncendieEvent(this, localisation,importance,date, false);
		for(IncendieListener ie : listenerList) {
			ie.attentionFume(event);
		}
		return event;
		
	}
	 


}

package source;
import event.GazEvent;
import listener.GazListener;


import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Classe symbolisant le capteur Gaz, qui va g�rer la liste des listeners et g�n�rer les �v�nements.
 */

public class SourceGaz {
	protected ArrayList<GazListener> listenerList = new ArrayList<GazListener>() ;
	
	/**
	 * @param listener 
	 *  Objet de type GazListener que l'on veut ajouter � la liste des listeners. 
	 */
	
	public void addGazListener(GazListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	
	/**
	 * @param listener
	 *  Objet de type GazListener que l'on veut retirer de la liste des listeners.
	 */
	public void removeGazListener(GazListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	/**
	 *  @return l'�v�nement GazEvent que l'on a cr��.
	 *  
	 */
	public GazEvent generateGazEvent(LocalDateTime localDateTime, int importance, String type, String localisation) {
		GazEvent event = new GazEvent(this,localDateTime,importance,type, localisation, false);
		for(GazListener ie : listenerList) {
			ie.attentionGaz(event);
			
		}
		
		return event;
	}
	
	

}

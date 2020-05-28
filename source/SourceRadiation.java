package source;
import event.RadiationEvent;
import listener.RadiationListener;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Classe symbolisant le capteur Radiation, qui va g�rer la liste des listeners et g�n�rer les �v�nements.
 */
public class SourceRadiation {
	private ArrayList<RadiationListener> listenerList = new ArrayList<RadiationListener>(); 
	
	
	/**
	 * @param listener 
	 *  Objet de type RadiationListener que l'on veut ajouter � la liste des listeners. 
	 */
	
	public void addRadiationListener(RadiationListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	
	/**
	 * @param listener 
	 *  Objet de type RadiationListener que l'on veut ajouter � la liste des listeners. 
	 */
	
	 public void removeRadiationListener(RadiationListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	 
	 /**
		 *  @return l'�v�nement RadiationEvent que l'on a cr��.
		 *  
		 */
	public RadiationEvent generateRadiationEvent( LocalDateTime localDateTime, int importance, int niveau, String localisation){
		RadiationEvent event = new RadiationEvent(this,localDateTime,importance, niveau, localisation, false);
		for(RadiationListener ie : listenerList) {
			ie.attentionRadiation(event);
		}
		return event;
		
	}
 


}


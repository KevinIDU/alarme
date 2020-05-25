package listener;
import event.RadiationEvent;
import java.util.EventListener;

public interface RadiationListener extends EventListener{
	
	public void attentionRadiation(RadiationEvent event);

}

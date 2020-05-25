package listener;
import event.GazEvent;

import java.util.EventListener;

public interface GazListener extends EventListener{
	
	public void attentionGaz(GazEvent event);
}

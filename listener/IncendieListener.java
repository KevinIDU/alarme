package listener;
import event.IncendieEvent;
import java.util.EventListener;

public interface IncendieListener extends EventListener{
	
	public void attentionFume(IncendieEvent event) ;

}

package playerJoinTracker;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
	
	
    public String name;
    public main m;
	
    public EventListener(main m) {
    	this.m = m;
    }
    
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		name = event.getPlayer().getName();
	}
}

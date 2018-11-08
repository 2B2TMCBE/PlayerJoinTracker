package Events;

import Main.Main.Main.Main;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
	
	
    public String name;
    public Main main;
	
    public EventListener(Main main) {
    	this.main = main;
    }
    
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		name = event.getPlayer().getName();
	}
}

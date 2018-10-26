package playerJoinTracker;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class main extends PluginBase {
	
	@SuppressWarnings("unused")
	private EventListener listener;
	
	@Override
	public void onLoad() {
		this.getLogger().info("PlayerJoinTracker loaded");
	}
	@Override
	public void onEnable() {
		this.getLogger().info("PlayerJoinTracker enabled.");
		this.getServer().getPluginManager().registerEvents(new EventListener(this),this);
	}
	@Override
	public void onDisable() {
		this.getLogger().info("PlayerJoinTracker disabled.");
	}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if(command.getName().equalsIgnoreCase("lastjoin")) {
    		sender.sendMessage("playername not found.");
    		// TODO add in mechanism that trace the last join time of every players
    	}
        return false;
    }
	
}

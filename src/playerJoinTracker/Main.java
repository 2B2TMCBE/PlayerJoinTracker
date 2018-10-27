package playerJoinTracker;

import java.time.LocalDateTime;
// import from java library
import java.util.HashMap;

// import from Nukkitx
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {
	
  // create private variables
  // @SuppressWarnings("unused")
  // private EventListener listener;

  // Create public variables
  public HashMap<String, LocalDateTime> joindata = new HashMap<>(); 

  @Override
  public void onLoad() {
    this.getLogger().info(TextFormat.YELLOW + "PlayerJoinTracker loaded");
  }
  @Override
  public void onEnable() {
    this.getLogger().info(TextFormat.GREEN + "PlayerJoinTracker enabled.");
    this.getServer().getPluginManager().registerEvents(new EventListener(this),this);
  }
  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "PlayerJoinTracker disabled.");
  }
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(command.getName().equalsIgnoreCase("lastjoin")) {
      if(joindata.containsKey(args[0])) {
        LocalDateTime time = joindata.get(args[0]);
        sender.sendMessage(TextFormat.BLUE + "Player, " + args[0] + " " + "last joined in " + time.toString());  
        return true;
      } else {
        sender.sendMessage(TextFormat.RED + "Player doesn't exist, please try again.");
        return true;
      }
    } else {
      sender.sendMessage(TextFormat.RED + "Command doesn't exist, please make sure the command exist and that you have permission to use it.");
      return true;
    }
  }

}

package Main.Main.Main;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import Events.EventListener;
import cn.nukkit.Player;
import cn.nukkit.Server;
// import from Nukkitx
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {
	
  // create private variables
  // @SuppressWarnings("unused")
  // private EventListener listener;

  @Override
  public void onLoad() {
    this.getLogger().info(TextFormat.YELLOW + "PlayerJoinTracker loaded");
  }
  @Override
  public void onEnable() {
    regEvents();
    this.getLogger().info(TextFormat.GREEN + "PlayerJoinTracker enabled.");
  }
  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "PlayerJoinTracker disabled.");
  }
  public void regEvents() {
    //this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)){
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
  }
    Player p = (Player) sender;
    Player Target = Server.getInstance().getPlayer(args[0]);
    
    if(cmd.getName().equalsIgnoreCase("lastjoin")) {
      if (args.length == 1) {
        p.sendMessage(TextFormat.BLUE + "Player, " + args[0] + " " + "last joined in " + convertTime(Target));
        return true;
      } else {
        p.sendMessage(TextFormat.RED + "Player doesn't exist, please try again.");
        return true;
      }
    }
    return true;
  }
  public String convertTime(Player Target){
    Date date = new Date(TimeUnit.SECONDS.toMillis(Target.getLastPlayed()));
    Format format = new SimpleDateFormat("YYYY-MM-dd-HH:mm:ss");
    return format.format(date).toString();
}
}
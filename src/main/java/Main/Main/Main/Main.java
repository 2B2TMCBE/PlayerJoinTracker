package main.java.Main.Main.Main;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import cn.nukkit.IPlayer;
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
    // regEvents();
    this.getLogger().info(TextFormat.GREEN + "PlayerJoinTracker enabled.");
  }

  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "PlayerJoinTracker disabled.");
  }

  /*
   * public void regEvents() { //this.getServer().getPluginManager().registerEvents(new
   * EventListener(this), this); }
   */


  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    /*
     * if (!(sender instanceof Player)) { sender.sendMessage("Only Players Can Use This Command.");
     * return true;
     */
    // Player p = (Player) sender;
    IPlayer target = null;
    try {
      // use try catch to fix NullPointerException
      if (cmd.getName().equalsIgnoreCase("lastjoin")) {
        if (args.length == 1 && args[0] != null) {
          target = this.getServer().getOfflinePlayer(args[0]);
          if (target == null) {
            sender.sendMessage(TextFormat.RED + "Player doesn't exist, please try again.");
          } else {
            sender.sendMessage(TextFormat.BLUE + "Player, " + args[0] + " " + "last joined in "
                + convertTime(target));
          }
        } else {
          sender.sendMessage("Command usage: /lastjoin <PlayerName>");
        }
      }
    } catch (NullPointerException e) {
      sender.sendMessage("Player doesn't exist, please try again.");
    }
    return true;
  }

  /**
   * This function convert the Join time of a player into human readable format
   * 
   * @param Player target
   * @return String format.toString()
   */
  public String convertTime(IPlayer target) {
    Date date = new Date(TimeUnit.SECONDS.toMillis(target.getLastPlayed()));
    Format format = new SimpleDateFormat("YYYY-MM-dd-HH:mm:ss");
    String result = format.format(date).toString();
    return result;
  }

}

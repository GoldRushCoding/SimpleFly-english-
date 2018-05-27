package SimpleFly;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class MainClass extends cn.nukkit.plugin.PluginBase
{
  public MainClass () {}
  
  public void onEnable ()
  {
    getLogger (). info ("§aSimpleFly successfully loaded!");
  }
  
  public void onDisable ()
  {
    getLogger (). info ("§cSimpleFly successfully turned off!");
  }
  
  public boolean onCommand (CommandSender sender, Command command, String label, String [] args)
  {
    switch (command.getName ()) {
    case "fly":
      if (args.length! = 0) {
        Player p = getServer (). GetPlayer (args [0]);
        if ((p instanceof Player)) {
          int gm = p.getGamemode ();
          if (gm == 0) {
            if (sender.hasPermission ("fly.command.other"))) {
              if (p.getAllowFlight ()) {
                p.setAllowFlight (false);
                sender.sendMessage (TextFormat.colorize ("& c [Fly] Fly player" + p.getName () + "successfully turned off!")));
                p.sendMessage (TextFormat.colorize ("& c [Fly] You have been turned off by the flight mode!"));
              } else {
                p.setAllowFlight (true);
                sender.sendMessage (TextFormat.colorize ("& a [Fly] Fly player" + p.getName () + "enabled successfully!"));
                p.sendMessage (TextFormat.colorize ("& a [Fly] You turned on the flight mode!"));
              }
            } else {
              sender.sendMessage (TextFormat.colorize ("& c [Fly] You do not have the right to include other flags!"));
            }
          } else {
            sender.sendMessage (TextFormat.colorize ("& c [Fly] Your game mode is not survival!"));
          }
        } else {
          sender.sendMessage (TextFormat.colorize ("& c [Fly] There is no such player on the server!"));
        }
      } else {
        Player p = getServer (). GetPlayer (sender.getName ());
        if ((sender instanceof Player)) {
          int gm = ((Player) sender) .getGamemode ();
          if (gm! = 0) {
            sender.sendMessage (TextFormat.colorize ("& c [Fly] Your game mode is not survival!"));
            return true;
          }
          if (((Player) sender) .getAllowFlight ()) {
            ((Player) sender) .setAllowFlight (false);
            sender.sendMessage (TextFormat.colorize ("& c [Fly] You have successfully turned off the flight mode!"));
          } else {
            ((Player) sender) .setAllowFlight (true);
            sender.sendMessage (TextFormat.colorize ("& a [Fly] You have successfully enabled the flight mode!"));
          }
        } else {
          sender.sendMessage (TextFormat.colorize ("& c [Fly] Please use this command in the game!"));
        }
      }
      return true;
    }
    return true;
  }
}
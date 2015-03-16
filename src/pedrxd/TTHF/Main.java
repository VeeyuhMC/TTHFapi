package pedrxd.TTHF;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = null;
		if(sender instanceof Player){
			p = (Player) sender;
		}else{
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Version: " + ChatColor.BLUE + getDescription().getVersion());
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("tthfapi") && p.hasPermission("TTHF.api")){
			p.sendMessage(ChatColor.RED + "Version: " + ChatColor.BLUE + getDescription().getVersion());
		}else{
			p.sendMessage(ChatColor.RED + "You don't have permissions");
		}
		
		
		
		return true;
	}
}

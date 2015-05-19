package pedrxd.TTHF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


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
			Bukkit.getServer().getConsoleSender().sendMessage(checkVersion());
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("tthf") || cmd.getName().equalsIgnoreCase("tthfapi") && p.hasPermission("TTHF.api")){
			p.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.BLUE + getDescription().getVersion());
			p.sendMessage(" ");
			p.sendMessage(checkVersion());
			
		}else{
			p.sendMessage(ChatColor.RED + "You don't have permissions");
		}
		
		
		
		return true;
	}
	private String checkVersion(){
		String latestversion;
		boolean isupdate;
		try {
			URL urlv = new URL("https://raw.githubusercontent.com/pedrxd/TTHFapi/NewApi/README");
	        BufferedReader in = new BufferedReader(new InputStreamReader(urlv.openStream()));
	        latestversion = in.readLine();
	        if(latestversion.equalsIgnoreCase(getDescription().getVersion())){
	        	isupdate = true;
	        }else{
	        	isupdate = false;
	        }
	        in.close();
		} catch (IOException e) {
			System.out.println("[TTHF] I can't connect to our servers, are you offline?");
			return "";
		}
		if(isupdate){
			return ChatColor.GREEN  +"The api is Updated";
		}else{
			return ChatColor.RED + "The api isn't update, latest version " + latestversion + ".  Download it from " + ChatColor.GOLD + ChatColor.BOLD + " http://www.spigotmc.org/resources/tthfapi.4938/";
		}
	}
}

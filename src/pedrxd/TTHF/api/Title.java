package pedrxd.TTHF.api;

import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R2.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class Title {
	
	
	public static void sendTitle(Player p, String title){
		CraftPlayer craftplayer = (CraftPlayer) p;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', title.replaceAll("%player%", p.getName())) + "\"}");
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.TITLE, cbc);
		connection.sendPacket(packet); 
	}
	
	
	
	
	
	public static void sendTitle(String title){

		for (Player list : Bukkit.getOnlinePlayers()) {
			sendTitle(list.getPlayer(), title);
		}
		
    }
	
	public static void sendSubtitle(Player p, String subtitle){
		CraftPlayer craftplayer = (CraftPlayer) p;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', subtitle.replaceAll("%player%", p.getName())) + "\"}");
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, cbc);
		connection.sendPacket(packet); 
		sendTitle(p, " ");
		
	}






	public static void sendSubtitle(String subtitle){

		for (Player list : Bukkit.getOnlinePlayers()) {
			Player psender = list.getPlayer();
			sendSubtitle(psender, subtitle);
			sendTitle(psender, " ");
		}
	}
	
	public static void sendTitleSub(Player p, String title, String subtitle){
		sendSubtitle(p, subtitle);
		sendTitle(p, title);
		
	}
	public static void sendTitleSub(String title, String subtitle){
		sendSubtitle(subtitle);
		sendTitle(title);
		
	}

	
	
	
	
}

package pedrxd.TTHF.api;


	import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;



	public class ActionBar {

		public static void sendActionBar(Player p, String message){
			CraftPlayer craftplayer = (CraftPlayer) p;
			IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message.replaceAll("%player%", p.getName())) + "\"}");
			PacketPlayOutChat packet = new PacketPlayOutChat(cbc, (byte) 2);
			craftplayer.getHandle().playerConnection.sendPacket(packet);
		}
		public static void sendActionBar(String message){

			for (Player list : Bukkit.getOnlinePlayers()) {
				sendActionBar(list.getPlayer(), message);
			}

	    }
		

}

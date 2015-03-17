package pedrxd.TTHF.api;

import java.lang.reflect.Field;










import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R2.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;





public class TabMenu {
	
	public static void sendTabHeadFoot(Player p, String Header, String Footer){
	    CraftPlayer craftplayer = (CraftPlayer) p;
	    PlayerConnection connection = craftplayer.getHandle().playerConnection;
	    IChatBaseComponent header = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', Header.replaceAll("%player%", p.getName())) + "\"}");
	    IChatBaseComponent footer = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', Footer.replaceAll("%player%", p.getName())) + "\"}");
	    PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

	    try {
	        Field headerField = packet.getClass().getDeclaredField("a");
	        headerField.setAccessible(true);
	        headerField.set(packet, header);
	        headerField.setAccessible(!headerField.isAccessible());

	        Field footerField = packet.getClass().getDeclaredField("b");
	        footerField.setAccessible(true);
	        footerField.set(packet, footer);
	        footerField.setAccessible(!footerField.isAccessible());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }  
	    connection.sendPacket(packet);
    }
	
	
	public static void sendTabHeadFoot(String Header, String Footer){

		for (Player list : Bukkit.getOnlinePlayers()) {
			sendTabHeadFoot(list.getPlayer(), Header, Footer);	
		}	


	}

}

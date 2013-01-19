package ca.strendin.MSTR_MobHeads;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class MSTR_SetHeadCommand implements CommandExecutor {
    @SuppressWarnings("unused")
    private final MSTR_MobHeads plugin;

    public MSTR_SetHeadCommand(MSTR_MobHeads plugin) {
        this.plugin = plugin;
    }

	public static ItemStack Skull(String skullOwner) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
		SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
		skullMeta.setOwner(skullOwner);
		skull.setItemMeta(skullMeta);
		return skull;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
        
        if (sender instanceof Player) {
            if (MSTR_Permissions.canSetHead(((Player)sender))) {
                Player player = (Player)sender;
                // Make sure the item in hand is a mob head
                if (player.getItemInHand().getType() == Material.SKULL_ITEM)
                {
                	if (args.length > 0) {
                        String param = args[0];
                        player.setItemInHand(Skull(param));
                	} else {
                		player.setItemInHand(Skull(player.getName()));
                	}
                	             	
                } else {
                	MSTR_Comms.sendError(player, "You are not holding a mob head!");
                }
                
                
                
            } else {
            	MSTR_Comms.permDenyMsg((Player)sender);
            }
        } else {
        	MSTR_Comms.sendConsole("Player command only!");
        }        
        return true;
	}

}

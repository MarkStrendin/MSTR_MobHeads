package ca.strendin.MSTR_MobHeads;

import org.bukkit.entity.Player;

public class MSTR_Permissions {
    public static boolean canSetHead(Player player) {
        return player.hasPermission("mstr_mobheads.sethead");
    }   

}

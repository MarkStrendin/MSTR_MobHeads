package ca.strendin.MSTR_MobHeads;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class MSTR_MobHeads extends JavaPlugin {

    @Override
    public void onDisable() {
        MSTR_Comms.logThis("Plugin DISABLED");        
    }

    @Override
    public void onEnable() {
        //Commands
        getCommand("head").setExecutor(new MSTR_SetHeadCommand(this));
        MSTR_Comms.logThis("Plugin ENABLED");        
    }
    
    public Player findPlayerNamed(String thisName) {
        return this.getServer().getPlayer(thisName);
    }

}

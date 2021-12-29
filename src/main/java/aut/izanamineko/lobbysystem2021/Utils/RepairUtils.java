package aut.izanamineko.lobbysystem2021.Utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class RepairUtils {

    public static void repairAll(Player p) {
        for(ItemStack items : p.getInventory().getContents()) {
            if(items != null) {
                items.setDurability((short)0);
            }
        }
        for(ItemStack items : p.getEquipment().getArmorContents()) {
            if(items != null) {
                items.setDurability((short)0);
            }
        }
    }

    public static void repairHand(Player p) {

        if(p.getInventory().getItemInMainHand().getType() != null){
        p.getInventory().getItemInMainHand().setDurability((short)0);

        }
    }

}

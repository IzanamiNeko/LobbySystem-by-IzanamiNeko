package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class GeneralEvent implements Listener {

    static main plugin;

    public GeneralEvent(main instance) {
        plugin = instance;
    }

    public void onDrop(PlayerDropItemEvent dropItem) {
        Player p = dropItem.getPlayer();
        if(p.hasPermission("LobbySystem.DropItem") || this.plugin.getConfig().getString("Config.GeneralEvents.dropItem").equals("false")) {
            dropItem.setCancelled(false);
        }
        dropItem.setCancelled(true);
    }

    public void onPickup(PlayerPickupItemEvent pickupItem) {
        Player p = pickupItem.getPlayer();
        if(p.hasPermission("LobbySystem.PickupItem") || this.plugin.getConfig().getString("Config.GeneralEvents.pickupItem").equals("false"))
            return;
        pickupItem.setCancelled(true);
    }


    public void onEntityDamage(EntityDamageEvent noDamage) {
        Player p = ((Player) noDamage.getEntity()).getPlayer();
        if (!(noDamage.getEntity() instanceof Player)){
            return;
        }
        if(p.hasPermission("LobbySystem.NoFalldamage")){
            if(noDamage.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                noDamage.setCancelled(true);

            } else {
                noDamage.setCancelled(false);
            }
        }
    }
    public void onDrowning(EntityDamageEvent noDrown){
        Player p = ((Player) noDrown.getEntity()).getPlayer();
        if (!(noDrown.getEntity() instanceof Player)){
            return;
        }
        if(p.hasPermission("LobbySystem.NoDrown")){
        if(noDrown.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)){
                noDrown.setCancelled(true);
            } else {
                noDrown.setCancelled(false);
        }
        }
    }
}

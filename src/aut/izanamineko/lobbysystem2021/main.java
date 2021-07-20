package aut.izanamineko.lobbysystem2021;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable ausgeführt
        System.out.println("LobbySystem V2021 wird ausgeführt");
    }

    public void onDisable() {       //Beim Stoppen wird alles was in onDisable ausgeführt
        System.out.println("LobbySystem V2021 wird gestoppt");
    }
}

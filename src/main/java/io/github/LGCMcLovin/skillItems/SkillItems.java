package io.github.LGCMcLovin.skillItems;

import io.github.LGCMcLovin.skillItems.commands.Commander;
import io.github.LGCMcLovin.skillItems.data.PlayerData;
import io.github.LGCMcLovin.skillItems.item.ItemHandler;
import io.github.LGCMcLovin.skillItems.item.Recipes;
import io.github.LGCMcLovin.skillItems.listeners.BlockListener;
import io.github.LGCMcLovin.skillItems.listeners.EntityListener;
import io.github.LGCMcLovin.skillItems.listeners.PlayerListener;
import io.github.LGCMcLovin.skillItems.util.Util;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Allen on 3/3/2015.
 */
public class SkillItems extends JavaPlugin implements Listener{

    public String version = "0.0.1";
    public String build = "0001";


    private PlayerData playerData = null;

    private ConfigDB configDB = null;

    private ItemHandler itemHandler = null;
    private Recipes recipes = null;
    private static SkillItems instance = null;

    private static API api = null;

    public PlayerListener pl;
    public BlockListener bl;
    public EntityListener el;


    private Logger log = Logger.getLogger("Minecraft");

    public void onEnable()
    {
        instance = this;
        configDB = new ConfigDB(this);
        itemHandler = new ItemHandler(this);
        api = new API(this);
        playerData = new PlayerData(this);
        recipes = new Recipes(this);


        /*
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {

        }
        */

        configDB.Startup();

        pl = new PlayerListener(this);
        bl = new BlockListener(this);
        el = new EntityListener(this);

        // Set command executor

        this.getCommand("ci").setExecutor((CommandExecutor) new Commander(this));

        log.info(Util.editConsole("Plugin loaded! Version " + version + " / Build: " + build));


    }
       //REGISTER EVENTS HERE


       // SET COMMAND EXECUTOR HERE

    public void onDisable(){

        log.info("[SkillItems] Plugin stopped!");

    }

    public boolean hasPermission(Player player,String str){
        if (player.hasPermission(str)){
            return true;
        }else if (player.hasPermission("custom-items.*")){
            return true;
        }
        return false;
    }

    public ConfigDB getConfigDB(){
        return this.configDB;
    }

    public ItemHandler getItemHandler(){
        return this.itemHandler;
    }

    public Logger getLog(){
        return this.log;
    }

    public static API getAPI(){
        return api;
    }

    public PlayerData getPlayerData(){
        return this.playerData;
    }

    public Recipes getRecipes(){
        return this.recipes;
    }

    public static SkillItems getInstance(){
        return instance;
    }

}




package io.github.LGCMcLovin.skillItems.data;

import io.github.LGCMcLovin.skillItems.SkillItems;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 3/3/2015.
 */
public class PlayerData {

    private SkillItems instance=null;
    private Map<String,Integer> P_Data = new HashMap<String,Integer>();
    private Map<String,String> P_DataString = (Map<String, String>) new HashMap<String,String>();

    public PlayerData(SkillItems i){
        this.instance=i;
    }

    public void addPlayerData(Player player,String type,int data){
        int oldData=0;
        if (isPlayerData(player,type)){
            oldData=P_Data.get(player.getName()+"_"+type).intValue();
            P_Data.remove(player.getName()+"_"+type);
            P_Data.put(player.getName()+"_"+type, oldData+data);
        }else{
            P_Data.put(player.getName()+"_"+type, oldData+data);
        }
    }

    public void removePlayerDataString(Player player, String type){
        if (isPlayerDataString(player,type)){
            P_DataString.remove(player.getName()+"_"+type);
        }
    }

    public void addPlayerDataString(Player player,String type,String data){

        if (isPlayerDataString(player,type)){

            P_DataString.remove(player.getName()+"_"+type);
            P_DataString.put(player.getName()+"_"+type, data);
        }else{
            P_DataString.put(player.getName()+"_"+type, data);
        }
    }


    public boolean isPlayerDataString(Player player,String type){

        return P_DataString.containsKey(player.getName()+"_"+type);

    }

    public boolean isPlayerData(Player player,String type){

        return P_Data.containsKey(player.getName()+"_"+type);

    }
    public int getPlayerData(Player player,String type){
        if (isPlayerData(player,type)){
            return P_Data.get(player.getName()+"_"+type).intValue();
        }
        return 0;
    }

    public String getPlayerDataString(Player player,String type){
        if (isPlayerDataString(player,type)){
            return P_DataString.get(player.getName()+"_"+type);
        }
        return "";
    }
}


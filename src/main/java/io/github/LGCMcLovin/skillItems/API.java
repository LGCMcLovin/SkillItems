package io.github.LGCMcLovin.skillItems;

import io.github.LGCMcLovin.skillItems.item.ItemHandler;
import io.github.LGCMcLovin.skillItems.objects.CustomEnchantment;
import io.github.LGCMcLovin.skillItems.objects.CustomRecipe;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created by Allen on 3/3/2015.
 */
public class API {

    private SkillItems instance=null;

    public API(SkillItems i){
        instance=i;
    }

    public ItemStack createItem(String name){
        return instance.getItemHandler().createItem(name);
    }
    public boolean hasAbility(ItemStack item,String ability){
        return instance.getItemHandler().hasAbility(item, ability);
    }
    public void addAbility(String ab){
        instance.getItemHandler().addAbility(ab);
    }
    public void addItem(String name,String displayname,int ID,boolean permission,String color,boolean userecipe,boolean usecustom,ArrayList<String> lore,ArrayList<String> abilities,CustomRecipe recipe,ArrayList<CustomEnchantment> custom_ench){
        instance.getConfigDB().addItem(name,displayname, ID, permission, color,userecipe,usecustom, lore,abilities,recipe,custom_ench);
    }
    public void Reload(){
        instance.getConfigDB().Reload();
    }
    public boolean hasPermission(Player player,ItemStack item){
        return instance.getItemHandler().hasPermission(player, item);
    }
    @SuppressWarnings("rawtypes")
    public ArrayList getItemAbilities(ItemStack item){
        return instance.getItemHandler().getItemAbilities(item);
    }
    public boolean isCustom(ItemStack item){
        return instance.getItemHandler().isCustom(item);
    }
    public boolean itemExist(String name){
        return instance.getItemHandler().getItemName().containsKey(name);
    }

    public ItemHandler getItemHandler(){
        return instance.getItemHandler();
    }
}

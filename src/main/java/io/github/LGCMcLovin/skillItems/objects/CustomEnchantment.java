package io.github.LGCMcLovin.skillItems.objects;

import org.bukkit.enchantments.Enchantment;

/**
 * Created by Allen on 3/3/2015.
 */
public class CustomEnchantment {

    private Enchantment ench=null;
    private int level=0;

    public CustomEnchantment(Enchantment e,int l){
        ench=e;
        level=l;
    }

    public Enchantment getEnchantment(){
        return this.ench;
    }
    public int getLevel(){
        return this.level;
    }

}

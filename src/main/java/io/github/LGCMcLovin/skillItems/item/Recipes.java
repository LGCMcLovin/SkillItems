package io.github.LGCMcLovin.skillItems.item;

import io.github.LGCMcLovin.skillItems.SkillItems;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;

/**
 * Created by Allen on 3/3/2015.
 */
public class Recipes {

    private SkillItems instance = null;

    public Recipes(SkillItems i){
        this.instance=i;
    }

    public void setRecipes(ArrayList<Recipe> r){
        Bukkit.getServer().resetRecipes();
        for (Recipe a : r){
            Bukkit.getServer().addRecipe(a);
        }
    }

}

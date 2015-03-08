package io.github.LGCMcLovin.skillItems.util;

import io.github.LGCMcLovin.skillItems.SkillItems;
import org.bukkit.ChatColor;

/**
 * Created by Allen on 3/3/2015.
 */
public class Util {

    public static String edit(String text){
        return ChatColor.GOLD+"[CustomItems] "+ChatColor.WHITE+text;
    }
    public static String editConsole(String text){
        return "[CustomItems] "+text;
    }
    public static void itemError(String text){
        SkillItems.getInstance().getLog().warning(text);
    }
    public static void itemWarning(String text){
        SkillItems.getInstance().getLog().warning(text);
    }

}
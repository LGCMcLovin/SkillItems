package io.github.LGCMcLovin.skillItems.listeners;

import io.github.LGCMcLovin.skillItems.SkillItems;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.Random;

/**
 * Created by Allen on 3/3/2015.
 */
public class BlockListener implements Listener {

    private SkillItems instance=null;

    public BlockListener(SkillItems i){
        instance=i;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (event.getPlayer()!=null){
            if (event.getBlock()!=null){
                if (event.getPlayer().getItemInHand()!=null){
                    if (instance.getItemHandler().hasAbility(event.getPlayer().getItemInHand(), "SuperFortune") && instance.getItemHandler().hasPermission(event.getPlayer(), event.getPlayer().getItemInHand())){
                        int chance=new Random().nextInt(5);
                        if (chance!=0){

                            if (!event.isCancelled())
                            {
                                int i=0;
                                for(i=0;i<=chance;i++){
                                    if (event.getBlock().getDrops()!=null){
                                        if (!event.getBlock().getDrops().isEmpty()){
                                            if (event.getBlock().getDrops().iterator()!=null){
                                                if (event.getBlock().getDrops().iterator().hasNext()){
                                                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),event.getBlock().getDrops().iterator().next());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event)
    {
        if (event.getPlayer()!=null){
            if (event.getBlock()!=null){
                if (event.getPlayer().getItemInHand()!=null){
                    if(instance.getItemHandler().hasAbility(event.getPlayer().getItemInHand(), "Break") && instance.getItemHandler().hasPermission(event.getPlayer(), event.getPlayer().getItemInHand())){
                        if(event.getBlock().getType()!= Material.BEDROCK){
                            event.setInstaBreak(true);
                        }
                    }
                }
            }

        }

    }

}


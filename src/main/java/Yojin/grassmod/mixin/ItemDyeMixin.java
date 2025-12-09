package Yojin.grassmod.mixin;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import Yojin.grassmod.GrassBlock;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import java.util.Random;

@Mixin(value = ItemDye.class,remap = false)
public class ItemDyeMixin {
    
    // String methodSignature = "onUseItemOnBlock"
//       public boolean onUseItemOnBlock(
//       @NotNull ItemStack itemstack,
//       @Nullable Player player,
//       @NotNull World world,
//       int blockX,
//       int blockY,
//       int blockZ,
//       @NotNull Side side,
//       double xPlaced,
//       double yPlaced
    
    
    @Redirect(method="onUseItemOnBlock",at=@At(value="INVOKE",target = "Lnet/minecraft/core/world/World;setBlockWithNotify(IIII)Z",ordinal = 3))
    public boolean onUseItemOnBlock(World world,int x,int y, int z, int id){
        System.out.println("Placing blocks");
        if(world.isRetro() || world.getBlockId(x, y-1, z) == Blocks.GRASS_RETRO.id()){


            return world.setBlockWithNotify(x, y, z, GrassBlock.Retrotallgrass.id());
        }
        return world.setBlockWithNotify(x, y, z, id);
        
        
    }
    
    
    
    
}

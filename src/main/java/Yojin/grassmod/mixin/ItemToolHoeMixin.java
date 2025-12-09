package Yojin.grassmod.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import Yojin.grassmod.GrassBlock;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.tool.ItemToolHoe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

@Mixin(value=ItemToolHoe.class, remap = false)
public abstract class ItemToolHoeMixin {
    
    @Inject(method = "onBlockDestroyed", at = @At(value="HEAD"),locals = LocalCapture.CAPTURE_FAILHARD)
    private void curseTheBTADevs(World world, ItemStack itemStack, int id, int x, int y, int z, Side side, Mob mob,CallbackInfoReturnable ci){
        if(mob != null && !mob.world.isClientSide && (id == GrassBlock.Retrotallgrass.id())){
            if(((ItemToolHoe) (Object) this).getMaterial().isSilkTouch()){
                mob.world.dropItem(x, y, z, new ItemStack(Item.itemsList[id]));
                itemStack.damageItem(1, mob);
            }
            else if (mob.world.rand.nextInt(4) == 0){
                mob.world.dropItem(x, y, z, new ItemStack(Items.SEEDS_WHEAT));
                itemStack.damageItem(1, mob);
            }
            
        }    
        
    }
    
    
    
}

package Yojin.grassmod.mixin;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.Block;
import Yojin.grassmod.Grassmod;
import Yojin.grassmod.GrassBlock;
import net.minecraft.core.block.BlockLogicGrass;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.core.world.World;
import java.util.Random;
















@Mixin(value= BlockLogicGrass.class,remap=false)
public class BlockGrassMixin {
    @ModifyVariable(method="updateTick",at=@At(value="LOAD"),name="idToSpawn")
    private int updateId(int id, World world, int x, int y, int z, Random rand) {

        if (!(id == Blocks.TALLGRASS.id() && rand.nextInt(2) == 0)) return id;
        Biome biome = world.getBlockBiome(x,y,z);
        if (biome == Biomes.OVERWORLD_TAIGA ||
                biome == Biomes.OVERWORLD_TUNDRA ||
                biome == Biomes.OVERWORLD_GLACIER ||
                biome == Biomes.OVERWORLD_BOREAL_FOREST ||
                biome == Biomes.PARADISE_PARADISE ||
                biome == Biomes.OVERWORLD_RETRO ||
                biome == Biomes.OVERWORLD_SEASONAL_FOREST ||
                biome == Biomes.OVERWORLD_FOREST ||
                biome == Biomes.OVERWORLD_RAINFOREST ||
                biome == Biomes.OVERWORLD_SWAMPLAND ||
                biome == Biomes.OVERWORLD_GRASSLANDS ||
                biome == Biomes.OVERWORLD_OUTBACK ||
                biome == Biomes.OVERWORLD_SHRUBLAND ||
                biome == Biomes.OVERWORLD_DESERT ||
                biome == Biomes.NETHER_NETHER ||
                biome == Biomes.OVERWORLD_BIRCH_FOREST ||
                biome == Biomes.OVERWORLD_HELL||
                biome == Biomes.OVERWORLD_SWAMPLAND_MUDDY||
                biome == Biomes.OVERWORLD_OUTBACK_GRASSY ||
                biome == Biomes.OVERWORLD_CAATINGA ||
                biome == Biomes.OVERWORLD_CAATINGA_PLAINS ||

                biome == Biomes.OVERWORLD_MEADOW) {


            return GrassBlock.Retrotallgrass.id();
        }

        return id;
    }
}



package Yojin.grassmod;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicTallGrass;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static Yojin.grassmod.Grassmod.MOD_ID; // need to static because it is just one variable
import static Yojin.grassmod.Grassmod.LOGGER; // same


public class GrassBlock {

	private static int startingID = GrassConfig.CFG.getInt("IDs.startingBlockID");
	private static int nextID() {return startingID++;}


	public static Block<?> Retrotallgrass ;
	public static Block<? extends BlockLogic> blocklogicGrass;

	public static void initBlocks() {

		BlockBuilder grass_builder = new BlockBuilder(MOD_ID)

			// Setting properties of the block. Check the possible properties: Ctrl + LeftClick in BlockBuilder
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setLuminance(0)

			// Sets the block tags (the game uses it to interact with the block). Check the possible tags: Ctrl + LeftClick in BlockTags
			.setTags(new Tag[]{BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.PLACE_OVERWRITES});
		Retrotallgrass = grass_builder.build("block.Retrotallgrass", "block/Retrotallgrass", nextID(), (b) -> new BlockLogicRetroGrass(b)).withSound(BlockSounds.GRASS);


		LOGGER.info("Blocks initialized.");
	}
}


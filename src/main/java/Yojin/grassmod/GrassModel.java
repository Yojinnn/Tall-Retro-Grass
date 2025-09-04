package Yojin.grassmod;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelDispatcher;

import net.minecraft.client.render.item.model.ItemModelDispatcher;



import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;



import static Yojin.grassmod.Grassmod.MOD_ID;
import static Yojin.grassmod.Grassmod.LOGGER;

import static Yojin.grassmod.GrassBlock.*;


public class GrassModel implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) 	{

		ModelHelper.setBlockModel(Retrotallgrass, () -> new BlockModelCrossedSquares<>(Retrotallgrass)
			.setTex(0, MOD_ID + ":block/Tall_grass", Side.sides)
		);

		LOGGER.info("Block Models initialized.");
	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}



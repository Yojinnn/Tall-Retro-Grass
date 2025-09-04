package Yojin.grassmod;

import static Yojin.grassmod.GrassBlock.*;
import static Yojin.grassmod.Grassmod.LOGGER;
import static Yojin.grassmod.Grassmod.MOD_ID;

import net.minecraft.core.item.ItemStack;

import net.minecraft.core.block.Blocks;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class GrassRecipe implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {

		// Crafting recipe
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Blocks.LEAVES_OAK_RETRO)
			.addInput(Blocks.TALLGRASS)
			.create("Retrotallgrass", new ItemStack(Retrotallgrass, 1));

		LOGGER.info("Recipes initialized.");
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

}

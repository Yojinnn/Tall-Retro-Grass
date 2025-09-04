package Yojin.grassmod;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFlower;
import net.minecraft.core.block.BlockLogicMoss;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;




public class BlockLogicRetroGrass extends BlockLogicFlower {
	public BlockLogicRetroGrass(Block<?> block) {
		super(block);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0, 0.5F - f, 0.5F + f, 0.800000011920929, 0.5F + f);
		block.withOverrideColor(MaterialColor.grass);
	}

	protected boolean mayPlaceOn(int blockId) {
		Block<?> block = Blocks.getBlock(blockId);
		return block != null && block.getLogic() instanceof BlockLogicMoss ? true : super.mayPlaceOn(blockId);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case SILK_TOUCH:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return null;
		}
	}
}

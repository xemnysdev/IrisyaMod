package fr.irisya.irisyamod.items.blocks;

import javax.annotation.Nonnull;

import fr.irisya.irisyamod.lib.LibResources;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMod extends ItemBlock
{
	public ItemBlockMod(Block block) 
	{
		super(block);
	}

	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) 
	{
		return getUnlocalizedNameInefficiently_(par1ItemStack).replaceAll("tile.", "tile." + LibResources.PREFIX_MOD);
	}

	public String getUnlocalizedNameInefficiently_(ItemStack stack) 
	{
		return super.getUnlocalizedNameInefficiently(stack);
	}
}

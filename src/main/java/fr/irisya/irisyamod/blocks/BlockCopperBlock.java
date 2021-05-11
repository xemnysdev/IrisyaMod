package fr.irisya.irisyamod.blocks;

import fr.irisya.irisyamod.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlockCopperBlock extends BlockMod
{
	public BlockCopperBlock() 
	{
		super(Material.IRON, LibBlockNames.COPPER_BLOCK);
		setHardness(5.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		MinecraftForge.EVENT_BUS.register(BlockCopperBlock.class);
	}
}

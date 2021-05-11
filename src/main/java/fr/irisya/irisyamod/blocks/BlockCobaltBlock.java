package fr.irisya.irisyamod.blocks;

import fr.irisya.irisyamod.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlockCobaltBlock extends BlockMod
{
	public BlockCobaltBlock() 
	{
		super(Material.IRON, LibBlockNames.COBALT_BLOCK);
		setHardness(5.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		MinecraftForge.EVENT_BUS.register(BlockCobaltBlock.class);
	}
}

package fr.irisya.irisyamod.blocks.ores;

import fr.irisya.irisyamod.blocks.BlockMod;
import fr.irisya.irisyamod.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlockCobaltOre extends BlockMod 
{
	public BlockCobaltOre() 
	{
		super(Material.ROCK, LibBlockNames.COBALT_ORE);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		MinecraftForge.EVENT_BUS.register(BlockCobaltOre.class);
	}
}

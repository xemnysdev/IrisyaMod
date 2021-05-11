package fr.irisya.irisyamod.blocks.ores;

import fr.irisya.irisyamod.blocks.BlockMod;
import fr.irisya.irisyamod.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlockTinOre extends BlockMod 
{
	public BlockTinOre() 
	{
		super(Material.ROCK, LibBlockNames.TIN_ORE);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		MinecraftForge.EVENT_BUS.register(BlockTinOre.class);
	}
}

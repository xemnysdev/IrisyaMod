package fr.irisya.irisyamod.world;

import java.util.Random;

import fr.irisya.irisyamod.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator
{
	private WorldGenerator silver_ore, cobalt_ore, irisium_ore, copper_ore, tin_ore, manganese_ore, pyrite_ore;
	
	public WorldGen()
	{
		silver_ore = new WorldGenMinable(ModBlocks.silver_ore.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));
		cobalt_ore = new WorldGenMinable(ModBlocks.cobalt_ore.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		irisium_ore = new WorldGenMinable(ModBlocks.irisium_ore.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		
		copper_ore = new WorldGenMinable(ModBlocks.copper_ore.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));
		tin_ore = new WorldGenMinable(ModBlocks.tin_ore.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		manganese_ore = new WorldGenMinable(ModBlocks.manganese_ore.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		pyrite_ore = new WorldGenMinable(ModBlocks.pyrite_ore.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension()) 
		{
		case -1:
			break;
		case 0:
			runGenerator(silver_ore, world, random, chunkX, chunkZ, 8, 2, 20);
			runGenerator(cobalt_ore, world, random, chunkX, chunkZ, 6, 2, 15);
			runGenerator(irisium_ore, world, random, chunkX, chunkZ, 4, 2, 10);
			
			runGenerator(copper_ore, world, random, chunkX, chunkZ, 6, 2, 20);
			runGenerator(tin_ore, world, random, chunkX, chunkZ, 5, 2, 15);
			runGenerator(manganese_ore, world, random, chunkX, chunkZ, 4, 2, 10);
			runGenerator(pyrite_ore, world, random, chunkX, chunkZ, 3, 2, 10);
			break;
		case 1:
			break;
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}

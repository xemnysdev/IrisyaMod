package fr.irisya.irisyamod.blocks.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.irisya.irisyamod.init.ModItems;
import fr.irisya.irisyamod.render.IModelRegister;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGalaxiteCrop extends BlockBaseCrop implements IModelRegister
{
	public BlockGalaxiteCrop(String name, int tier)
	{
		super(name);
	}

	@Override
	protected Item getSeed()
	{
		return ModItems.galaxite_seed;
	}
	
	@Override
	protected Item getCrop() 
	{
		return ModItems.galaxine_shard;
	}
	
	@SuppressWarnings({ "unused" })
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) 
	{
		List<ItemStack> drops = new ArrayList<ItemStack>();
		int age = state.getValue(AGE);
		Random rand = ((World)world).rand;
		int essence = 0;
		int seeds = 1;
		if(age == 7)
		{
			if(20 > 0)
			{
				if(rand.nextInt(300 / 20) > 0)
				{
					seeds = 0;
				} 
				else 
				{
					seeds = 1;
				}
			} 
			else 
			{
				seeds = 0;
			}
		}
		if(age == 7)
		{
			if(5 > 0)
			{
				if(rand.nextInt(1000 / 5) > 0)
				{
					essence = 0;
				} 
				else 
				{
					essence = 1;
				}           		
			}
			else essence = 0;
		}

		drops.add(new ItemStack(this.getSeed(), seeds, 0));
		if(essence > 0)
		{ 
			drops.add(new ItemStack(this.getCrop(), essence, 0)); 
		}
		return drops;
	}
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return false;
    }
}

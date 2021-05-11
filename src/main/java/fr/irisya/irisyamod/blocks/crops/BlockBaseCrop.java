package fr.irisya.irisyamod.blocks.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.irisya.irisyamod.handler.ModelHandler;
import fr.irisya.irisyamod.render.IModelRegister;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBaseCrop extends BlockCrops implements IModelRegister
{
	private static final AxisAlignedBB CROPS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
	private Item seed;
	private Item crop;
	private Item ores;
	
	public BlockBaseCrop(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setSoundType(SoundType.PLANT);
		this.disableStats();
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		this.checkAndDropBlock(world, pos, state);
		int i = this.getAge(state);
		if(world.getLightFromNeighbors(pos.up()) >= 9)
		{
			if(i < this.getMaxAge())
			{
				float f = getGrowthChance(this, world, pos);
				if (rand.nextInt((int)(35.0F / f) + 1) == 0) 
				{
					world.setBlockState(pos, this.withAge(i + 1), 2);
				}
			}
		}
	}
	
	protected boolean canSustainBush(IBlockState state)
	{
		return state.getBlock() == Blocks.FARMLAND;
	}

	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
	{
		return true;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Crop;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return CROPS_AABB;
	}

	public BlockBaseCrop setSeed(Item seed)
	{
		this.seed = seed;
		return this;
	}

	@Override
	protected Item getSeed()
	{
		return this.seed;
	}

	public BlockBaseCrop setCrop(Item crop)
	{
		this.crop = crop;
		return this;
	}

	@Override
	protected Item getCrop() 
	{
		return this.crop;
	}
	
	public BlockBaseCrop setOres(Item ores)
	{
		this.ores = ores;
		return this;
	}

	protected Item getOres()
	{
		return this.ores;
	}

	@SuppressWarnings("unused")
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> drops = new ArrayList<ItemStack>();

		int age = state.getValue(AGE);
		Random rand = ((World)world).rand;
		int essence = 0;
		int fertilizer = 0;
		int seeds = 1;
		int ores = 0;
		if(age == 7)
		{
			if(10 > 0)
			{
				if(rand.nextInt(100 / 10) > 0)
				{
					seeds = 1;	
				} 
				else 
				{
					seeds = 2;
				}
			}
			else {
				seeds = 1;
			}
		}

		if(age == 7)
		{
			if(5 > 0)
			{
				if(rand.nextInt(100 / 5) > 0)
				{
					fertilizer = 0;
				} 
				else 
				{
					fertilizer = 1;
				}
			} 
			else fertilizer = 0;
		}
		if(age == 7)
		{
			if(5 > 0)
			{
				if(rand.nextInt(100 / 5) > 0)
				{
					essence = 1;
				} 
				else 
				{
					essence = 2;
				}           		
			}
			else essence = 1;
		}
		if(age == 7)
		{
			if(5 > 0)
			{
				if(rand.nextInt(100 / 5) > 0)
				{
					ores = 1;
				} 
				else 
				{
					ores = 0;
				}           		
			}
			else ores = 1;
		}

		drops.add(new ItemStack(this.getSeed(), seeds, 0));
		if(essence > 0){ drops.add(new ItemStack(this.getCrop(), essence, 0)); }
		if(ores > 0){ drops.add(new ItemStack(this.getOres(), ores, 0)); }
		return drops;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() 
	{
		if(Item.getItemFromBlock(this) != Items.AIR)
			ModelHandler.registerBlockToState(this, 0, getDefaultState());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) 
	{
		super.eventReceived(state, world, pos, id, param);
		TileEntity tileentity = world.getTileEntity(pos);
		return tileentity != null && tileentity.receiveClientEvent(id, param);
	}
}

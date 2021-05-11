package fr.irisya.irisyamod.blocks;

import java.util.Random;

import fr.irisya.irisyamod.init.ModBlocks;
import fr.irisya.irisyamod.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockFertilizedDirt extends BlockMod
{
	boolean tilled;
	protected static final AxisAlignedBB TILLED_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);

	public BlockFertilizedDirt(boolean tilled) 
	{
		super(Material.GROUND, LibBlockNames.FERTILIZED_DIRT + (tilled ? "Tilled" : ""));
		this.tilled = tilled;
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		this.setSoundType(SoundType.GROUND);
		if (tilled)
		{
			this.setLightOpacity(255);
			this.setCreativeTab(null);
			this.useNeighborBrightness = true;
		}
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(ModBlocks.fertilized_dirt);
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
	{
		if (!tilled)
		{
			super.getSubBlocks(tab, list);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		if (tilled)
		{
			return TILLED_AABB;
		}
		else
		{
			return super.getBoundingBox(state, source, pos);
		}
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(ModBlocks.fertilized_dirt, 1, 0);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "tile.fertilizedDirt";
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return FULL_BLOCK_AABB;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.fertilized_dirt);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return !tilled;
	}

	@Override
	public boolean isFertile(World world, BlockPos pos)
	{
		return true;
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
	{
		EnumPlantType plantType = plantable.getPlantType(world, pos.up());

		switch (plantType)
		{
		case Desert:
			return !tilled;
		case Nether:
			return false;
		case Crop:
			return tilled;
		case Cave:
			return !tilled;
		case Plains:
			return !tilled || tilled && world.getBlockState(pos.up()).getBlock() == Blocks.BEETROOTS;
		case Water:
			return false;
		case Beach:
			return !tilled;
		}

		return false;
	}

	@Override
	public void updateTick(World worldObj, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldObj.isRemote)
		{
			IBlockState plantState = worldObj.getBlockState(pos.up());
			Block toBoost = plantState.getBlock();
			for (int i = 0; i < 3; i++)
			{
				plantState = worldObj.getBlockState(pos.up());
				toBoost = plantState.getBlock();
				if (plantState != null && toBoost != null && toBoost != Blocks.AIR && toBoost instanceof IPlantable)
				{
					toBoost.updateTick(worldObj, pos.up(), plantState, rand);
				}
			}
		}
	}
}

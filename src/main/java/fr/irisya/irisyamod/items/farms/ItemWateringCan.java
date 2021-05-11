package fr.irisya.irisyamod.items.farms;

import java.util.Random;

import fr.irisya.irisyamod.init.ModBlocks;
import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import fr.irisya.irisyamod.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;

public class ItemWateringCan extends ItemMod
{
	private boolean water = false;
	private long ticks;
	
	public ItemWateringCan()
	{
		super(LibItemNames.WATERING_CAN);
		this.setMaxStackSize(1);
		MinecraftForge.EVENT_BUS.register(ItemWateringCan.class);
	}
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
	{
    	if(selected)
    	{
    		ticks++;
    		if(ticks % 10 == 0)
    		{
    			water = true;
    		}
    	}
    }
	
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
	{
        return EnumAction.NONE;
    }
	
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	ItemStack stack = player.getHeldItem(hand);
		if(!player.canPlayerEdit(pos.offset(facing), facing, stack)){
			return EnumActionResult.FAIL;
	    }
		
		int range = stack.getMetadata();
		
    	Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(-range, -range, -range), pos.add(range, range, range));
    	for(BlockPos aoePos : blocks){
    		IBlockState aoeState = world.getBlockState(aoePos);
    		if(aoeState.getBlock() instanceof BlockFarmland)
    		{
    			int moisture =  aoeState.getValue(BlockFarmland.MOISTURE);
    			if(moisture < 7)
    			{
    				world.setBlockState(aoePos, aoeState.withProperty(BlockFarmland.MOISTURE, 7), 2);
    			}
    		}
    	}
		
		Random rand = new Random();
		for(int x = -range; x <= range; x++)
		{
			for(int z = -range; z <= range; z++)
			{
				double d0 = pos.add(x, 0, z).getX() + rand.nextFloat();
				double d1 = pos.add(x, 0, z).getY() + 1.0D;
				double d2 = pos.add(x, 0, z).getZ() + rand.nextFloat();
		      
				IBlockState state = world.getBlockState(pos);
				if((state.isFullCube()) || ((state.getBlock() instanceof BlockFarmland)))
				{
					d1 += 0.3D;
				}
				world.spawnParticle(EnumParticleTypes.WATER_DROP, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[5]);
			}
		}
		
	    if(!world.isRemote && water)
	    {
	    	water = false;
	    	int chance = Utils.randInt(1, 100);
	    	int bonus = 6 * stack.getMetadata();
	        if(chance <= (60 + bonus))
	        {
	        	for(BlockPos aoePos : blocks)
	        	{
	        		Block plant = world.getBlockState(aoePos).getBlock();	        		
	        		if(plant instanceof IGrowable || plant instanceof IPlantable || plant == Blocks.MYCELIUM || plant == Blocks.CHORUS_FLOWER || plant == ModBlocks.silverite_crop || plant == ModBlocks.cobaltine_crop
	        				|| plant == ModBlocks.irisite_crop || plant == ModBlocks.galaxite_crop || plant == ModBlocks.oats_crop || plant == ModBlocks.rye_crop || plant == ModBlocks.rice_crop || plant == ModBlocks.corn_crop)
	        		{
	        			world.scheduleBlockUpdate(aoePos, plant, 0, 1000);
	        		}
	        	}
	        	return EnumActionResult.FAIL;
	        }
	    }
	    return EnumActionResult.FAIL;
    }
}

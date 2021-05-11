package fr.irisya.irisyamod.items;

import fr.irisya.irisyamod.blocks.crops.BlockCobaltineCrop;
import fr.irisya.irisyamod.blocks.crops.BlockGalaxiteCrop;
import fr.irisya.irisyamod.blocks.crops.BlockIrisiteCrop;
import fr.irisya.irisyamod.blocks.crops.BlockSilveriteCrop;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemFertilizers extends ItemMod
{
	public ItemFertilizers() 
	{
		super(LibItemNames.FERTILIZERS);
		MinecraftForge.EVENT_BUS.register(ItemFertilizers.class);
	}
	
	public static boolean applyFertilizer(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, EnumHand hand)
	{
        IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
        if(hook != 0) return hook > 0;

        if(iblockstate.getBlock() instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)iblockstate.getBlock();

            if(igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote)){
                if(!worldIn.isRemote){
                    if(igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate) || iblockstate.getBlock() instanceof BlockSilveriteCrop || iblockstate.getBlock() instanceof BlockCobaltineCrop || iblockstate.getBlock() instanceof BlockIrisiteCrop
                    		|| iblockstate.getBlock() instanceof BlockGalaxiteCrop)
                    {
                    	igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                    }
                    stack.shrink(1);
                }
                return true;
            }
        }
        return false;
    }
	
    @Override
    public EnumActionResult onItemUse(EntityPlayer stack, World playerIn, BlockPos worldIn, EnumHand pos, EnumFacing hand, float facing, float hitX, float hitY)
    {
        ItemStack itemstack = stack.getHeldItem(pos);

        if(!stack.canPlayerEdit(worldIn.offset(hand), hand, itemstack)){
            return EnumActionResult.FAIL;
        } 
        else 
        {
        	if (applyFertilizer(itemstack, playerIn, worldIn, stack, pos)){
        		if (!playerIn.isRemote)
        		{
        			playerIn.playEvent(2005, worldIn, 0);
        		}
        		return EnumActionResult.SUCCESS;
        	}
        }
        return EnumActionResult.PASS;
    }
}

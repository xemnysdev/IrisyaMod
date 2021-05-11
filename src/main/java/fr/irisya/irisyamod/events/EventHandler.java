package fr.irisya.irisyamod.events;

import fr.irisya.irisyamod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler 
{
	@SubscribeEvent
	public void useHoe(UseHoeEvent event)
	{
		IBlockState state = event.getWorld().getBlockState(event.getPos());
		Block block = state.getBlock();
		if (block == ModBlocks.fertilized_dirt)
		{
			event.setResult(Result.ALLOW);
			event.getWorld().setBlockState(event.getPos(), ModBlocks.fertilized_dirt_tilled.getDefaultState());
			event.getWorld().playSound(null, event.getPos().add(0.5, 0.5, 0.5), ModBlocks.fertilized_dirt_tilled.getSoundType().getStepSound(), SoundCategory.BLOCKS, (ModBlocks.fertilized_dirt_tilled.getSoundType().getVolume() + 1.0F) / 2.0F, ModBlocks.fertilized_dirt_tilled.getSoundType().getPitch() * 0.8F);
		}
	}
}

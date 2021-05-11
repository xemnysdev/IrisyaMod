package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ItemGalaxineShard extends ItemMod 
{
	public ItemGalaxineShard() 
	{
		super(LibItemNames.GALAXINE_SHARD);
		MinecraftForge.EVENT_BUS.register(ItemGalaxineShard.class);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.RARE;
	}
}

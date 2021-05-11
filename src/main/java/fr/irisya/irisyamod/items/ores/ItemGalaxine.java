package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ItemGalaxine extends ItemMod 
{
	public ItemGalaxine() 
	{
		super(LibItemNames.GALAXINE);
		MinecraftForge.EVENT_BUS.register(ItemGalaxine.class);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.RARE;
	}
}

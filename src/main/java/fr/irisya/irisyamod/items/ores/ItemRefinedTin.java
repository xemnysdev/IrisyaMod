package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRefinedTin extends ItemMod 
{
	public ItemRefinedTin() 
	{
		super(LibItemNames.REFINED_TIN);
		MinecraftForge.EVENT_BUS.register(ItemRefinedTin.class);
	}
}

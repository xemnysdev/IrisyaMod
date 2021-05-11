package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRefinedManganese extends ItemMod 
{
	public ItemRefinedManganese() 
	{
		super(LibItemNames.REFINED_MANGANESE);
		MinecraftForge.EVENT_BUS.register(ItemRefinedManganese.class);
	}
}

package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemManganese extends ItemMod
{
	public ItemManganese() 
	{
		super(LibItemNames.MANGANESE);
		MinecraftForge.EVENT_BUS.register(ItemManganese.class);
	}
}

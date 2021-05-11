package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemCobalt extends ItemMod 
{
	public ItemCobalt() 
	{
		super(LibItemNames.COBALT);
		MinecraftForge.EVENT_BUS.register(ItemCobalt.class);
	}
}

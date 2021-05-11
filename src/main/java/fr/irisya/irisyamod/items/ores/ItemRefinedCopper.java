package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRefinedCopper extends ItemMod 
{
	public ItemRefinedCopper() 
	{
		super(LibItemNames.REFINED_COPPER);
		MinecraftForge.EVENT_BUS.register(ItemRefinedCopper.class);
	}
}

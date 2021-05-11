package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRefinedPyrite extends ItemMod 
{
	public ItemRefinedPyrite() 
	{
		super(LibItemNames.REFINED_PYRITE);
		MinecraftForge.EVENT_BUS.register(ItemRefinedPyrite.class);
	}
}

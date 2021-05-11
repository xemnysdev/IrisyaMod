package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemPyrite extends ItemMod
{
	public ItemPyrite() 
	{
		super(LibItemNames.PYRITE);
		MinecraftForge.EVENT_BUS.register(ItemPyrite.class);
	}
}

package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemCopper extends ItemMod 
{
	public ItemCopper() 
	{
		super(LibItemNames.COPPER);
		MinecraftForge.EVENT_BUS.register(ItemCopper.class);
	}
}

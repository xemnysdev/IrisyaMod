package fr.irisya.irisyamod.items.farms;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemOats extends ItemMod 
{
	public ItemOats() 
	{
		super(LibItemNames.OATS);
		MinecraftForge.EVENT_BUS.register(ItemOats.class);
	}
}

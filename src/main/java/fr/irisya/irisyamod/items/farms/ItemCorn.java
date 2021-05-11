package fr.irisya.irisyamod.items.farms;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemCorn extends ItemMod  
{
	public ItemCorn() 
	{
		super(LibItemNames.CORN);
		MinecraftForge.EVENT_BUS.register(ItemCorn.class);
	}
}

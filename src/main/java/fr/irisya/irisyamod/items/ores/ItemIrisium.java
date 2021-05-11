package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemIrisium extends ItemMod 
{
	public ItemIrisium() 
	{
		super(LibItemNames.IRISIUM);
		MinecraftForge.EVENT_BUS.register(ItemIrisium.class);
	}
}

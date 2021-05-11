package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemSilver extends ItemMod 
{
	public ItemSilver() 
	{
		super(LibItemNames.SILVER);
		MinecraftForge.EVENT_BUS.register(ItemSilver.class);
	}
}

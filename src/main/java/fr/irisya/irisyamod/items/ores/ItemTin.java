package fr.irisya.irisyamod.items.ores;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemTin extends ItemMod
{
	public ItemTin() 
	{
		super(LibItemNames.TIN);
		MinecraftForge.EVENT_BUS.register(ItemTin.class);
	}
}

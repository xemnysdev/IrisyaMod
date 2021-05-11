package fr.irisya.irisyamod.items.farms;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRye extends ItemMod  
{
	public ItemRye() 
	{
		super(LibItemNames.RYE);
		MinecraftForge.EVENT_BUS.register(ItemRye.class);
	}
}

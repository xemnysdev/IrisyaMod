package fr.irisya.irisyamod.items.farms;

import fr.irisya.irisyamod.items.ItemMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraftforge.common.MinecraftForge;

public class ItemRice extends ItemMod  
{
	public ItemRice() 
	{
		super(LibItemNames.RICE);
		MinecraftForge.EVENT_BUS.register(ItemRice.class);
	}
}

package fr.irisya.irisyamod.tabs;

import fr.irisya.irisyamod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IrisyaTab extends CreativeTabs
{
	public IrisyaTab(String label) 
	{
		super(label);
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.irisium);
	}
}

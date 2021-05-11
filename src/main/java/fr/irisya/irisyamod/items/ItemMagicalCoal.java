package fr.irisya.irisyamod.items;

import fr.irisya.irisyamod.lib.LibItemNames;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMagicalCoal extends ItemMod  
{
	public ItemMagicalCoal() 
	{
		super(LibItemNames.MAGICAL_COAL);
		MinecraftForge.EVENT_BUS.register(ItemMagicalCoal.class);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.COMMON;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}

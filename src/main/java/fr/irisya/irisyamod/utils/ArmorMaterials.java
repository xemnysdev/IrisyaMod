package fr.irisya.irisyamod.utils;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials 
{
	public static ArmorMaterial armorSilver;
	public static ArmorMaterial armorCobalt;
	public static ArmorMaterial armorIrisium;
	public static ArmorMaterial armorGalaxine;
	
	public static void init() 
	{
		armorSilver = EnumHelper.addArmorMaterial("silverArmor",References.MODID + ":silver", 100, new int[] {4, 7, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
		armorCobalt = EnumHelper.addArmorMaterial("cobaltArmor", References.MODID + ":cobalt", 105, new int[] {5, 8, 10, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
		armorIrisium = EnumHelper.addArmorMaterial("irisiumArmor", References.MODID + ":irisium", 110, new int[] {6, 9, 11, 6}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F);
		armorGalaxine = EnumHelper.addArmorMaterial("galaxineArmor", References.MODID + ":galaxine", 120, new int[] {7, 10, 12, 7}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);
	}
}

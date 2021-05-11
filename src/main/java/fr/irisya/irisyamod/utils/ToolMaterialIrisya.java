package fr.irisya.irisyamod.utils;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialIrisya 
{
	public static ToolMaterial toolTypeSilver;
	public static ToolMaterial toolTypeCobalt;
	public static ToolMaterial toolTypeIrisium;
	public static ToolMaterial toolTypeGalaxine;
	
	public static ToolMaterial hammerTypeSilver;
	public static ToolMaterial hammerTypeCobalt;
	public static ToolMaterial hammerTypeIrisium;
	
	public static void init() 
	{
		toolTypeSilver = EnumHelper.addToolMaterial("silverTool", 3, 1999, 20.0F, 4.0F, 20);
		toolTypeCobalt = EnumHelper.addToolMaterial("cobaltTool", 3, 2999, 23.0F, 5.0F, 25);
		toolTypeIrisium = EnumHelper.addToolMaterial("irisiumTool", 3, 3999, 30.0F, 6.0F, 35);
		toolTypeGalaxine = EnumHelper.addToolMaterial("galaxineTool", 3, 4999, 35.0F, 7.0F, 30);
		
		hammerTypeSilver = EnumHelper.addToolMaterial("silverTool", 2, 1999, 4.0F, 1.0F, 20);
		hammerTypeCobalt = EnumHelper.addToolMaterial("cobaltTool", 2, 2999, 6.0F, 2.0F, 20);
		hammerTypeIrisium = EnumHelper.addToolMaterial("irisiumTool", 3, 3999, 8.0F, 3.0F, 25);
	}
}

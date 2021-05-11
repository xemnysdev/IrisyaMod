package fr.irisya.irisyamod.items.armors;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.render.IModelRegister;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCobaltArmor extends ItemArmor implements IModelRegister
{
	public ItemCobaltArmor(String name, ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndexIn, equipmentSlotIn);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(IrisyaMod.IRISYA_TAB);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() 
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}

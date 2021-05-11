package fr.irisya.irisyamod.items.armors;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.render.IModelRegister;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIrisiumLeggArmor extends ItemArmor implements IModelRegister 
{
	public ItemIrisiumLeggArmor(String name, ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndexIn, equipmentSlotIn);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(IrisyaMod.IRISYA_TAB);
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
    {
         if (itemStack.getItem() == this)
         {
        	 player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("strength"), 100, 0));
         }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() 
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}

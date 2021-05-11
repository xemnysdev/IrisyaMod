package fr.irisya.irisyamod.items.weapons;

import javax.annotation.Nonnull;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import fr.irisya.irisyamod.lib.LibResources;
import fr.irisya.irisyamod.render.IModelRegister;
import fr.irisya.irisyamod.utils.References;
import fr.irisya.irisyamod.utils.ToolMaterialIrisya;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSilverSword extends ItemSword implements IModelRegister
{
	public ItemSilverSword()
	{
		this(ToolMaterialIrisya.toolTypeSilver, LibItemNames.SILVER_SWORD);
	}
	
	public ItemSilverSword(ToolMaterial mat, String name) 
	{
		super(mat);
		setCreativeTab(IrisyaMod.IRISYA_TAB);
		setRegistryName(new ResourceLocation(References.MODID, name));
		setUnlocalizedName(name);
	}
	
	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) 
	{
		return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item.", "item." + LibResources.PREFIX_MOD);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() 
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}

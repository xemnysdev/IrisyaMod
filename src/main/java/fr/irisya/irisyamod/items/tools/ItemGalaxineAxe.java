package fr.irisya.irisyamod.items.tools;

import javax.annotation.Nonnull;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.lib.LibItemNames;
import fr.irisya.irisyamod.lib.LibResources;
import fr.irisya.irisyamod.render.IModelRegister;
import fr.irisya.irisyamod.utils.References;
import fr.irisya.irisyamod.utils.ToolMaterialIrisya;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGalaxineAxe extends ItemAxe implements IModelRegister
{
	public ItemGalaxineAxe()
	{
		this(ToolMaterialIrisya.toolTypeGalaxine, LibItemNames.GALAXINE_AXE);
	}
	
	public ItemGalaxineAxe(ToolMaterial mat, String name) 
	{
		super(mat, 12.0F, -3.0F);
		setCreativeTab(IrisyaMod.IRISYA_TAB);
		setRegistryName(new ResourceLocation(References.MODID, name));
		setUnlocalizedName(name);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.RARE;
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

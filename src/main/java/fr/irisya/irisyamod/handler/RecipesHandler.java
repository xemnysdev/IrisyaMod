package fr.irisya.irisyamod.handler;

import fr.irisya.irisyamod.init.ModBlocks;
import fr.irisya.irisyamod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesHandler 
{
	public static void registerRecipes()
	{
		GameRegistry.addSmelting(new ItemStack(ModBlocks.silver_ore), new ItemStack(ModItems.silver, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.cobalt_ore), new ItemStack(ModItems.cobalt, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.irisium_ore), new ItemStack(ModItems.irisium, 1), 0.5F);
		
		GameRegistry.addSmelting(new ItemStack(ModBlocks.copper_ore), new ItemStack(ModItems.copper, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.tin_ore), new ItemStack(ModItems.tin, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.manganese_ore), new ItemStack(ModItems.manganese, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.pyrite_ore), new ItemStack(ModItems.pyrite, 1), 0.5F);
	}
}

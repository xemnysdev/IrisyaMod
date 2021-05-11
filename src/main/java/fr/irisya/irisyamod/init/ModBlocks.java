package fr.irisya.irisyamod.init;

import fr.irisya.irisyamod.blocks.BlockCobaltBlock;
import fr.irisya.irisyamod.blocks.BlockCopperBlock;
import fr.irisya.irisyamod.blocks.BlockFertilizedDirt;
import fr.irisya.irisyamod.blocks.BlockIrisiumBlock;
import fr.irisya.irisyamod.blocks.BlockManganeseBlock;
import fr.irisya.irisyamod.blocks.BlockPyriteBlock;
import fr.irisya.irisyamod.blocks.BlockSilverBlock;
import fr.irisya.irisyamod.blocks.BlockTinBlock;
import fr.irisya.irisyamod.blocks.crops.BlockCobaltineCrop;
import fr.irisya.irisyamod.blocks.crops.BlockCornCrop;
import fr.irisya.irisyamod.blocks.crops.BlockGalaxiteCrop;
import fr.irisya.irisyamod.blocks.crops.BlockIrisiteCrop;
import fr.irisya.irisyamod.blocks.crops.BlockOatsCrop;
import fr.irisya.irisyamod.blocks.crops.BlockRiceCrop;
import fr.irisya.irisyamod.blocks.crops.BlockRyeCrop;
import fr.irisya.irisyamod.blocks.crops.BlockSilveriteCrop;
import fr.irisya.irisyamod.blocks.machines.BlockAlloyFabricator;
import fr.irisya.irisyamod.blocks.machines.BlockComposter;
import fr.irisya.irisyamod.blocks.ores.BlockCobaltOre;
import fr.irisya.irisyamod.blocks.ores.BlockCopperOre;
import fr.irisya.irisyamod.blocks.ores.BlockIrisiumOre;
import fr.irisya.irisyamod.blocks.ores.BlockManganeseOre;
import fr.irisya.irisyamod.blocks.ores.BlockPyriteOre;
import fr.irisya.irisyamod.blocks.ores.BlockSilverOre;
import fr.irisya.irisyamod.blocks.ores.BlockTinOre;
import fr.irisya.irisyamod.items.blocks.ItemBlockMod;
import fr.irisya.irisyamod.utils.References;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = References.MODID)
public final class ModBlocks 
{
	//Ores
	public static final Block silver_ore = new BlockSilverOre();
	public static final Block cobalt_ore = new BlockCobaltOre();
	public static final Block irisium_ore = new BlockIrisiumOre();
	//Blocks Ores
	public static final Block silver_block = new BlockSilverBlock();
	public static final Block cobalt_block = new BlockCobaltBlock();
	public static final Block irisium_block = new BlockIrisiumBlock();
	//Crops
	public static final Block oats_crop = new BlockOatsCrop("oats_crop", 1);
	public static final Block rye_crop = new BlockRyeCrop("rye_crop", 2);
	public static final Block rice_crop = new BlockRiceCrop("rice_crop", 3);
	public static final Block corn_crop = new BlockCornCrop("corn_crop", 4);
	//Crops Ores
	public static final Block silverite_crop = new BlockSilveriteCrop("silverite_crop", 5);
	public static final Block cobaltine_crop = new BlockCobaltineCrop("cobaltine_crop", 6);
	public static final Block irisite_crop = new BlockIrisiteCrop("irisite_crop", 7);
	public static final Block galaxite_crop = new BlockGalaxiteCrop("galaxite_crop", 8);
	//Fermers
	public static final Block fertilized_dirt = new BlockFertilizedDirt(false);
	public static final Block fertilized_dirt_tilled = new BlockFertilizedDirt(true);
	public static final Block composter = new BlockComposter("composter");
	//Ores Miner
	public static final Block copper_ore = new BlockCopperOre();
	public static final Block tin_ore = new BlockTinOre();
	public static final Block manganese_ore = new BlockManganeseOre();
	public static final Block pyrite_ore = new BlockPyriteOre();
	//Block Ore Miner
	public static final Block copper_block = new BlockCopperBlock();
	public static final Block tin_block = new BlockTinBlock();
	public static final Block manganese_block = new BlockManganeseBlock();
	public static final Block pyrite_block = new BlockPyriteBlock();
	//Alloy Machine
	public static final Block alloy_fabricator = new BlockAlloyFabricator("alloy_fabricator");
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> evt) 
	{
		IForgeRegistry<Block> r = evt.getRegistry();
		
		//Ores
		r.register(silver_ore);
		r.register(cobalt_ore);
		r.register(irisium_ore);
		//Blocks Ores
		r.register(silver_block);
		r.register(cobalt_block);
		r.register(irisium_block);
		//Crops
		r.register(oats_crop);
		r.register(rye_crop);
		r.register(rice_crop);
		r.register(corn_crop);
		//Crops Ores
		r.register(silverite_crop);
		r.register(cobaltine_crop);
		r.register(irisite_crop);
		r.register(galaxite_crop);
		//Farmers
		r.register(fertilized_dirt);
		r.register(fertilized_dirt_tilled);
		r.register(composter);
		//Ores Miner
		r.register(copper_ore);
		r.register(tin_ore);
		r.register(manganese_ore);
		r.register(pyrite_ore);
		//Block Ore Miner
		r.register(copper_block);
		r.register(tin_block);
		r.register(manganese_block);
		r.register(pyrite_block);
		//Alloy Machine
		r.register(alloy_fabricator);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> evt) 
	{
		IForgeRegistry<Item> r = evt.getRegistry();
		
		//Ores
		r.register(new ItemBlockMod(silver_ore).setRegistryName(silver_ore.getRegistryName()));
		r.register(new ItemBlockMod(cobalt_ore).setRegistryName(cobalt_ore.getRegistryName()));
		r.register(new ItemBlockMod(irisium_ore).setRegistryName(irisium_ore.getRegistryName()));
		//Blocks Ores
		r.register(new ItemBlockMod(silver_block).setRegistryName(silver_block.getRegistryName()));
		r.register(new ItemBlockMod(cobalt_block).setRegistryName(cobalt_block.getRegistryName()));
		r.register(new ItemBlockMod(irisium_block).setRegistryName(irisium_block.getRegistryName()));
		//Crops
		r.register(new ItemBlockMod(oats_crop).setRegistryName(oats_crop.getRegistryName()));
		r.register(new ItemBlockMod(rye_crop).setRegistryName(rye_crop.getRegistryName()));
		r.register(new ItemBlockMod(rice_crop).setRegistryName(rice_crop.getRegistryName()));
		r.register(new ItemBlockMod(corn_crop).setRegistryName(corn_crop.getRegistryName()));
		//Crops Ores
		r.register(new ItemBlockMod(silverite_crop).setRegistryName(silverite_crop.getRegistryName()));
		r.register(new ItemBlockMod(cobaltine_crop).setRegistryName(cobaltine_crop.getRegistryName()));
		r.register(new ItemBlockMod(irisite_crop).setRegistryName(irisite_crop.getRegistryName()));
		r.register(new ItemBlockMod(galaxite_crop).setRegistryName(galaxite_crop.getRegistryName()));
		//Farmers
		r.register(new ItemBlockMod(fertilized_dirt).setRegistryName(fertilized_dirt.getRegistryName()));
		r.register(new ItemBlockMod(fertilized_dirt_tilled).setRegistryName(fertilized_dirt_tilled.getRegistryName()));
		r.register(new ItemBlockMod(composter).setRegistryName(composter.getRegistryName()));
		//Ores Miner
		r.register(new ItemBlockMod(copper_ore).setRegistryName(copper_ore.getRegistryName()));
		r.register(new ItemBlockMod(tin_ore).setRegistryName(tin_ore.getRegistryName()));
		r.register(new ItemBlockMod(manganese_ore).setRegistryName(manganese_ore.getRegistryName()));
		r.register(new ItemBlockMod(pyrite_ore).setRegistryName(pyrite_ore.getRegistryName()));
		//Block Ore Miner
		r.register(new ItemBlockMod(copper_block).setRegistryName(copper_block.getRegistryName()));
		r.register(new ItemBlockMod(tin_block).setRegistryName(tin_block.getRegistryName()));
		r.register(new ItemBlockMod(manganese_block).setRegistryName(manganese_block.getRegistryName()));
		r.register(new ItemBlockMod(pyrite_block).setRegistryName(pyrite_block.getRegistryName()));
		//Alloy Machine
		r.register(new ItemBlockMod(alloy_fabricator).setRegistryName(alloy_fabricator.getRegistryName()));
	}
}

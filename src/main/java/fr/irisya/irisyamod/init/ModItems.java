package fr.irisya.irisyamod.init;

import fr.irisya.irisyamod.items.ItemFertilizers;
import fr.irisya.irisyamod.items.ItemMagicalCoal;
import fr.irisya.irisyamod.items.armors.ItemCobaltArmor;
import fr.irisya.irisyamod.items.armors.ItemGalaxineBootsArmor;
import fr.irisya.irisyamod.items.armors.ItemGalaxineChestArmor;
import fr.irisya.irisyamod.items.armors.ItemGalaxineHelmetArmor;
import fr.irisya.irisyamod.items.armors.ItemGalaxineLeggArmor;
import fr.irisya.irisyamod.items.armors.ItemIrisiumBootsArmor;
import fr.irisya.irisyamod.items.armors.ItemIrisiumChestArmor;
import fr.irisya.irisyamod.items.armors.ItemIrisiumHelmetArmor;
import fr.irisya.irisyamod.items.armors.ItemIrisiumLeggArmor;
import fr.irisya.irisyamod.items.armors.ItemSilverArmor;
import fr.irisya.irisyamod.items.farms.ItemCorn;
import fr.irisya.irisyamod.items.farms.ItemOats;
import fr.irisya.irisyamod.items.farms.ItemRice;
import fr.irisya.irisyamod.items.farms.ItemRye;
import fr.irisya.irisyamod.items.farms.ItemWateringCan;
import fr.irisya.irisyamod.items.ores.ItemCobalt;
import fr.irisya.irisyamod.items.ores.ItemCopper;
import fr.irisya.irisyamod.items.ores.ItemGalaxine;
import fr.irisya.irisyamod.items.ores.ItemGalaxineShard;
import fr.irisya.irisyamod.items.ores.ItemIrisium;
import fr.irisya.irisyamod.items.ores.ItemManganese;
import fr.irisya.irisyamod.items.ores.ItemPyrite;
import fr.irisya.irisyamod.items.ores.ItemRefinedCopper;
import fr.irisya.irisyamod.items.ores.ItemRefinedManganese;
import fr.irisya.irisyamod.items.ores.ItemRefinedPyrite;
import fr.irisya.irisyamod.items.ores.ItemRefinedTin;
import fr.irisya.irisyamod.items.ores.ItemSilver;
import fr.irisya.irisyamod.items.ores.ItemTin;
import fr.irisya.irisyamod.items.seeds.ItemCobaltineSeed;
import fr.irisya.irisyamod.items.seeds.ItemCornSeed;
import fr.irisya.irisyamod.items.seeds.ItemGalaxiteSeed;
import fr.irisya.irisyamod.items.seeds.ItemIrisiteSeed;
import fr.irisya.irisyamod.items.seeds.ItemOatsSeed;
import fr.irisya.irisyamod.items.seeds.ItemRiceSeed;
import fr.irisya.irisyamod.items.seeds.ItemRyeSeed;
import fr.irisya.irisyamod.items.seeds.ItemSilveriteSeed;
import fr.irisya.irisyamod.items.tools.ItemCobaltAxe;
import fr.irisya.irisyamod.items.tools.ItemCobaltPickaxe;
import fr.irisya.irisyamod.items.tools.ItemCobaltShovel;
import fr.irisya.irisyamod.items.tools.ItemGalaxineAxe;
import fr.irisya.irisyamod.items.tools.ItemGalaxinePickaxe;
import fr.irisya.irisyamod.items.tools.ItemHammer;
import fr.irisya.irisyamod.items.tools.ItemIrisiumAxe;
import fr.irisya.irisyamod.items.tools.ItemIrisiumPickaxe;
import fr.irisya.irisyamod.items.tools.ItemIrisiumShovel;
import fr.irisya.irisyamod.items.tools.ItemMultiTool;
import fr.irisya.irisyamod.items.tools.ItemSilverAxe;
import fr.irisya.irisyamod.items.tools.ItemSilverPickaxe;
import fr.irisya.irisyamod.items.tools.ItemSilverShovel;
import fr.irisya.irisyamod.items.weapons.ItemCobaltSword;
import fr.irisya.irisyamod.items.weapons.ItemGalaxineSword;
import fr.irisya.irisyamod.items.weapons.ItemIrisiumSword;
import fr.irisya.irisyamod.items.weapons.ItemSilverSword;
import fr.irisya.irisyamod.utils.ArmorMaterials;
import fr.irisya.irisyamod.utils.References;
import fr.irisya.irisyamod.utils.ToolMaterialIrisya;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = References.MODID)
public final class ModItems 
{
	//Ingots
	public static final Item silver = new ItemSilver();
	public static final Item cobalt = new ItemCobalt();
	public static final Item irisium = new ItemIrisium();
	public static final Item galaxine_shard = new ItemGalaxineShard();
	public static final Item galaxine = new ItemGalaxine();
	//Sword
	public static final Item silver_sword = new ItemSilverSword();
	public static final Item cobalt_sword = new ItemCobaltSword();
	public static final Item irisium_sword = new ItemIrisiumSword();
	public static final Item galaxine_sword = new ItemGalaxineSword();
	//Pickaxes
	public static final Item silver_pickaxe = new ItemSilverPickaxe();
	public static final Item cobalt_pickaxe = new ItemCobaltPickaxe();
	public static final Item irisium_pickaxe = new ItemIrisiumPickaxe();
	public static final Item galaxine_pickaxe = new ItemGalaxinePickaxe();
	//Axes
	public static final Item silver_axe = new ItemSilverAxe();
	public static final Item cobalt_axe = new ItemCobaltAxe();
	public static final Item irisium_axe = new ItemIrisiumAxe();
	public static final Item galaxine_axe = new ItemGalaxineAxe();
	//Shovels
	public static final Item silver_shovel = new ItemSilverShovel();
	public static final Item cobalt_shovel = new ItemCobaltShovel();
	public static final Item irisium_shovel = new ItemIrisiumShovel();
	//Armors
	public static final Item silver_helmet = new ItemSilverArmor("silver_helmet", ArmorMaterials.armorSilver, 1, EntityEquipmentSlot.HEAD);
	public static final Item silver_chest = new ItemSilverArmor("silver_chest", ArmorMaterials.armorSilver, 1, EntityEquipmentSlot.CHEST);
	public static final Item silver_legg = new ItemSilverArmor("silver_legg", ArmorMaterials.armorSilver, 1, EntityEquipmentSlot.LEGS);
	public static final Item silver_boots = new ItemSilverArmor("silver_boots", ArmorMaterials.armorSilver, 1, EntityEquipmentSlot.FEET);
	
	public static final Item cobalt_helmet = new ItemCobaltArmor("cobalt_helmet", ArmorMaterials.armorCobalt, 1, EntityEquipmentSlot.HEAD);
	public static final Item cobalt_chest = new ItemCobaltArmor("cobalt_chest", ArmorMaterials.armorCobalt, 1, EntityEquipmentSlot.CHEST);
	public static final Item cobalt_legg = new ItemCobaltArmor("cobalt_legg", ArmorMaterials.armorCobalt, 1, EntityEquipmentSlot.LEGS);
	public static final Item cobalt_boots = new ItemCobaltArmor("cobalt_boots", ArmorMaterials.armorCobalt, 1, EntityEquipmentSlot.FEET);
	
	public static final Item irisium_helmet = new ItemIrisiumHelmetArmor("irisium_helmet", ArmorMaterials.armorIrisium, 1, EntityEquipmentSlot.HEAD);
	public static final Item irisium_chest = new ItemIrisiumChestArmor("irisium_chest", ArmorMaterials.armorIrisium, 1, EntityEquipmentSlot.CHEST);
	public static final Item irisium_legg = new ItemIrisiumLeggArmor("irisium_legg", ArmorMaterials.armorIrisium, 1, EntityEquipmentSlot.LEGS);
	public static final Item irisium_boots = new ItemIrisiumBootsArmor("irisium_boots", ArmorMaterials.armorIrisium, 1, EntityEquipmentSlot.FEET);

	public static final Item galaxine_helmet = new ItemGalaxineHelmetArmor("galaxine_helmet", ArmorMaterials.armorGalaxine, 1, EntityEquipmentSlot.HEAD);
	public static final Item galaxine_chest = new ItemGalaxineChestArmor("galaxine_chest", ArmorMaterials.armorGalaxine, 1, EntityEquipmentSlot.CHEST);
	public static final Item galaxine_legg = new ItemGalaxineLeggArmor("galaxine_legg", ArmorMaterials.armorGalaxine, 1, EntityEquipmentSlot.LEGS);
	public static final Item galaxine_boots = new ItemGalaxineBootsArmor("galaxine_boots", ArmorMaterials.armorGalaxine, 1, EntityEquipmentSlot.FEET);
	//MultiTool
	public static final Item silver_multitool = new ItemMultiTool("silver_multitool", ToolMaterialIrisya.toolTypeSilver);
	public static final Item cobalt_multitool = new ItemMultiTool("cobalt_multitool", ToolMaterialIrisya.toolTypeCobalt);
	public static final Item irisium_multitool = new ItemMultiTool("irisium_multitool", ToolMaterialIrisya.toolTypeIrisium);
	//Hammer
	public static final Item silver_hammer = new ItemHammer("silver_hammer", ToolMaterialIrisya.hammerTypeSilver);
	public static final Item cobalt_hammer = new ItemHammer("cobalt_hammer", ToolMaterialIrisya.hammerTypeCobalt);
	public static final Item irisium_hammer = new ItemHammer("irisium_hammer", ToolMaterialIrisya.hammerTypeIrisium);
	//Seeds
	public static final Item oats_seed = new ItemOatsSeed();
	public static final Item rye_seed = new ItemRyeSeed();
	public static final Item rice_seed = new ItemRiceSeed();
	public static final Item corn_seed = new ItemCornSeed();
	//Drops Crops
	public static final Item oats = new ItemOats();
	public static final Item rye = new ItemRye();
	public static final Item rice = new ItemRice();
	public static final Item corn = new ItemCorn();
	//Seeds Ores
	public static final Item silverite_seed = new ItemSilveriteSeed();
	public static final Item cobaltine_seed = new ItemCobaltineSeed();
	public static final Item irisite_seed = new ItemIrisiteSeed();
	public static final Item galaxite_seed = new ItemGalaxiteSeed();
	//Farmers
	public static final Item magical_coal = new ItemMagicalCoal();
	public static final Item fertilizers = new ItemFertilizers();
	public static final Item watering_can = new ItemWateringCan();
	//Ores Miner
	public static final Item copper = new ItemCopper();
	public static final Item tin = new ItemTin();
	public static final Item manganese = new ItemManganese();
	public static final Item pyrite = new ItemPyrite();
	//Refined Ores
	public static final Item refined_copper = new ItemRefinedCopper();
	public static final Item refined_tin = new ItemRefinedTin();
	public static final Item refined_manganese = new ItemRefinedManganese();
	public static final Item refined_pyrite = new ItemRefinedPyrite();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> evt) 
	{
		IForgeRegistry<Item> r = evt.getRegistry();
		
		//Ingots
		r.register(silver);
		r.register(cobalt);
		r.register(irisium);
		r.register(galaxine_shard);
		r.register(galaxine);
		//Sword
		r.register(silver_sword);
		r.register(cobalt_sword);
		r.register(irisium_sword);
		r.register(galaxine_sword);
		//Pickaxes
		r.register(silver_pickaxe);
		r.register(cobalt_pickaxe);
		r.register(irisium_pickaxe);
		r.register(galaxine_pickaxe);
		//Axes
		r.register(silver_axe);
		r.register(cobalt_axe);
		r.register(irisium_axe);
		r.register(galaxine_axe);
		//Shovels
		r.register(silver_shovel);
		r.register(cobalt_shovel);
		r.register(irisium_shovel);
		//Armors
		r.register(silver_helmet);
		r.register(silver_chest);
		r.register(silver_legg);
		r.register(silver_boots);
		
		r.register(cobalt_helmet);
		r.register(cobalt_chest);
		r.register(cobalt_legg);
		r.register(cobalt_boots);
		
		r.register(irisium_helmet);
		r.register(irisium_chest);
		r.register(irisium_legg);
		r.register(irisium_boots);
		
		r.register(galaxine_helmet);
		r.register(galaxine_chest);
		r.register(galaxine_legg);
		r.register(galaxine_boots);
		//MultiTool
		r.register(silver_multitool);
		r.register(cobalt_multitool);
		r.register(irisium_multitool);
		//Hammer
		r.register(silver_hammer);
		r.register(cobalt_hammer);
		r.register(irisium_hammer);
		//Seeds
		r.register(oats_seed);
		r.register(rye_seed);
		r.register(rice_seed);
		r.register(corn_seed);
		//Drops Crops
		r.register(oats);
		r.register(rye);
		r.register(rice);
		r.register(corn);
		//Seeds Ores
		r.register(silverite_seed);
		r.register(cobaltine_seed);
		r.register(irisite_seed);
		r.register(galaxite_seed);
		//Farmers
		r.register(magical_coal);
		r.register(fertilizers);
		r.register(watering_can);
		//Ores Miner
		r.register(copper);
		r.register(tin);
		r.register(manganese);
		r.register(pyrite);
		//Refined Ores
		r.register(refined_copper);
		r.register(refined_tin);
		r.register(refined_manganese);
		r.register(refined_pyrite);
	}
}

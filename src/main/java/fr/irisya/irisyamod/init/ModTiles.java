package fr.irisya.irisyamod.init;

import fr.irisya.irisyamod.tiles.TileEntityAlloyFabricator;
import fr.irisya.irisyamod.tiles.TileEntityComposter;
import fr.irisya.irisyamod.utils.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTiles
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityComposter.class, new ResourceLocation(References.MODID, "TileComposter"));
		GameRegistry.registerTileEntity(TileEntityAlloyFabricator.class, new ResourceLocation(References.MODID, "TileEntityAlloyFabricator"));
	}
}

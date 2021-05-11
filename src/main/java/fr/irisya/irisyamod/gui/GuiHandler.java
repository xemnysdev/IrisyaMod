package fr.irisya.irisyamod.gui;

import fr.irisya.irisyamod.container.ContainerAlloyFabricator;
import fr.irisya.irisyamod.container.ContainerComposter;
import fr.irisya.irisyamod.tiles.TileEntityAlloyFabricator;
import fr.irisya.irisyamod.tiles.TileEntityComposter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int COMPOSTER = 0;
	public static final int ALLOY_FABRICATOR = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		switch (ID) 
		{
		case 0:
			return new ContainerComposter((TileEntityComposter)te, player.inventory);
		case 1:
			return new ContainerAlloyFabricator((TileEntityAlloyFabricator)te, player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		switch (ID) 
		{
		case 0:
			return new GuiComposter((TileEntityComposter)te, player.inventory);
		case 1:
			return new GuiAlloyFabricator((TileEntityAlloyFabricator)te, player.inventory);
		}
		return null;
	}
}

package fr.irisya.irisyamod.gui;

import fr.irisya.irisyamod.container.ContainerAlloyFabricator;
import fr.irisya.irisyamod.tiles.TileEntityAlloyFabricator;
import fr.irisya.irisyamod.utils.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyFabricator extends GuiContainer
{
	private static final ResourceLocation background = new ResourceLocation(References.MODID  + ":textures/gui/alloy_fabricator.png");
	private TileEntityAlloyFabricator tile;

	public GuiAlloyFabricator(TileEntityAlloyFabricator tile, InventoryPlayer playerInv) 
	{
		super(new ContainerAlloyFabricator(tile, playerInv));
		this.tile = tile;
		this.ySize = 340;
		this.xSize = 200;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.drawDefaultBackground();
	    this.mc.getTextureManager().bindTexture(background);
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	    int timePassed = this.tile.getField(1);
	    int textureWidth = (int) (23f / 200f * timePassed);
	    this.drawTexturedModalRect(i + 103, j + 38 + 12 - textureWidth, 176, 12, textureWidth, 1);
	}
}

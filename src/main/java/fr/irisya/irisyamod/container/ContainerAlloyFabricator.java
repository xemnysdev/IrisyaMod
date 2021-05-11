package fr.irisya.irisyamod.container;

import fr.irisya.irisyamod.slots.SlotFuel;
import fr.irisya.irisyamod.slots.SlotOutput;
import fr.irisya.irisyamod.tiles.TileEntityAlloyFabricator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAlloyFabricator extends Container
{
	private TileEntityAlloyFabricator tile;
	private int	timePassed = 0;
	private int	burnTimeLeft = 0;
	
	public ContainerAlloyFabricator(TileEntityAlloyFabricator tile, InventoryPlayer playerInventory) 
	{
		this.tile = tile;
        this.addSlotToContainer(new Slot(tile, 0, 47, 95));
        this.addSlotToContainer(new Slot(tile, 1, 68, 116));
        this.addSlotToContainer(new Slot(tile, 2, 95, 95));
        this.addSlotToContainer(new Slot(tile, 3, 122, 116));
        this.addSlotToContainer(new Slot(tile, 4, 143, 95));
        this.addSlotToContainer(new SlotFuel(tile, 5, 17, 95));
        this.addSlotToContainer(new SlotOutput(playerInventory.player, tile, 6, 96, 149));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
            	addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 17 + j * 18, 171 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
        	addSlotToContainer(new Slot(playerInventory, k, 17 + k * 18, 229));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
	    return tile.isUsableByPlayer(player);
	}
	
	@Override
	public void addListener(IContainerListener listener) 
	{
	    super.addListener(listener);
	    listener.sendAllWindowProperties(this, this.tile);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
	    super.detectAndSendChanges();
	    for(int i = 0; i < this.listeners.size(); ++i) 
	    {
	        IContainerListener icontainerlistener = (IContainerListener) this.listeners.get(i);
	        if (this.burnTimeLeft != this.tile.getField(0)) 
	        {
	            icontainerlistener.sendWindowProperty(this, 0,
	                    this.tile.getField(0));
	        }
	        if (this.timePassed != this.tile.getField(1)) 
	        {
	            icontainerlistener.sendWindowProperty(this, 1,
	                    this.tile.getField(1));
	        }
	    }
	    this.burnTimeLeft = this.tile.getField(0);
	    this.timePassed = this.tile.getField(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
	    this.tile.setField(id, data);
	}
	
	@Override

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
	    return ItemStack.EMPTY;
	}
}

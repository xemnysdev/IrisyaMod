package fr.irisya.irisyamod.container;

import fr.irisya.irisyamod.slots.SlotOutput;
import fr.irisya.irisyamod.tiles.TileEntityComposter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerComposter extends Container
{
	private TileEntityComposter tile;
	private int	timePassed = 0;
	private int	burnTimeLeft = 0;
	
	public ContainerComposter(TileEntityComposter tile, InventoryPlayer playerInventory) 
	{
		this.tile = tile;
        this.addSlotToContainer(new Slot(tile, 0, 35, 100));
        this.addSlotToContainer(new Slot(tile, 1, 53, 100));
        this.addSlotToContainer(new Slot(tile, 2, 35, 118));
        this.addSlotToContainer(new Slot(tile, 3, 53, 118));
        this.addSlotToContainer(new Slot(tile, 4, 35, 136));
        this.addSlotToContainer(new Slot(tile, 5, 53, 136));
        this.addSlotToContainer(new SlotOutput(playerInventory.player, tile, 6, 143, 119));

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

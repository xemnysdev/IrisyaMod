package fr.irisya.irisyamod.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot 
{
	private final EntityPlayer player;
    private int removeCount;
    
    public SlotOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.player = player;
    }
    
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
}

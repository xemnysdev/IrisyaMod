package fr.irisya.irisyamod.slots;

import fr.irisya.irisyamod.tiles.TileEntityAlloyFabricator;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotFuel extends Slot 
{
	private Item item;

	public SlotFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
	{
		super(inventoryIn, slotIndex, xPosition, yPosition);
	}

	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityAlloyFabricator.isItemFuel(stack);
	}
}

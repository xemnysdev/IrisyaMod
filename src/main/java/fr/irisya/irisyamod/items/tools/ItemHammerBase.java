package fr.irisya.irisyamod.items.tools;

import java.util.Set;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.render.IModelRegister;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHammerBase extends ItemTool implements IModelRegister
{
	public ItemHammerBase(String modId, ToolMaterial toolMaterial, Set<Block> effective_on) 
	{
        super(toolMaterial.getHarvestLevel() + 1, -3.25f, toolMaterial, effective_on);
        this.setRegistryName(modId);
		this.setUnlocalizedName(modId);
        setMaxDamage((int) (toolMaterial.getMaxUses()));
        setCreativeTab(IrisyaMod.IRISYA_TAB);
    }

	private int mineRadius = 1, mineDepth = 0;
	
	@Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) 
	{
        if (entityLiving instanceof EntityPlayer) 
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            RayTraceResult result = rayTrace(world, player, false);
            EnumFacing sideHit = result.sideHit;
            int xDist, yDist, zDist;
            yDist = xDist = zDist = mineRadius;
            switch (sideHit) 
            {
                case UP:
                case DOWN: yDist = mineDepth; break;
                case NORTH:
                case SOUTH: zDist = mineDepth; break;
                case EAST:
                case WEST: xDist = mineDepth; break;
            }
            if (!player.isSneaking()) 
            {
                for (int x = pos.getX() - xDist; x <= pos.getX() + xDist; x++) 
                {
                    for (int y = pos.getY() - yDist; y <= pos.getY() + yDist; y++)
                    {
                        for (int z = pos.getZ() - zDist; z <= pos.getZ() + zDist; z++) 
                        {
                            BlockPos targetPos = new BlockPos(x, y, z);
                            IBlockState targetBlock = world.getBlockState(targetPos);
                            if (canHarvestBlock(targetBlock, player.getHeldItem(EnumHand.MAIN_HAND))) 
                            {
                                if ((stack.getMaxDamage() - stack.getItemDamage()) >= 1 && targetBlock.getBlock() != Blocks.BEDROCK) 
                                {
                                    if (targetBlock.getBlock().getExpDrop(targetBlock, world, targetPos, 0) > 0) 
                                    {
                                        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) 
                                        {
                                            world.spawnEntity(new EntityXPOrb(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, world.getBlockState(pos).getBlock().getExpDrop(targetBlock, world, targetPos, 0)));
                                        }
                                    }
                                    world.destroyBlock(new BlockPos(x, y, z), true);
                                }
                                stack.damageItem(1, player);
                            }
                        }
                    }
                }
            } 
            else
            {
                stack.damageItem(1, player);
            }
            return false;
        } 
        else 
        {
            return false;
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() 
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}

package fr.irisya.irisyamod.proxy;

import fr.irisya.irisyamod.IrisyaMod;
import fr.irisya.irisyamod.events.EventHandler;
import fr.irisya.irisyamod.gui.GuiHandler;
import fr.irisya.irisyamod.gui.GuiMainMenuMod;
import fr.irisya.irisyamod.handler.RecipesHandler;
import fr.irisya.irisyamod.init.ModTiles;
import fr.irisya.irisyamod.utils.ArmorMaterials;
import fr.irisya.irisyamod.utils.ToolMaterialIrisya;
import fr.irisya.irisyamod.world.WorldGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void preInit()
	{
		ToolMaterialIrisya.init();
		ArmorMaterials.init();
		EventHandler eventHandler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void init()
	{
		ModTiles.init();
		RecipesHandler.registerRecipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(IrisyaMod.instance, new GuiHandler());
	}
	
	public void postInit()
	{

	}
	
	public static void otherRegistries() 
	{
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}
	
	/*@SubscribeEvent
	public void onOpenGui(GuiOpenEvent event)
	{
		if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class)
		{
			event.setGui(new GuiMainMenuMod());
		}
	}

	@SubscribeEvent
    public void onClick(PlayerInteractEvent.LeftClickEmpty event)
    {
        if(Minecraft.getMinecraft().objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY)
        {
            event.getEntityPlayer().sendMessage(new TextComponentString("You hit : " + Minecraft.getMinecraft().objectMouseOver.entityHit.getName()));
        }
    }*/
}

package fr.irisya.irisyamod;

import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import fr.irisya.irisyamod.proxy.CommonProxy;
import fr.irisya.irisyamod.tabs.IrisyaTab;
import fr.irisya.irisyamod.utils.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class IrisyaMod 
{
	@Instance(References.MODID)
	public static IrisyaMod instance;
	public static CreativeTabs IRISYA_TAB = new IrisyaTab("irisya_tab");
	@SuppressWarnings("unused")
	private static Logger logger;
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
    public static CommonProxy proxy;
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		if(event.getSide().isClient())
		{
			Display.setTitle("Irisya " + References.VERSION);
		}
		CommonProxy.otherRegistries();
		proxy.preInit();
	}
    
    @EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
	
	public static ResourceLocation locate(String location)
	{
		return new ResourceLocation(References.MODID, location);
	}
}

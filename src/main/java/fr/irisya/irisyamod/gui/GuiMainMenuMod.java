package fr.irisya.irisyamod.gui;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GLContext;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import fr.irisya.irisyamod.gui.button.GuiButtonDiscord;
import fr.irisya.irisyamod.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.ServerPinger;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiMainMenuMod extends GuiScreen
{
	private static final Logger LOGGER = LogManager.getLogger();
    private static final Random RANDOM = new Random();
    private String splashText;
    private GuiButton buttonResetDemo;
    private int panoramaTimer;
    private DynamicTexture viewportTexture;
    private final Object threadLock = new Object();
    public static final String MORE_INFO_TEXT = "Please click " + TextFormatting.UNDERLINE + "here" + TextFormatting.RESET + " for more information.";
    private int openGLWarning2Width;
    private int openGLWarning1Width;
    private int openGLWarningX1;
    private int openGLWarningY1;
    private int openGLWarningX2;
    private int openGLWarningY2;
    private String openGLWarning1;
    private String openGLWarning2;
    private String openGLWarningLink;
    private static final ResourceLocation SPLASH_TEXTS = new ResourceLocation("texts/splashes.txt");
    private static final ResourceLocation MFF_TITLE = new ResourceLocation(References.MODID, "textures/gui/title.png");
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(References.MODID, "textures/gui/background.png");

    private ResourceLocation backgroundTexture;
    private GuiButton modButton;
    private int widthCopyright;
    private int widthCopyrightRest;

    private final ServerPinger serverPinger = new ServerPinger();
    private ServerData server = new ServerData("Irisya", "145.239.131.125:25580", false);
    private static final ThreadPoolExecutor EXECUTOR = new ScheduledThreadPoolExecutor(5, (new ThreadFactoryBuilder()).setNameFormat("Server Pinger #%d").setDaemon(true).build());

    // d�but texte defilant
    private int scrollingTextPosX;
    private String scrollingText;
    // fin texte defilant

    public GuiMainMenuMod()
    {
        // d�but texte defilant
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    URL url = new URL("http://dl.mcnanotech.fr/mff/tutoriels/mainmenutext.txt");
                    InputStream is = url.openStream();
                    GuiMainMenuMod.this.scrollingText = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));
                }
                catch(Exception e)
                {
                	GuiMainMenuMod.this.scrollingText = "Le serveir est actuellement en Developpement.";
                }
            }
        }.start();


        FMLClientHandler.instance().setupServerList();
        this.openGLWarning2 = MORE_INFO_TEXT;
        this.splashText = "missingno";
        IResource iresource = null;

        try
        {
            List<String> list = Lists.<String>newArrayList();
            iresource = Minecraft.getMinecraft().getResourceManager().getResource(SPLASH_TEXTS);
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(iresource.getInputStream(), Charsets.UTF_8));
            String s;

            while ((s = bufferedreader.readLine()) != null)
            {
                s = s.trim();

                if (!s.isEmpty())
                {
                    list.add(s);
                }
            }

            if (!list.isEmpty())
            {
                while (true)
                {
                    this.splashText = (String)list.get(RANDOM.nextInt(list.size()));

                    if (this.splashText.hashCode() != 125780783)
                    {
                        break;
                    }
                }
            }
        }
        catch (IOException var8)
        {
            ;
        }
        finally
        {
            IOUtils.closeQuietly((Closeable)iresource);
        }

        this.openGLWarning1 = "";

        if (!GLContext.getCapabilities().OpenGL20 && !OpenGlHelper.areShadersSupported())
        {
            this.openGLWarning1 = I18n.format("title.oldgl1", new Object[0]);
            this.openGLWarning2 = I18n.format("title.oldgl2", new Object[0]);
            this.openGLWarningLink = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
        }

        String s1 = System.getProperty("java.version");

        if (s1 != null && (s1.startsWith("1.6") || s1.startsWith("1.7")))
        {
            this.openGLWarning1 = I18n.format("title.oldjava1", new Object[0]);
            this.openGLWarning2 = I18n.format("title.oldjava2", new Object[0]);
            this.openGLWarningLink = "https://help.mojang.com/customer/portal/articles/2636196?ref=game";
        }
    }

    public void updateScreen()
    {
        ++this.panoramaTimer;
    }

    public boolean doesGuiPauseGame()
    {
        return false;
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
    	
    }

    public void initGui()
    {
        this.viewportTexture = new DynamicTexture(256, 256);
        this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
        this.widthCopyright = this.fontRenderer.getStringWidth("Copyright Mojang AB. Do not distribute!");
        this.widthCopyrightRest = this.width - this.widthCopyright - 2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            this.splashText = "Merry X-mas!";
        }
        else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            this.splashText = "Happy new year!";
        }
        else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
        {
            this.splashText = "OOoooOOOoooo! Spooky!";
        }

        int j = this.height / 4 + 48;

        if (this.mc.isDemo())
        {
            this.addDemoButtons(j, 24);
        }
        else
        {
            this.addSingleplayerMultiplayerButtons(j, 24);
        }

        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, j + 72 + 12));
        this.buttonList.add(new GuiButtonDiscord(21, this.width / 2 - 124, j + 24));

        synchronized (this.threadLock)
        {
            this.openGLWarning1Width = this.fontRenderer.getStringWidth(this.openGLWarning1);
            this.openGLWarning2Width = this.fontRenderer.getStringWidth(this.openGLWarning2);
            int k = Math.max(this.openGLWarning1Width, this.openGLWarning2Width);
            this.openGLWarningX1 = (this.width - k) / 2;
            this.openGLWarningY1 = ((GuiButton)this.buttonList.get(0)).y - 24;
            this.openGLWarningX2 = this.openGLWarningX1 + k;
            this.openGLWarningY2 = this.openGLWarningY1 + 24;
        }

        this.mc.setConnectedToRealms(false);
    }

    private void addSingleplayerMultiplayerButtons(int yPos, int yInterval)
    {
    	this.buttonList.add(new GuiButton(19, this.width / 2 - 100, yPos, I18n.format("menu.siteweb")) 
		{
			public void mouseReleased(int x, int y) 
			{
				try {
					Desktop.getDesktop().browse(new URI("http://www.irisya-pvp.fr/"));
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (URISyntaxException e) 
				{
					e.printStackTrace();
				}
			}
		});
        //this.buttonList.add(new GuiButton(2, this.width / 2 - 100, yPos + yInterval * 1, I18n.format("menu.multiplayer", new Object[0])));
        this.buttonList.add(new GuiButton(20, this.width / 2 - 100, yPos + yInterval * 1, I18n.format("menu.localserver")));
        this.buttonList.add(modButton = new GuiButton(6, this.width / 2 - 100, yPos + yInterval * 2, I18n.format("fml.menu.mods")));
    }

    private void addDemoButtons(int p_73972_1_, int p_73972_2_)
    {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, p_73972_1_, I18n.format("menu.playdemo", new Object[0])));
        this.buttonResetDemo = this.addButton(new GuiButton(12, this.width / 2 - 100, p_73972_1_ + p_73972_2_ * 1, I18n.format("menu.resetdemo", new Object[0])));
        ISaveFormat isaveformat = this.mc.getSaveLoader();
        WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

        if (worldinfo == null)
        {
            this.buttonResetDemo.enabled = false;
        }
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 5)
        {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }

        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiWorldSelection(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }

        if (button.id == 4)
        {
            this.mc.shutdown();
        }

        if (button.id == 6)
        {
            this.mc.displayGuiScreen(new net.minecraftforge.fml.client.GuiModList(this));
        }

        if (button.id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

            if (worldinfo != null)
            {
                this.mc.displayGuiScreen(new GuiYesNo(this, I18n.format("selectWorld.deleteQuestion", new Object[0]), "\'" + worldinfo.getWorldName() + "\' " + I18n.format("selectWorld.deleteWarning", new Object[0]), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 12));
            }
        }

        if(button.id == 20)
        {
            FMLClientHandler.instance().connectToServer(this, new ServerData("irisya", "145.239.131.125:25580", false));
            /*
             * on peut aussi utiliser :
            FMLClientHandler.instance().connectToServer(this, new ServerData("localserver", "localhost:25565", false));
             * comme les noms de domaine fonctionnent aussi
             */
        }

        if(button.id == 21)
        {
            try
            {
                Desktop.getDesktop().browse(new URI("https://discordapp.com/invite/0uXCYNHVWGM8sAYS"));
            }
            catch(URISyntaxException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void confirmClicked(boolean result, int id)
    {
        if (result && id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            isaveformat.flushCache();
            isaveformat.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if (id == 12)
        {
            this.mc.displayGuiScreen(this);
        }
        else if (id == 13)
        {
            if (result)
            {
                try
                {
                    Class<?> oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI(this.openGLWarningLink)});
                }
                catch (Throwable throwable)
                {
                    LOGGER.error("Couldn\'t open link", throwable);
                }
            }

            this.mc.displayGuiScreen(this);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        mc.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, 1, 1, this.width, this.height, 1, 1);
        GlStateManager.enableAlpha();

        this.mc.getTextureManager().bindTexture(MFF_TITLE);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        Gui.drawScaledCustomSizeModalRect(this.width / 2 - 150, 25, 0, 0, 1, 1, 300, 60, 1, 1);
        GlStateManager.disableBlend();

        if(!this.server.pinged)
        {
            this.server.pinged = true;
            this.server.pingToServer = -2L;
            this.server.serverMOTD = "";
            this.server.populationInfo = "";
            EXECUTOR.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                    	GuiMainMenuMod.this.serverPinger.ping(GuiMainMenuMod.this.server);
                    }
                    catch(UnknownHostException unknowHostException)
                    {
                    	GuiMainMenuMod.this.server.pingToServer = -1L;
                    	GuiMainMenuMod.this.server.serverMOTD = TextFormatting.DARK_RED + "Impossible de r�soudre le nom d'h�te";
                    }
                    catch(Exception exception)
                    {
                    	GuiMainMenuMod.this.server.pingToServer = -1L;
                    	GuiMainMenuMod.this.server.serverMOTD = TextFormatting.DARK_RED + "Impossible de se connecter au serveur";
                    }
                }
            });
        }
        if(this.server.pingToServer >= 0L)
        {
            this.drawString(this.fontRenderer, this.server.populationInfo + TextFormatting.RESET + " joueurs", this.width / 2 + 110, this.height / 4 + 72, 0x245791);
            this.drawString(this.fontRenderer, this.server.pingToServer + " ms", this.width / 2 + 110, this.height / 4 + 82, 0x245791);
            if(this.server.playerList != null && !this.server.playerList.isEmpty())
            {
                List<String> list = this.mc.fontRenderer.listFormattedStringToWidth(this.server.playerList, this.width - (this.width / 2 + 110));
                for(int i = 0;i < list.size(); i++)
                {
                    if(i >= 10)
                    {
                        break;
                    }
                    this.drawString(this.fontRenderer, list.get(i), this.width / 2 + 110, this.height / 4 + 92 + 10 * i, 0x245791);
                }
            }
            this.drawCenteredString(this.fontRenderer, this.server.serverMOTD, this.width / 2, this.height / 4 + 24, 0x245791);
        }
        else
        {
            this.drawString(this.fontRenderer, this.server.serverMOTD, this.width / 2 + 110, this.height / 4 + 72, 0x245791);
        }

        this.scrollingTextPosX --;
        if(this.scrollingTextPosX < -this.fontRenderer.getStringWidth(this.scrollingText))
        {
            this.scrollingTextPosX = this.width;
        }
        this.drawRect(0, 0, this.width, 12, 0x77FFFFFF);
        this.fontRenderer.drawString(this.scrollingText, this.scrollingTextPosX, 2, 0x245791);
        // fin texte d�filant

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2 + 90), 70.0F, 0.0F);
        GlStateManager.rotate(-20.0F, 0.0F, 0.0F, 1.0F);
        float f = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * ((float)Math.PI * 2F)) * 0.1F);
        f = f * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
        GlStateManager.scale(f, f, f);
        this.drawCenteredString(this.fontRenderer, this.splashText, 0, 0, -256); // affichage du slash texte. Il peut �tre int�ressant d'adapter la position
        GlStateManager.popMatrix();
        String s = "Irisya - V0.1";

        if (this.mc.isDemo())
        {
            s = s + " Demo";
        }
        else
        {
            s = s + ("release".equalsIgnoreCase(this.mc.getVersionType()) ? "" : "/" + this.mc.getVersionType());
        }
        String s1 = "Copyright Mojang AB. Do not distribute!";
        this.drawString(this.fontRenderer, "Copyright Mojang AB. Do not distribute!", this.width - this.fontRenderer.getStringWidth("Copyright Mojang AB. Do not distribute!") - 2, this.height - 10, -1);

        if (this.openGLWarning1 != null && !this.openGLWarning1.isEmpty())
        {
            drawRect(this.openGLWarningX1 - 2, this.openGLWarningY1 - 2, this.openGLWarningX2 + 2, this.openGLWarningY2 - 1, 1428160512);
            this.drawString(this.fontRenderer, this.openGLWarning1, this.openGLWarningX1, this.openGLWarningY1, -1);
            this.drawString(this.fontRenderer, this.openGLWarning2, (this.width - this.openGLWarning2Width) / 2, ((GuiButton)this.buttonList.get(0)).y - 12, -1);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        synchronized (this.threadLock)
        {
            if (!this.openGLWarning1.isEmpty() && !StringUtils.isNullOrEmpty(this.openGLWarningLink) && mouseX >= this.openGLWarningX1 && mouseX <= this.openGLWarningX2 && mouseY >= this.openGLWarningY1 && mouseY <= this.openGLWarningY2)
            {
                GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(this, this.openGLWarningLink, 13, true);
                guiconfirmopenlink.disableSecurityWarning();
                this.mc.displayGuiScreen(guiconfirmopenlink);
            }
        }
    }

    public void onGuiClosed()
    {

    }
}

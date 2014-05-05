package RedstoneArmory;

import net.minecraft.creativetab.CreativeTabs;
import RedstoneArmory.gui.CreativeTabRedstoneArmory;
import RedstoneArmory.items.ItemRegistry;
import RedstoneArmory.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
public class RedstoneArmory {

	public static CreativeTabs tabRedstoneArmory = new CreativeTabRedstoneArmory("redstoneArmory.creativeTab");

	@Instance(ModInformation.ID)
	public static RedstoneArmory instance;

	@SidedProxy(clientSide = "RedstoneArmory.proxies.ClientProxy", serverSide = "RedstoneARmory.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.create(event);
		proxy.initRenderers();
		proxy.initSounds();
		ItemRegistry.init();

		System.out.println("[RedstoneArmory] PreInitialization phase completed.");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

}

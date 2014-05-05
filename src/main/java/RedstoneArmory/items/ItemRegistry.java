package RedstoneArmory.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import RedstoneArmory.items.tools.ItemEnderiumFluxedAxe;
import RedstoneArmory.items.tools.ItemEnderiumFluxedPickaxe;
import RedstoneArmory.items.tools.ItemEnderiumFluxedRod;
import RedstoneArmory.items.tools.ItemEnderiumFluxedShovel;
import RedstoneArmory.items.tools.ItemEnderiumFluxedSickle;
import RedstoneArmory.items.tools.ItemEnderiumFluxedSword;
import RedstoneArmory.items.tools.ItemEnderiumFluxedWrench;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {

	public static Item enderiumFluxedPickaxe;
	public static Item enderiumFluxedAxe;
	public static Item enderiumFluxedShovel;
	public static Item enderiumFluxedSword;
	public static Item enderiumFluxedSickle;
	public static Item enderiumFluxedWrench;
	public static Item enderiumFluxedRod;

	public static void init() {
		enderiumFluxedPickaxe = new ItemEnderiumFluxedPickaxe(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedPickaxe, ItemInfo.EFPICKAXE_KEY);

		enderiumFluxedAxe = new ItemEnderiumFluxedAxe(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedAxe, ItemInfo.EFAXE_KEY);

		enderiumFluxedShovel = new ItemEnderiumFluxedShovel(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedShovel, ItemInfo.EFSHOVEL_KEY);
	
		enderiumFluxedSword = new ItemEnderiumFluxedSword(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedSword, ItemInfo.EFSWORD_KEY);
		
		enderiumFluxedSickle = new ItemEnderiumFluxedSickle(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedSickle, ItemInfo.EFSICKLE_KEY);
		
		enderiumFluxedWrench = new ItemEnderiumFluxedWrench(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedWrench, ItemInfo.EFWRENCH_KEY);
		
		enderiumFluxedRod = new ItemEnderiumFluxedRod(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedRod, ItemInfo.EFROD_KEY);
	}

}
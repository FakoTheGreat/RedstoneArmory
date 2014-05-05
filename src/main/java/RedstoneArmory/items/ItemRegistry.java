package RedstoneArmory.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import RedstoneArmory.items.tools.ItemEnderiumFluxedAxe;
import RedstoneArmory.items.tools.ItemEnderiumFluxedPickaxe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {

	public static Item enderiumFluxedPickaxe;
	public static Item enderiumFluxedAxe;

	public static void init() {
		enderiumFluxedPickaxe = new ItemEnderiumFluxedPickaxe(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedPickaxe, ItemInfo.EFPICKAXE_KEY);
		
		enderiumFluxedAxe = new ItemEnderiumFluxedAxe(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedAxe, ItemInfo.EFAXE_KEY);
	}

}
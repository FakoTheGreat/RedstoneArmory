package RedstoneArmory.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {

	public static Item enderiumFluxedPickaxe;

	public static void init() {
		enderiumFluxedPickaxe = new ItemEnderiumFluxedPickaxe(ToolMaterial.EMERALD);
		GameRegistry.registerItem(enderiumFluxedPickaxe, ItemInfo.EFP_KEY);
	}

}
package RedstoneArmory.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;


public class Items {
	
	public static Item enderiumFluxedPickaxe;
	
	public static void init() {
		enderiumFluxedPickaxe = new ItemEnderiumFluxedPickaxe(ItemInfo.EFP_ID);
		GameRegistry.registerItem(enderiumFluxedPickaxe, ItemInfo.EFP_KEY);
		
	}

}
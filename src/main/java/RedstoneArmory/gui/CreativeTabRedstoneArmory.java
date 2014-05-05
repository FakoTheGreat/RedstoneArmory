package RedstoneArmory.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import RedstoneArmory.items.Items;

public class CreativeTabRedstoneArmory extends CreativeTabs {

	public CreativeTabRedstoneArmory(String tabLabel) {
		super(tabLabel);
	}

	@Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Items.enderiumFluxedPickaxe, 1, 0);
    }

	@Override
	public Item getTabIconItem() {
		return Items.enderiumFluxedPickaxe;
	}

}
package RedstoneArmory.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderiumFluxedPickaxe extends Item {
	private IIcon activeIcon;
	
	public ItemEnderiumFluxedPickaxe(int id) {
		setCreativeTab(RedstoneArmory.RedstoneArmory.tabRedstoneArmory);
		setMaxDamage(0);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.EFP_UNLOCALIZED_NAME);
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFP_ICON);
		this.activeIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFP_ACTIVE_ICON);
	}

}

package RedstoneArmory.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderiumFluxedPickaxe extends ItemPickaxe {
	protected ItemEnderiumFluxedPickaxe(ToolMaterial material) {
		super(material);
		setCreativeTab(RedstoneArmory.RedstoneArmory.tabRedstoneArmory);
		setUnlocalizedName(ItemInfo.EFP_UNLOCALIZED_NAME);
	}

	@SuppressWarnings("unused")
	private IIcon activeIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFP_ICON);
		this.activeIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFP_ACTIVE_ICON);
	}

}

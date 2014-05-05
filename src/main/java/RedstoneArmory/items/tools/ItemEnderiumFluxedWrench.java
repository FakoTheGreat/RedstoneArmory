package RedstoneArmory.items.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import RedstoneArmory.items.ItemInfo;
import RedstoneArmory.util.KeyboardHelper;
import RedstoneArmory.util.RFHelper;
import cofh.api.energy.IEnergyContainerItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderiumFluxedWrench extends Item implements IEnergyContainerItem {
	
	@SuppressWarnings("unused")
	private IIcon activeIcon;
	private IIcon drainedIcon;
	public int capacity = 160000;
	public int cost = 200;
	public int empoweredCost = 600;
	public int transferLimit = 1000;

	public ItemEnderiumFluxedWrench(ToolMaterial material) {
		super();
		setCreativeTab(RedstoneArmory.RedstoneArmory.tabRedstoneArmory);
		setUnlocalizedName(ItemInfo.EFWRENCH_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFWRENCH_ICON);
		this.activeIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFWRENCH_ACTIVE_ICON);
		this.drainedIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.EFWRENCH_DRAINED_ICON);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(RFHelper.setDefaultEnergyTag(new ItemStack(this, 1, 0), 0));
		list.add(RFHelper.setDefaultEnergyTag(new ItemStack(this, 1, 0), this.capacity));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack container, EntityPlayer player, List list, boolean check) {
		if (container.stackTagCompound == null)
			RFHelper.setDefaultEnergyTag(container, 0);

		list.add(RFHelper.moreInfo);

		if (KeyboardHelper.isShiftDown())
			list.add("Charge: " + RFHelper.yellowItalics + RFHelper.getRFStored(container) + "/" + capacity + " RF");
	}

	@Override
	public int getMaxDamage(ItemStack container) {
		return this.capacity + 1;
	}

	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public int getDisplayDamage(ItemStack container) {
		if (container.stackTagCompound == null)
			RFHelper.setDefaultEnergyTag(container, 0);

		return (this.capacity + 1 - RFHelper.getRFStored(container));
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		return RFHelper.receiveEnergy(container, maxReceive, simulate, this.capacity, this.transferLimit);
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		return RFHelper.extractEnergy(container, maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return RFHelper.getRFStored(container);
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return capacity;
	}

	@Override
	public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {
		return false;
	}

	public int useEnergy(ItemStack container, boolean simulate) {
		int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, container);
		return extractEnergy(container, (this.cost - (unbreaking * 10)), simulate);
		// if (PLACEEMPOWEREDTHINGHERE == false) {
		// return extractEnergy(container, (this.cost - (unbreaking * 10)), simulate);
		// } else {
		// return extractEnergy(container, (this.empoweredCost - (unbreaking * 10)), simulate);
		// }
	}

	public int getUsedEnergy(ItemStack container) {
		int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, container);
		return (this.cost - (unbreaking * 10));
	}

	@Override
	public boolean onBlockDestroyed(ItemStack container, World world, Block block, int par4, int par5, int par6, EntityLivingBase entityLiving) {
		useEnergy(container, false);
		return true;
	}
	
	@Override
	public float getDigSpeed(ItemStack container, Block block, int meta) {
		return meta;
	}

	@Override
	public boolean hitEntity(ItemStack container, EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (getEnergyStored(container) < getUsedEnergy(container)) {
			entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 5.0F);
			useEnergy(container, false);
		}
		return false;
	}
}

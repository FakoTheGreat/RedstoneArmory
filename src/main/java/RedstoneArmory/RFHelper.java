package RedstoneArmory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class RFHelper {

	public static ItemStack setDefaultEnergyTag(ItemStack container, int energy) {
		container.setTagCompound(new NBTTagCompound());
		container.stackTagCompound.setInteger("Energy", energy);
		return container;
	}

	public static int getEnergyStored(ItemStack container) {
		int energyStored = container.stackTagCompound.getInteger("Energy");
		return energyStored;
	}

	public static ItemStack setEnergy(ItemStack container, int energy) {
		container.stackTagCompound.setInteger("Energy", energy);
		return container;
	}
}

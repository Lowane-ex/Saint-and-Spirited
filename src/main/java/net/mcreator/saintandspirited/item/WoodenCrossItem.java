
package net.mcreator.saintandspirited.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.saintandspirited.itemgroup.SaintandSpiritedItemGroup;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;

import java.util.List;

@SaintAndSpiritedModElements.ModElement.Tag
public class WoodenCrossItem extends SaintAndSpiritedModElements.ModElement {
	@ObjectHolder("saint_and_spirited:wooden_cross")
	public static final Item block = null;
	public WoodenCrossItem(SaintAndSpiritedModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SaintandSpiritedItemGroup.tab).maxDamage(1).rarity(Rarity.UNCOMMON));
			setRegistryName("wooden_cross");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Last hope"));
		}
	}
}

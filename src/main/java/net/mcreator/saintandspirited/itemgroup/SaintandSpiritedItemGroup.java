
package net.mcreator.saintandspirited.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.saintandspirited.item.Holyrelic3Item;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;

@SaintAndSpiritedModElements.ModElement.Tag
public class SaintandSpiritedItemGroup extends SaintAndSpiritedModElements.ModElement {
	public SaintandSpiritedItemGroup(SaintAndSpiritedModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsaintand_spirited") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Holyrelic3Item.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}

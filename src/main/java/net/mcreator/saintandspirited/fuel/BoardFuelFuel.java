
package net.mcreator.saintandspirited.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.saintandspirited.item.BoardItem;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;

@SaintAndSpiritedModElements.ModElement.Tag
public class BoardFuelFuel extends SaintAndSpiritedModElements.ModElement {
	public BoardFuelFuel(SaintAndSpiritedModElements instance) {
		super(instance, 14);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(BoardItem.block, (int) (1)).getItem())
			event.setBurnTime(200);
	}
}

package net.mcreator.saintandspirited.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.saintandspirited.item.WoodenCrossItem;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;
import net.mcreator.saintandspirited.SaintAndSpiritedMod;

import java.util.Map;
import java.util.HashMap;

@SaintAndSpiritedModElements.ModElement.Tag
public class WoodenCrossItemInInventoryTickProcedure extends SaintAndSpiritedModElements.ModElement {
	public WoodenCrossItemInInventoryTickProcedure(SaintAndSpiritedModElements instance) {
		super(instance, 15);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaintAndSpiritedMod.LOGGER.warn("Failed to load dependency entity for procedure WoodenCrossItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double diamonds = 0;
		double generator_distance = 0;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 2)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(WoodenCrossItem.block, (int) (1));
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 0));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}

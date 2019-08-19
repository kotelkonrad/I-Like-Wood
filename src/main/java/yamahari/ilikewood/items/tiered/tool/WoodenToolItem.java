package yamahari.ilikewood.items.tiered.tool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.items.tiered.WoodenTieredItem;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;
import yamahari.ilikewood.util.WoodType;

import java.util.Set;

public class WoodenToolItem extends WoodenTieredItem {
    private final Set<ToolType> toolTypes;
    private final Set<Block> effectiveBlocks;

    public WoodenToolItem(WoodType woodType, WoodenItemTier woodenItemTier, WoodenTieredItemType woodenTieredItemType, Set<Block> effectiveBlocks, ToolType toolType, Item.Properties properties) {
        super(woodType, woodenItemTier, woodenTieredItemType, properties);
        this.effectiveBlocks = effectiveBlocks;
        this.toolTypes = ImmutableSet.of(toolType);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (getToolTypes(stack).stream().anyMatch(state::isToolEffective))
            return this.getWoodenItemTier().getEfficiency();
        return this.effectiveBlocks.contains(state.getBlock()) ? this.getWoodenItemTier().getEfficiency() : 1.0F;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        itemStack.damageItem(2, attacker, (livingEntity) -> {
            livingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, BlockState blockState, BlockPos blockPos, LivingEntity entityLiving) {
        if (!world.isRemote && blockState.getBlockHardness(world, blockPos) != 0.0F) {
            itemStack.damageItem(1, entityLiving, (livingEntity) -> {
                livingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlotType) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (ILikeWood.SERVER_CONFIG_LOADED && equipmentSlotType == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", this.getAttackSpeed(), AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Set<ToolType> getToolTypes(ItemStack itemStack) {
        return this.toolTypes;
    }
}

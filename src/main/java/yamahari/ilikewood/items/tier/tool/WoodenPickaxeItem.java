package yamahari.ilikewood.items.tier.tool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.items.tier.IWoodenTieredItem;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;

public class WoodenPickaxeItem extends PickaxeItem implements IWooden, IWoodenTieredItem {
    private final WoodType woodType;
    private final WoodenItemTier woodenItemTier;

    public WoodenPickaxeItem(WoodType woodType, WoodenItemTier woodenItemTier) {
        super(ItemTier.WOOD, 0, 0.f, (new Item.Properties()).group(ItemGroup.TOOLS));
        this.woodType = woodType;
        this.woodenItemTier = woodenItemTier;
        this.setRegistryName(this.getWoodType().getModId(), (this.getWoodenItemTier().isWood() ? "" : (this.getWoodenItemTier().getName() + "_")) + this.getWoodType().getName() + "_" + this.getWoodenTieredItemType().getName());
    }

    @Override
    public WoodenItemTier getWoodenItemTier() {
        return this.woodenItemTier;
    }

    @Override
    public WoodenTieredItemType getWoodenTieredItemType() {
        return WoodenTieredItemType.PICKAXE;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public IItemTier getTier() {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier() : ItemTier.WOOD;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int getHarvestLevel(ItemStack itemStack, ToolType toolType, @Nullable PlayerEntity playerEntity, @Nullable BlockState blockState) {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getHarvestLevel() : super.getHarvestLevel(itemStack, toolType, playerEntity, blockState);
    }

    @SuppressWarnings("NullableProblems")
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (ILikeWood.SERVER_CONFIG_LOADED) {
            Material material = state.getMaterial();
            boolean flag = material != Material.IRON && material != Material.ANVIL && material != Material.ROCK;
            return getToolTypes(stack).stream().anyMatch(state::isToolEffective) || !flag ? this.getWoodenItemTier().getEfficiency() : 1.f;
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public int getItemEnchantability() {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getEnchantability() : ItemTier.WOOD.getEnchantability();
    }

    @Override
    public boolean isDamageable() {
        return this.getMaxDamage(null) > 0;
    }

    @Override
    public int getMaxDamage(@Nullable ItemStack stack) {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getMaxUses() : ItemTier.WOOD.getMaxUses();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean getIsRepairable(ItemStack itemStack0, ItemStack itemStack1) {
        return this.getWoodenItemTier().getRepairMaterial().test(itemStack1);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getBurnTime() : super.getBurnTime(itemStack);
    }

    public float getAttackDamage() {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getAttackDamage() + this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getAttackDamage() : 0.f;
    }

    public float getAttackSpeed() {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getAttackSpeed() : 0.f;
    }

    @SuppressWarnings({"NullableProblems"})
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlotType) {
        Multimap<String, AttributeModifier> attributeModifiers = HashMultimap.create();
        if (ILikeWood.SERVER_CONFIG_LOADED && equipmentSlotType == EquipmentSlotType.MAINHAND) {
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", this.getAttackSpeed(), AttributeModifier.Operation.ADDITION));
        }
        return attributeModifiers;
    }
}

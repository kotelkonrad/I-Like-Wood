package yamahari.ilikewood.items.tiered;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;

public class WoodenTieredItem extends Item implements IWooden {
    private final WoodType woodType;
    private final WoodenTieredItemType woodenTieredItemType;
    private final WoodenItemTier woodenItemTier;

    public WoodenTieredItem(WoodType woodType, WoodenItemTier woodenItemTier, WoodenTieredItemType woodenTieredItemType, Item.Properties properties) {
        super(properties);
        this.woodenItemTier = woodenItemTier;
        this.woodenTieredItemType = woodenTieredItemType;
        this.woodType = woodType;
        this.setRegistryName(this.getWoodType().getModId(), (this.getWoodenItemTier().isWood() ? "" : (this.getWoodenItemTier().getName() + "_")) + this.getWoodType().getName() + "_" + this.getWoodenTieredItemType().getName());
    }

    @Override
    public boolean isDamageable() {
        return this.getMaxDamage(null) > 0;
    }

    @Override
    public int getItemEnchantability() {
        return this.getWoodenItemTier().getEnchantability();
    }

    @Override
    public int getMaxDamage(@Nullable ItemStack stack) {
        return this.getWoodenItemTier().getMaxUses();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int getHarvestLevel(ItemStack itemStack, ToolType toolType, @Nullable PlayerEntity playerEntity, @Nullable BlockState blockState) {
        return this.getWoodenItemTier().getHarvestLevel();
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack0, ItemStack itemStack1) {
        return this.getWoodenItemTier().getRepairMaterial().test(itemStack1) || super.getIsRepairable(itemStack0, itemStack1);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getBurnTime();
    }

    public float getAttackDamage() {
        return this.getWoodenItemTier().getAttackDamage() + this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getAttackDamage();
    }

    public float getAttackSpeed() {
        return this.getWoodenItemTier().getTieredItemProperties(this.getWoodenTieredItemType()).getAttackSpeed();
    }

    public WoodenTieredItemType getWoodenTieredItemType() {
        return woodenTieredItemType;
    }

    public WoodenItemTier getWoodenItemTier() {
        return this.woodenItemTier;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @SuppressWarnings({"NullableProblems", "deprecation"})
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlotType) {
        Multimap<String, AttributeModifier> attributeModifiers = HashMultimap.create();
        if (ILikeWood.COMMON_CONFIG_LOADED && equipmentSlotType == EquipmentSlotType.MAINHAND) {
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.getAttackSpeed(), AttributeModifier.Operation.ADDITION));
        }
        return attributeModifiers;
    }
}

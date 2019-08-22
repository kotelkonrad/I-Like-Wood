package yamahari.ilikewood.items.tier;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;

public class WoodenHoeItem extends HoeItem implements IWooden, IWoodenTieredItem {
    private final WoodType woodType;
    private final WoodenItemTier woodenItemTier;

    public WoodenHoeItem(WoodType woodType, WoodenItemTier woodenItemTier) {
        super(ItemTier.WOOD, 0.f, (new Item.Properties()).group(ItemGroup.TOOLS));
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
        return WoodenTieredItemType.HOE;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public IItemTier getTier() {
        return this.getWoodenItemTier();
    }

    @Override
    public int getItemEnchantability() {
        return this.getWoodenItemTier().getEnchantability();
    }

    @Override
    public boolean isDamageable() {
        return this.getMaxDamage(null) > 0;
    }

    @Override
    public int getMaxDamage(@Nullable ItemStack stack) {
        return this.getWoodenItemTier().getMaxUses();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean getIsRepairable(ItemStack itemStack0, ItemStack itemStack1) {
        return this.getWoodenItemTier().getRepairMaterial().test(itemStack1);
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

    @SuppressWarnings({"NullableProblems"})
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlotType) {
        Multimap<String, AttributeModifier> attributeModifiers = HashMultimap.create();
        if (ILikeWood.SERVER_CONFIG_LOADED && equipmentSlotType == EquipmentSlotType.MAINHAND) {
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
            attributeModifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.getAttackSpeed(), AttributeModifier.Operation.ADDITION));
        }
        return attributeModifiers;
    }
}

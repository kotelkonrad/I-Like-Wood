package yamahari.ilikewood.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.LazyLoadBase;
import yamahari.ilikewood.util.TieredItemType;

import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class WoodenItemTier implements IItemTier, IStringSerializable {
    private final String name;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;
    private final Map<TieredItemType, TieredItemProperties> tieredItemProperties;

    public WoodenItemTier(String name, int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial, Map<TieredItemType, TieredItemProperties> tieredItemProperties) {
        this.name = name;
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.tieredItemProperties = tieredItemProperties;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public TieredItemProperties getTieredItemProperties(TieredItemType tieredItemType) {
        return tieredItemProperties.getOrDefault(tieredItemType, new TieredItemProperties(0.f, 0.f));
    }

    public static class TieredItemProperties {
        private final float attackSpeed;
        private final float attackDamage;

        public TieredItemProperties(float attackSpeed, float attackDamage) {
            this.attackSpeed = attackSpeed;
            this.attackDamage = attackDamage;
        }

        public float getAttackSpeed() {
            return attackSpeed;
        }

        public float getAttackDamage() {
            return attackDamage;
        }
    }
}

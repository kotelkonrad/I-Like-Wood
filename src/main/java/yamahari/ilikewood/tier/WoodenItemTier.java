package yamahari.ilikewood.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.LazyLoadBase;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class WoodenItemTier implements IItemTier, IStringSerializable {
    private final String name;
    private final boolean wood;
    private final Supplier<Integer> harvestLevel;
    private final Supplier<Integer> maxUses;
    private final Supplier<Double> efficiency;
    private final Supplier<Double> attackDamage;
    private final Supplier<Integer> enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;
    private final Map<WoodenTieredItemType, TieredItemProperties> tieredItemProperties;

    public WoodenItemTier(String name, boolean wood, Supplier<Integer> harvestLevel, Supplier<Integer> maxUses, Supplier<Double> efficiency, Supplier<Double> attackDamage, Supplier<Integer> enchantability, Supplier<Ingredient> repairMaterial, Map<WoodenTieredItemType, TieredItemProperties> tieredItemProperties) {
        this.name = name;
        this.wood = wood;
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

    public boolean isWood() {
        return this.wood;
    }

    @Override
    public int getMaxUses() {
        return this.maxUses.get();
    }

    @Override
    public float getEfficiency() {
        return this.efficiency.get().floatValue();
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage.get().floatValue();
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel.get();
    }

    @Override
    public int getEnchantability() {
        return this.enchantability.get();
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public TieredItemProperties getTieredItemProperties(WoodenTieredItemType woodenTieredItemType) {
        return tieredItemProperties.getOrDefault(woodenTieredItemType, new TieredItemProperties(() -> 0.0, () -> 0.0, null));
    }

    public static class TieredItemProperties {
        private final Supplier<Double> attackSpeed;
        private final Supplier<Double> attackDamage;
        private final Supplier<Integer> burnTime;

        public TieredItemProperties(Supplier<Double> attackSpeed, Supplier<Double> attackDamage, @Nullable Supplier<Integer> burnTime) {
            this.attackSpeed = attackSpeed;
            this.attackDamage = attackDamage;
            this.burnTime = Optional.ofNullable(burnTime).orElse(() -> -1);
        }

        public float getAttackSpeed() {
            return this.attackSpeed.get().floatValue();
        }

        public float getAttackDamage() {
            return this.attackDamage.get().floatValue();
        }

        public int getBurnTime() {
            return this.burnTime.get();
        }
    }
}

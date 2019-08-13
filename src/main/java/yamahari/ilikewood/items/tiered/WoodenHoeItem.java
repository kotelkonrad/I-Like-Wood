package yamahari.ilikewood.items.tiered;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.TieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenHoeItem extends HoeItem implements IWooden {
    private final WoodType woodType;
    private final float attackSpeed;
    private final float attackDamage;

    private WoodenHoeItem(WoodType woodType, IItemTier itemTier, float attackDamage, float attackSpeed) {
        super(itemTier, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.woodType = woodType;
    }


    public static WoodenHoeItem build(WoodType woodType, WoodenItemTier woodenItemTier) {
        WoodenItemTier.TieredItemProperties tieredItemProperties =
                woodenItemTier.getTieredItemProperties(TieredItemType.HOE);

        return new WoodenHoeItem(
                woodType,
                woodenItemTier,
                tieredItemProperties.getAttackDamage(),
                tieredItemProperties.getAttackSpeed()
        );
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}

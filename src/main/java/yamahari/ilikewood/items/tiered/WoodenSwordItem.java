package yamahari.ilikewood.items.tiered;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.TieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenSwordItem extends SwordItem implements IWooden {
    private final WoodType woodType;

    private WoodenSwordItem(WoodType woodType, IItemTier itemTier, float attackDamage, float attackSpeed) {
        super(itemTier, (int)attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT));
        this.woodType = woodType;
    }

    public static WoodenSwordItem build(WoodType woodType, WoodenItemTier woodenItemTier) {
        WoodenItemTier.TieredItemProperties tieredItemProperties =
                woodenItemTier.getTieredItemProperties(TieredItemType.SWORD);

        return new WoodenSwordItem(
                woodType,
                woodenItemTier,
                tieredItemProperties.getAttackDamage(),
                tieredItemProperties.getAttackSpeed()
        );
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}

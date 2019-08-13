package yamahari.ilikewood.items.tiered;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.TieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenShovelItem extends ShovelItem implements IWooden {
    private final WoodType woodType;

    private WoodenShovelItem(WoodType woodType, WoodenItemTier tier, float attackDamage, float attackSpeed) {
        super(tier, attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.woodType = woodType;
    }

    public static WoodenShovelItem build(WoodType woodType, WoodenItemTier woodenItemTier) {
        WoodenItemTier.TieredItemProperties tieredItemProperties =
                woodenItemTier.getTieredItemProperties(TieredItemType.SHOVEL);

        return new WoodenShovelItem(
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

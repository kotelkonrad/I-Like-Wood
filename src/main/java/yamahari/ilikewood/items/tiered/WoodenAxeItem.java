package yamahari.ilikewood.items.tiered;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.TieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenAxeItem extends AxeItem implements IWooden {
    private final WoodType woodType;

    private WoodenAxeItem(WoodType woodType, IItemTier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().group(ItemGroup.TOOLS));
        this.woodType = woodType;
    }

    public static WoodenAxeItem build(WoodType woodType, WoodenItemTier woodenItemTier) {
        WoodenItemTier.TieredItemProperties tieredItemProperties =
                woodenItemTier.getTieredItemProperties(TieredItemType.AXE);

        return new WoodenAxeItem(
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

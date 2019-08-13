package yamahari.ilikewood.items.tiered;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.TieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenPickaxeItem extends PickaxeItem implements IWooden {
    private final WoodType woodType;

    private WoodenPickaxeItem(WoodType woodType, IItemTier tier, float attackDamage, float attackSpeed) {
        super(tier, (int)attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.woodType = woodType;

    }

    public static WoodenPickaxeItem build(WoodType woodType, WoodenItemTier woodenItemTier) {
        WoodenItemTier.TieredItemProperties tieredItemProperties =
                woodenItemTier.getTieredItemProperties(TieredItemType.PICKAXE);

        return new WoodenPickaxeItem(
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

package yamahari.ilikewood.items.tier;

import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;

public interface IWoodenTieredItem {
    WoodenItemTier getWoodenItemTier();

    WoodenTieredItemType getWoodenTieredItemType();
}

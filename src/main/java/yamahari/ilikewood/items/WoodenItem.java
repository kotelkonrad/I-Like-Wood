package yamahari.ilikewood.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

public class WoodenItem extends Item implements IWooden {
    private final WoodType woodType;
    private final WoodenObjectType woodenObjectType;

    public WoodenItem(WoodType woodType, WoodenObjectType woodenObjectType, Item.Properties properties) {
        super(properties);
        this.woodType = woodType;
        this.woodenObjectType = woodenObjectType;
    }

    public WoodenObjectType getWoodenObjectType() {
        return this.woodenObjectType;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodType().getWoodTypeProperties(this.getWoodenObjectType()).getBurnTime() : super.getBurnTime(itemStack);
    }
}

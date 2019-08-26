package yamahari.ilikewood.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

import java.util.Objects;

public class WoodenBlockItem extends BlockItem implements IWooden {
    private final WoodenObjectType woodenObjectType;

    public WoodenBlockItem(Block block, WoodenObjectType woodenObjectType, Item.Properties properties) {
        super(block, properties);
        this.woodenObjectType = woodenObjectType;
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    public WoodenObjectType getWoodenObjectType() {
        return this.woodenObjectType;
    }

    @Override
    public WoodType getWoodType() {
        return ((IWooden) this.getBlock()).getWoodType();
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return ILikeWood.SERVER_CONFIG_LOADED ? this.getWoodType().getWoodTypeProperties(this.getWoodenObjectType()).getBurnTime() : super.getBurnTime(itemStack);
    }
}

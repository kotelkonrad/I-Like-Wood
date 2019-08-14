package yamahari.ilikewood.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenItemType;

import java.util.Objects;

public class WoodenBlockItem extends BlockItem implements IWooden {
    private final WoodenItemType woodenItemType;

    public WoodenBlockItem(Block block, WoodenItemType woodenItemType, Item.Properties properties) {
        super(block, properties);
        this.woodenItemType = woodenItemType;
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    public WoodenItemType getWoodenItemType() {
        return this.woodenItemType;
    }

    @Override
    public WoodType getWoodType() {
        return ((IWooden) this.getBlock()).getWoodType();
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.getWoodType().getWoodTypeProperties(this.getWoodenItemType()).getBurnTime();
    }
}

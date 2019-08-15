package yamahari.ilikewood.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenBlockType;

import java.util.Objects;

public class WoodenBlockItem extends BlockItem implements IWooden {
    private final WoodenBlockType woodenBlockType;

    public WoodenBlockItem(Block block, WoodenBlockType woodenBlockType, Item.Properties properties) {
        super(block, properties);
        this.woodenBlockType = woodenBlockType;
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    public WoodenBlockType getWoodenBlockType() {
        return this.woodenBlockType;
    }

    @Override
    public WoodType getWoodType() {
        return ((IWooden) this.getBlock()).getWoodType();
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.getWoodType().getWoodTypeProperties(this.getWoodenBlockType()).getBurnTime();
    }
}

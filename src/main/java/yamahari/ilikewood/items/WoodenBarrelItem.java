package yamahari.ilikewood.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.blocks.WoodenBarrelBlock;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenItemType;

import java.util.Objects;

public class WoodenBarrelItem extends BlockItem implements IWooden {
    public WoodenBarrelItem(WoodenBarrelBlock block) {
        super(block, (new Item.Properties()).group(ItemGroup.DECORATIONS));
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    @Override
    public WoodType getWoodType() {
        return ((WoodenBarrelBlock)this.getBlock()).getWoodType();
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.getWoodType().getWoodTypeProperties(WoodenItemType.BARREL).getBurnTime();
    }
}

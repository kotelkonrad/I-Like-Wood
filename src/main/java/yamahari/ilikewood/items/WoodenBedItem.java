package yamahari.ilikewood.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import yamahari.ilikewood.util.WoodenObjectType;

public class WoodenBedItem extends WoodenBlockItem {
    public WoodenBedItem(Block block) {
        super(block, WoodenObjectType.BED, (new Item.Properties()).group(ItemGroup.DECORATIONS));
    }

    @Override
    protected boolean placeBlock(BlockItemUseContext blockItemUseContext, BlockState blockState) {
        return blockItemUseContext.getWorld().setBlockState(blockItemUseContext.getPos(), blockState, 26);
    }
}

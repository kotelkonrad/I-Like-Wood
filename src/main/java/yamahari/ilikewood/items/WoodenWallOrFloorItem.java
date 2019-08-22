package yamahari.ilikewood.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IWorldReader;
import yamahari.ilikewood.util.WoodenObjectType;

import javax.annotation.Nullable;
import java.util.Map;

public class WoodenWallOrFloorItem extends WoodenBlockItem {
    private final Block wallBlock;

    public WoodenWallOrFloorItem(Block floorBlock, Block wallBlock, WoodenObjectType woodenObjectType, Item.Properties properties) {
        super(floorBlock, woodenObjectType, properties);
        this.wallBlock = wallBlock;
    }

    @Nullable
    @Override
    protected BlockState getStateForPlacement(BlockItemUseContext blockItemUseContext) {
        BlockState blockState0 = this.wallBlock.getStateForPlacement(blockItemUseContext);
        BlockState blockState1 = null;
        IWorldReader worldReader = blockItemUseContext.getWorld();
        BlockPos blockPos = blockItemUseContext.getPos();

        for (Direction direction : blockItemUseContext.getNearestLookingDirections()) {
            if (direction != Direction.UP) {
                BlockState blockState2 = direction == Direction.DOWN ? this.getBlock().getStateForPlacement(blockItemUseContext) : blockState0;
                if (blockState2 != null && blockState2.isValidPosition(worldReader, blockPos)) {
                    blockState1 = blockState2;
                    break;
                }
            }
        }
        return blockState1 != null && worldReader.func_217350_a(blockState1, blockPos, ISelectionContext.dummy()) ? blockState1 : null;
    }

    @Override
    public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        super.addToBlockToItemMap(blockToItemMap, itemIn);
        blockToItemMap.put(this.wallBlock, itemIn);
    }

    @Override
    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        super.removeFromBlockToItemMap(blockToItemMap, itemIn);
        blockToItemMap.remove(this.wallBlock);
    }
}

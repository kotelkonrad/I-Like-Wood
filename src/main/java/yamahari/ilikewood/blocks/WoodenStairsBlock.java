package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

public class WoodenStairsBlock extends StairsBlock implements IWooden {
    private final WoodType woodType;

    public WoodenStairsBlock(WoodType woodType, BlockState blockState, Block.Properties properties) {
        super(blockState, properties);
        this.woodType = woodType;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}

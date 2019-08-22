package yamahari.ilikewood.blocks.post;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

import java.util.function.Supplier;


public class WoodenPostBlock extends WoodenStrippedPostBlock {
    private final LazyLoadBase<Block> STRIPPED;

    public WoodenPostBlock(WoodType woodType, Supplier<Block> stripped) {
        super(woodType);
        this.STRIPPED = new LazyLoadBase<>(stripped);
        this.setRegistryName(Constants.MOD_ID, this.getWoodType().getName() + "_" + WoodenObjectType.POST.getName());
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult p_220051_6_) {
        Item held = playerEntity.getHeldItem(hand).getItem();
        if (hand == Hand.MAIN_HAND && held instanceof AxeItem) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote()) {
                world.setBlockState(blockPos, STRIPPED.getValue().getDefaultState().with(RotatedPillarBlock.AXIS, blockState.get(RotatedPillarBlock.AXIS)).with(WoodenStrippedPostBlock.WATERLOGGED, blockState.get(WoodenStrippedPostBlock.WATERLOGGED)).with(WoodenStrippedPostBlock.DOWN, blockState.get(WoodenStrippedPostBlock.DOWN)).with(WoodenStrippedPostBlock.UP, blockState.get(WoodenStrippedPostBlock.UP)).with(WoodenStrippedPostBlock.NORTH, blockState.get(WoodenStrippedPostBlock.NORTH)).with(WoodenStrippedPostBlock.EAST, blockState.get(WoodenStrippedPostBlock.EAST)).with(WoodenStrippedPostBlock.SOUTH, blockState.get(WoodenStrippedPostBlock.SOUTH)).with(WoodenStrippedPostBlock.WEST, blockState.get(WoodenStrippedPostBlock.WEST)), 11);
                playerEntity.getHeldItem(hand).attemptDamageItem(1, world.rand, (ServerPlayerEntity) playerEntity);
            }
            return true;
        }
        return false;
    }
}

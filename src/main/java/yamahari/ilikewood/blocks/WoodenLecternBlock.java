package yamahari.ilikewood.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import yamahari.ilikewood.tilenentities.WoodenLecternTileEntity;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings({"NullableProblems", "deprecation"})
public class WoodenLecternBlock extends ContainerBlock implements IWooden {
    public static final DirectionProperty FACING;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty HAS_BOOK;
    public static final VoxelShape field_220159_d;
    public static final VoxelShape field_220160_e;
    public static final VoxelShape DEFAULT_SHAPE;
    public static final VoxelShape field_220162_g;
    public static final VoxelShape COLLISION_SHAPE;
    public static final VoxelShape FACING_WEST_SHAPE;
    public static final VoxelShape FACING_NORTH_SHAPE;
    public static final VoxelShape FACING_EAST_SHAPE;
    public static final VoxelShape FACING_SOUTH_SHAPE;

    private final WoodType woodType;
    private final LazyLoadBase<TileEntityType<WoodenLecternTileEntity>> tileEntityType;

    static {
        FACING = HorizontalBlock.HORIZONTAL_FACING;
        POWERED = BlockStateProperties.POWERED;
        HAS_BOOK = BlockStateProperties.HAS_BOOK;
        field_220159_d = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
        field_220160_e = Block.makeCuboidShape(4.0D, 2.0D, 4.0D, 12.0D, 14.0D, 12.0D);
        DEFAULT_SHAPE = VoxelShapes.or(field_220159_d, field_220160_e);
        field_220162_g = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 15.0D, 16.0D);
        COLLISION_SHAPE = VoxelShapes.or(DEFAULT_SHAPE, field_220162_g);
        FACING_WEST_SHAPE = VoxelShapes.or(Block.makeCuboidShape(1.0D, 10.0D, 0.0D, 5.333333D, 14.0D, 16.0D), Block.makeCuboidShape(5.333333D, 12.0D, 0.0D, 9.666667D, 16.0D, 16.0D), Block.makeCuboidShape(9.666667D, 14.0D, 0.0D, 14.0D, 18.0D, 16.0D), DEFAULT_SHAPE);
        FACING_NORTH_SHAPE = VoxelShapes.or(Block.makeCuboidShape(0.0D, 10.0D, 1.0D, 16.0D, 14.0D, 5.333333D), Block.makeCuboidShape(0.0D, 12.0D, 5.333333D, 16.0D, 16.0D, 9.666667D), Block.makeCuboidShape(0.0D, 14.0D, 9.666667D, 16.0D, 18.0D, 14.0D), DEFAULT_SHAPE);
        FACING_EAST_SHAPE = VoxelShapes.or(Block.makeCuboidShape(15.0D, 10.0D, 0.0D, 10.666667D, 14.0D, 16.0D), Block.makeCuboidShape(10.666667D, 12.0D, 0.0D, 6.333333D, 16.0D, 16.0D), Block.makeCuboidShape(6.333333D, 14.0D, 0.0D, 2.0D, 18.0D, 16.0D), DEFAULT_SHAPE);
        FACING_SOUTH_SHAPE = VoxelShapes.or(Block.makeCuboidShape(0.0D, 10.0D, 15.0D, 16.0D, 14.0D, 10.666667D), Block.makeCuboidShape(0.0D, 12.0D, 10.666667D, 16.0D, 16.0D, 6.333333D), Block.makeCuboidShape(0.0D, 14.0D, 6.333333D, 16.0D, 18.0D, 2.0D), DEFAULT_SHAPE);
    }

    public TileEntityType<WoodenLecternTileEntity> getTileEntityType() {
        return this.tileEntityType.getValue();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader blockReader) {
        return this.getTileEntityType().create();
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }

    public WoodenLecternBlock(WoodType woodType, Supplier<TileEntityType<WoodenLecternTileEntity>> tileEntityType) {
        super(Block.Properties.from(Blocks.LECTERN));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(POWERED, false).with(HAS_BOOK, false));
        this.woodType = woodType;
        this.tileEntityType = new LazyLoadBase<>(tileEntityType);
        this.setRegistryName(woodType.getModId(), woodType.getName() + "_" + WoodenObjectType.LECTERN.getName());
    }

    @Override
    public boolean func_220074_n(BlockState blockState) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext blockItemUseContext) {
        return this.getDefaultState().with(FACING, blockItemUseContext.getPlacementHorizontalFacing().getOpposite());
    }

    private static boolean tryPlaceBook(World world, BlockPos blockPos, BlockState blockState, ItemStack itemStack) {
        if (!blockState.get(HAS_BOOK)) {
            if (!world.isRemote) {
                placeBook(world, blockPos, blockState, itemStack);
            }
            return true;
        } else {
            return false;
        }
    }

    private static void placeBook(World world, BlockPos blockPos, BlockState blockState, ItemStack itemStack) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (tileEntity instanceof WoodenLecternTileEntity) {
            ((WoodenLecternTileEntity) tileEntity).func_214045_a(itemStack.split(1));
            setHasBook(world, blockPos, blockState, true);
            world.playSound(null, blockPos, SoundEvents.ITEM_BOOK_PUT, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.with(FACING, rotation.rotate(blockState.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.toRotation(blockState.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, HAS_BOOK);
    }

    @Override
    public void tick(BlockState blockState, World world, BlockPos blockPos, Random random) {
        if (!world.isRemote) {
            setPowered(world, blockPos, blockState, false);
        }
    }

    @Override
    public void onReplaced(BlockState blockState, World world, BlockPos blockPos, BlockState blockState1, boolean p_196243_5_) {
        if (blockState.getBlock() != blockState1.getBlock()) {
            if (blockState.get(HAS_BOOK)) {
                this.func_220150_d(blockState, world, blockPos);
            }

            if (blockState.get(POWERED)) {
                world.notifyNeighborsOfStateChange(blockPos.down(), this);
            }

            super.onReplaced(blockState, world, blockPos, blockState1, p_196243_5_);
        }
    }

    private void func_220150_d(BlockState blockState, World world, BlockPos blockPos) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (tileEntity instanceof WoodenLecternTileEntity) {
            WoodenLecternTileEntity woodenLecternTileEntity = (WoodenLecternTileEntity) tileEntity;
            Direction direction = blockState.get(FACING);
            ItemStack itemStack = woodenLecternTileEntity.getBook().copy();
            float lvt_8_1_ = 0.25F * (float) direction.getXOffset();
            float lvt_9_1_ = 0.25F * (float) direction.getZOffset();
            ItemEntity itemEntity = new ItemEntity(world, (double) blockPos.getX() + 0.5D + (double) lvt_8_1_, blockPos.getY() + 1, (double) blockPos.getZ() + 0.5D + (double) lvt_9_1_, itemStack);
            itemEntity.setDefaultPickupDelay();
            world.addEntity(itemEntity);
            woodenLecternTileEntity.clear();
        }

    }

    @Override
    public boolean canProvidePower(BlockState blockState) {
        return true;
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, Direction direction) {
        return blockState.get(POWERED) ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, Direction direction) {
        return direction == Direction.UP && blockState.get(POWERED) ? 15 : 0;
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState blockState) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World world, BlockPos blockPos) {
        if (blockState.get(HAS_BOOK)) {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof WoodenLecternTileEntity) {
                return ((WoodenLecternTileEntity) tileEntity).func_214034_r();
            }
        }

        return 0;
    }

    public static void setHasBook(World world, BlockPos blockPos, BlockState blockState, boolean hasBook) {
        world.setBlockState(blockPos, blockState.with(POWERED, false).with(HAS_BOOK, hasBook), 3);
        notifyNeighbors(world, blockPos, blockState);
    }

    @Nullable
    @Override
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        return !blockState.get(HAS_BOOK) ? null : super.getContainer(blockState, world, blockPos);
    }

    private void func_220152_a(World world, BlockPos blockPos, PlayerEntity playerEntity) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (tileEntity instanceof WoodenLecternTileEntity) {
            playerEntity.openContainer((WoodenLecternTileEntity) tileEntity);
            playerEntity.addStat(Stats.INTERACT_WITH_LECTERN);
        }

    }

    @Override
    public boolean allowsMovement(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, PathType pathType) {
        return false;
    }

    public static void pulse(World world, BlockPos blockPos, BlockState blockState) {
        setPowered(world, blockPos, blockState, true);
        world.getPendingBlockTicks().scheduleTick(blockPos, blockState.getBlock(), 2);
        world.playEvent(1043, blockPos, 0);
    }

    private static void setPowered(World world, BlockPos blockPos, BlockState blockState, boolean powered) {
        world.setBlockState(blockPos, blockState.with(POWERED, powered), 3);
        notifyNeighbors(world, blockPos, blockState);
    }

    private static void notifyNeighbors(World world, BlockPos blockPos, BlockState blockState) {
        world.notifyNeighborsOfStateChange(blockPos.down(), blockState.getBlock());
    }

    @Override
    public VoxelShape getRenderShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos) {
        return DEFAULT_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        switch (blockState.get(FACING)) {
            case NORTH:
                return FACING_NORTH_SHAPE;
            case SOUTH:
                return FACING_SOUTH_SHAPE;
            case EAST:
                return FACING_EAST_SHAPE;
            case WEST:
                return FACING_WEST_SHAPE;
            default:
                return DEFAULT_SHAPE;
        }
    }

    @Override
    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if (blockState.get(HAS_BOOK)) {
            if (!world.isRemote) {
                this.func_220152_a(world, blockPos, playerEntity);
            }

            return true;
        } else {
            ItemStack held = playerEntity.getHeldItem(hand);
            Item item = held.getItem();
            if (hand == Hand.MAIN_HAND && (item instanceof WritableBookItem || item instanceof WrittenBookItem)) {
                return tryPlaceBook(world, blockPos, blockState, held);
            }
            return false;
        }
    }
}

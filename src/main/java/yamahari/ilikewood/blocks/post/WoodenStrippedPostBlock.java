package yamahari.ilikewood.blocks.post;

import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import java.util.Map;

public class WoodenStrippedPostBlock extends RotatedPillarBlock implements IWooden, IWaterLoggable {
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final BooleanProperty UP;
    public static final BooleanProperty DOWN;
    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape WOODEN_POST_VERTICAL_AABB = Block.makeCuboidShape(4.f, 0.f, 4.f, 12.f, 16.f, 12.f);
    private static final VoxelShape WOODEN_POST_NS_AABB = Block.makeCuboidShape(4.f, 4.f, 0.f, 12.f, 12.f, 16.f);
    private static final VoxelShape WOODEN_POST_EW_AABB = Block.makeCuboidShape(0.f, 4.f, 4.f, 16.f, 12.f, 12.f);

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        NORTH = BlockStateProperties.NORTH;
        EAST = BlockStateProperties.EAST;
        SOUTH = BlockStateProperties.SOUTH;
        WEST = BlockStateProperties.WEST;
        UP = BlockStateProperties.UP;
        DOWN = BlockStateProperties.DOWN;
        FACING_TO_PROPERTY_MAP = Util.make(Maps.newEnumMap(Direction.class), (p_203421_0_) -> {
            p_203421_0_.put(Direction.NORTH, NORTH);
            p_203421_0_.put(Direction.EAST, EAST);
            p_203421_0_.put(Direction.SOUTH, SOUTH);
            p_203421_0_.put(Direction.WEST, WEST);
            p_203421_0_.put(Direction.UP, UP);
            p_203421_0_.put(Direction.DOWN, DOWN);
        });
    }

    private final WoodType woodType;

    public WoodenStrippedPostBlock(WoodType woodType) {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.f).sound(SoundType.WOOD));
        this.woodType = woodType;
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(WATERLOGGED, false).with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(UP, false).with(DOWN, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
    }

    @SuppressWarnings({"NullableProblems", "deprecation"})
    @Override
    public IFluidState getFluidState(BlockState blockState) {
        return blockState.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(blockState);
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @SuppressWarnings({"NullableProblems", "deprecation"})
    @Override
    public VoxelShape getShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        switch (blockState.get(AXIS)) {
            case X:
            default:
                return WOODEN_POST_EW_AABB;
            case Z:
                return WOODEN_POST_NS_AABB;
            case Y:
                return WOODEN_POST_VERTICAL_AABB;
        }
    }

    @SuppressWarnings({"NullableProblems", "deprecation"})
    @Override
    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        switch (blockState.get(AXIS)) {
            case X:
            default:
                return WOODEN_POST_EW_AABB;
            case Z:
                return WOODEN_POST_NS_AABB;
            case Y:
                return WOODEN_POST_VERTICAL_AABB;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext blockItemUseContext) {
        IBlockReader blockReader = blockItemUseContext.getWorld();
        BlockPos blockPos = blockItemUseContext.getPos();

        Block down = blockReader.getBlockState(blockPos.down()).getBlock();
        Block up = blockReader.getBlockState(blockPos.up()).getBlock();
        Block north = blockReader.getBlockState(blockPos.north()).getBlock();
        Block east = blockReader.getBlockState(blockPos.east()).getBlock();
        Block south = blockReader.getBlockState(blockPos.south()).getBlock();
        Block west = blockReader.getBlockState(blockPos.west()).getBlock();

        Direction.Axis axis = blockItemUseContext.getFace().getAxis();
        return this.getDefaultState().with(AXIS, blockItemUseContext.getFace().getAxis())
                .with(DOWN, down instanceof WoodenStrippedPostBlock && axis != Direction.Axis.Y)
                .with(UP, up instanceof WoodenStrippedPostBlock && axis != Direction.Axis.Y)
                .with(NORTH, north instanceof WoodenStrippedPostBlock && axis != Direction.Axis.Z)
                .with(EAST, east instanceof WoodenStrippedPostBlock && axis != Direction.Axis.X)
                .with(SOUTH, south instanceof WoodenStrippedPostBlock && axis != Direction.Axis.Z)
                .with(WEST, west instanceof WoodenStrippedPostBlock && axis != Direction.Axis.X);
    }

    @SuppressWarnings({"NullableProblems", "deprecation"})
    @Override
    public BlockState updatePostPlacement(BlockState blockState0, Direction direction, BlockState blockState1, IWorld world, BlockPos blockPos, BlockPos blockPos1) {
        Block block = blockState1.getBlock();
        boolean isFacing = block instanceof WoodenStrippedPostBlock && direction.getAxis() != blockState0.get(AXIS);
        return blockState0.with(FACING_TO_PROPERTY_MAP.get(direction), isFacing);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}

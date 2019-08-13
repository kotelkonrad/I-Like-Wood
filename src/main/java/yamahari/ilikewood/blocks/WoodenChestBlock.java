package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class WoodenChestBlock extends ChestBlock implements IWooden {
    private static final WoodenChestBlock.InventoryFactory<IInventory> field_220109_i;
    private static final WoodenChestBlock.InventoryFactory<INamedContainerProvider> field_220110_j;

    static {
        field_220109_i = new WoodenChestBlock.InventoryFactory<IInventory>() {
            public IInventory forDouble(WoodenChestTileEntity woodenChestTileEntity, WoodenChestTileEntity woodenChestTileEntity1) {
                return new DoubleSidedInventory(woodenChestTileEntity, woodenChestTileEntity1);
            }

            public IInventory forSingle(WoodenChestTileEntity woodenChestTileEntity) {
                return woodenChestTileEntity;
            }
        };
        field_220110_j = new WoodenChestBlock.InventoryFactory<INamedContainerProvider>() {
            public INamedContainerProvider forDouble(final WoodenChestTileEntity woodenChestTileEntity, final WoodenChestTileEntity woodenChestTileEntity1) {
                final IInventory lvt_3_1_ = new DoubleSidedInventory(woodenChestTileEntity, woodenChestTileEntity1);
                return new INamedContainerProvider() {
                    @Nullable
                    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
                        if (woodenChestTileEntity.canOpen(p_createMenu_3_) && woodenChestTileEntity1.canOpen(p_createMenu_3_)) {
                            woodenChestTileEntity.fillWithLoot(p_createMenu_2_.player);
                            woodenChestTileEntity1.fillWithLoot(p_createMenu_2_.player);
                            return ChestContainer.createGeneric9X6(p_createMenu_1_, p_createMenu_2_, lvt_3_1_);
                        } else {
                            return null;
                        }
                    }

                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("container.chestDouble");
                    }
                };
            }

            public INamedContainerProvider forSingle(WoodenChestTileEntity woodenChestTileEntity) {
                return woodenChestTileEntity;
            }
        };
    }

    private final WoodType woodType;
    private final Supplier<TileEntityType<WoodenChestTileEntity>> tileEntityType;

    public WoodenChestBlock(WoodType woodType, Supplier<TileEntityType<WoodenChestTileEntity>> tileEntityType) {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD));
        this.woodType = woodType;
        this.tileEntityType = tileEntityType;
        this.setRegistryName(woodType.getModId(), woodType.getName() + "_chest");
    }

    private static boolean isBlocked(IWorld world, BlockPos blockPos) {
        return isBelowSolidBlock(world, blockPos) || isCatSittingOn(world, blockPos);
    }

    private static boolean isBelowSolidBlock(IBlockReader blockReader, BlockPos blockPos) {
        BlockPos up = blockPos.up();
        return blockReader.getBlockState(up).isNormalCube(blockReader, up);
    }

    private static boolean isCatSittingOn(IWorld world, BlockPos blockPos) {
        List<CatEntity> catEntities = world.getEntitiesWithinAABB(CatEntity.class, new AxisAlignedBB(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), blockPos.getX() + 1, blockPos.getY() + 2, blockPos.getZ() + 1));
        for(CatEntity catEntity : catEntities) {
            if(catEntity.isSitting()) return true;
        }
        return false;
    }

    @Nullable
    public static <T> T makeContainer(BlockState blockState, IWorld world, BlockPos blockPos, boolean p_220106_3_, WoodenChestBlock.InventoryFactory<T> inventoryFactory) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (!(tileEntity instanceof WoodenChestTileEntity)) {
            return null;
        } else if (!p_220106_3_ && isBlocked(world, blockPos)) {
            return null;
        } else {
            WoodenChestTileEntity woodenChestTileEntity = (WoodenChestTileEntity)tileEntity;
            ChestType chestType = blockState.get(TYPE);
            if (chestType == ChestType.SINGLE) {
                return inventoryFactory.forSingle(woodenChestTileEntity);
            } else {
                BlockPos offset = blockPos.offset(getDirectionToAttached(blockState));
                BlockState offsetBlockState = world.getBlockState(offset);
                if (offsetBlockState.getBlock() == blockState.getBlock()) {
                    ChestType offsetChestType = offsetBlockState.get(TYPE);
                    if (offsetChestType != ChestType.SINGLE && chestType != offsetChestType && offsetBlockState.get(FACING) == blockState.get(FACING)) {
                        if (!p_220106_3_ && isBlocked(world, offset)) {
                            return null;
                        }

                        TileEntity offsetTileEntity = world.getTileEntity(offset);
                        if (offsetTileEntity instanceof WoodenChestTileEntity) {
                            return inventoryFactory.forDouble(
                                    chestType == ChestType.RIGHT ? woodenChestTileEntity : (WoodenChestTileEntity)offsetTileEntity,
                                    chestType == ChestType.RIGHT ? (WoodenChestTileEntity)offsetTileEntity : woodenChestTileEntity
                            );
                        }
                    }
                }
                return inventoryFactory.forSingle(woodenChestTileEntity);
            }
        }
    }

    @Nullable
    public static IInventory getInventory(BlockState blockState, World world, BlockPos blockPos, boolean p_220105_3_) {
        return makeContainer(blockState, world, blockPos, p_220105_3_, field_220109_i);
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @Override
    @Nullable
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        return makeContainer(blockState, world, blockPos, false, field_220110_j);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.hasDisplayName()) {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof WoodenChestTileEntity) {
                ((WoodenChestTileEntity)tileEntity).setCustomName(itemStack.getDisplayName());
            }
        }

    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World world, BlockPos blockPos) {
        return Container.calcRedstoneFromInventory(getInventory(blockState, world, blockPos, false));
    }

    public TileEntityType<WoodenChestTileEntity> getTileEntityType() {
        return this.tileEntityType.get();
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader blockReader) {
        return this.tileEntityType.get().create();
    }

    interface InventoryFactory<T> {
        T forDouble(WoodenChestTileEntity var1, WoodenChestTileEntity var2);

        T forSingle(WoodenChestTileEntity var1);
    }
}

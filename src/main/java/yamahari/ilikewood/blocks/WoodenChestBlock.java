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
import net.minecraft.util.LazyLoadBase;
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

@SuppressWarnings("NullableProblems")
public class WoodenChestBlock extends ChestBlock implements IWooden {
    private static final WoodenChestBlock.InventoryFactory<IInventory> I_INVENTORY_FACTORY;
    private static final WoodenChestBlock.InventoryFactory<INamedContainerProvider> I_NAMED_CONTAINER_PROVIDER_FACTORY;

    private final WoodType woodType;

    static {
        I_INVENTORY_FACTORY = new WoodenChestBlock.InventoryFactory<IInventory>() {
            @Override
            public IInventory forDouble(WoodenChestTileEntity woodenChestTileEntity, WoodenChestTileEntity woodenChestTileEntity1) {
                return new DoubleSidedInventory(woodenChestTileEntity, woodenChestTileEntity1);
            }

            @Override
            public IInventory forSingle(WoodenChestTileEntity woodenChestTileEntity) {
                return woodenChestTileEntity;
            }
        };
        I_NAMED_CONTAINER_PROVIDER_FACTORY = new WoodenChestBlock.InventoryFactory<INamedContainerProvider>() {
            @Override
            public INamedContainerProvider forDouble(final WoodenChestTileEntity woodenChestTileEntity, final WoodenChestTileEntity woodenChestTileEntity1) {
                final IInventory lvt_3_1_ = new DoubleSidedInventory(woodenChestTileEntity, woodenChestTileEntity1);
                return new INamedContainerProvider() {
                    @Nullable
                    @Override
                    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
                        if (woodenChestTileEntity.canOpen(p_createMenu_3_) && woodenChestTileEntity1.canOpen(p_createMenu_3_)) {
                            woodenChestTileEntity.fillWithLoot(p_createMenu_2_.player);
                            woodenChestTileEntity1.fillWithLoot(p_createMenu_2_.player);
                            return ChestContainer.createGeneric9X6(p_createMenu_1_, p_createMenu_2_, lvt_3_1_);
                        } else {
                            return null;
                        }
                    }

                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("container." + woodenChestTileEntity.getWoodType().getModId() + "." + woodenChestTileEntity.getWoodType().getName() + "_double_chest");
                    }
                };
            }

            @Override
            public INamedContainerProvider forSingle(WoodenChestTileEntity woodenChestTileEntity) {
                return woodenChestTileEntity;
            }
        };
    }

    private final LazyLoadBase<TileEntityType<WoodenChestTileEntity>> tileEntityType;

    public WoodenChestBlock(WoodType woodType, Supplier<TileEntityType<WoodenChestTileEntity>> tileEntityType) {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD));
        this.woodType = woodType;
        this.tileEntityType = new LazyLoadBase<>(tileEntityType);
        this.setRegistryName(woodType.getModId(), woodType.getName() + "_chest");
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }

    @Nullable
    public static IInventory getInventory(BlockState blockState, World world, BlockPos blockPos, boolean p_220105_3_) {
        return invokeFactory(blockState, world, blockPos, p_220105_3_, I_INVENTORY_FACTORY);
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

    private static boolean isBlocked(IWorld world, BlockPos blockPos) {
        return isBelowSolidBlock(world, blockPos) || isCatSittingOn(world, blockPos);
    }

    private static boolean isBelowSolidBlock(IBlockReader blockReader, BlockPos blockPos) {
        BlockPos up = blockPos.up();
        return blockReader.getBlockState(up).isNormalCube(blockReader, up);
    }


    @Nullable
    private static <T> T invokeFactory(BlockState blockState, IWorld world, BlockPos blockPos, boolean p_220106_3_, WoodenChestBlock.InventoryFactory<T> inventoryFactory) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (!(tileEntity instanceof WoodenChestTileEntity)) {
            return null;
        } else if (!p_220106_3_ && isBlocked(world, blockPos)) {
            return null;
        } else {
            WoodenChestTileEntity woodenChestTileEntity = (WoodenChestTileEntity) tileEntity;
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
                                    chestType == ChestType.RIGHT ? woodenChestTileEntity : (WoodenChestTileEntity) offsetTileEntity,
                                    chestType == ChestType.RIGHT ? (WoodenChestTileEntity) offsetTileEntity : woodenChestTileEntity
                            );
                        }
                    }
                }
                return inventoryFactory.forSingle(woodenChestTileEntity);
            }
        }
    }

    private static boolean isCatSittingOn(IWorld world, BlockPos blockPos) {
        List<CatEntity> catEntities = world.getEntitiesWithinAABB(CatEntity.class, new AxisAlignedBB(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), blockPos.getX() + 1, blockPos.getY() + 2, blockPos.getZ() + 1));
        for (CatEntity catEntity : catEntities) {
            if (catEntity.isSitting()) return true;
        }
        return false;
    }

    @Override
    @Nullable
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        return invokeFactory(blockState, world, blockPos, false, I_NAMED_CONTAINER_PROVIDER_FACTORY);
    }

    public TileEntityType<WoodenChestTileEntity> getTileEntityType() {
        return this.tileEntityType.getValue();
    }

    interface InventoryFactory<T> {
        T forDouble(WoodenChestTileEntity var1, WoodenChestTileEntity var2);

        T forSingle(WoodenChestTileEntity var1);
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader blockReader) {
        return this.getTileEntityType().create();
    }
}

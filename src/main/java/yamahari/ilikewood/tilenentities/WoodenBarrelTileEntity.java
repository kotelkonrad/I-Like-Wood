package yamahari.ilikewood.tilenentities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import yamahari.ilikewood.blocks.WoodenBarrelBlock;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

@SuppressWarnings("NullableProblems")
public class WoodenBarrelTileEntity extends LockableLootTileEntity implements IWooden {
    private NonNullList<ItemStack> barrelContents;
    private int openCount;

    public WoodenBarrelTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
        this.barrelContents = NonNullList.withSize(27, ItemStack.EMPTY);
    }

    @Override
    public CompoundNBT write(CompoundNBT compoundNBT) {
        super.write(compoundNBT);
        if (!this.checkLootAndWrite(compoundNBT)) {
            ItemStackHelper.saveAllItems(compoundNBT, this.barrelContents);
        }

        return compoundNBT;
    }

    @Override
    public void read(CompoundNBT compoundNBT) {
        super.read(compoundNBT);
        this.barrelContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compoundNBT)) {
            ItemStackHelper.loadAllItems(compoundNBT, this.barrelContents);
        }

    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.barrelContents) {
            if (!itemStack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.barrelContents.get(slot);
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        return ItemStackHelper.getAndSplit(this.barrelContents, slot, amount);
    }

    @Override
    public ItemStack removeStackFromSlot(int slot) {
        return ItemStackHelper.getAndRemove(this.barrelContents, slot);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.barrelContents.set(slot, itemStack);
        if (itemStack.getCount() > this.getInventoryStackLimit()) {
            itemStack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public void clear() {
        this.barrelContents.clear();
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.barrelContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.barrelContents = items;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + this.getWoodType().getModId() + "." + this.getWoodType().getName() + "_barrel");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory) {
        return ChestContainer.createGeneric9X3(id, playerInventory, this);
    }

    @Override
    public void openInventory(PlayerEntity playerEntity) {
        if (!playerEntity.isSpectator()) {
            if (this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            BlockState blockState = this.getBlockState();
            boolean open = blockState.get(WoodenBarrelBlock.PROPERTY_OPEN);
            if (!open) {
                this.playSoundEvent(blockState, SoundEvents.BLOCK_BARREL_OPEN);
                this.setOpenProperty(blockState, true);
            }

            this.scheduleTick();
        }

    }

    private void scheduleTick() {
        if (this.world != null) {
            this.world.getPendingBlockTicks().scheduleTick(this.getPos(), this.getBlockState().getBlock(), 5);
        }
    }

    public void tick() {
        if (this.world != null) {
            this.openCount = ChestTileEntity.func_213976_a(this.world, this, this.pos.getX(), this.pos.getY(), this.pos.getZ());
        }
        if (this.openCount > 0) {
            this.scheduleTick();
        } else {
            BlockState blockState = this.getBlockState();
            if (!(blockState.getBlock() instanceof WoodenBarrelBlock)) {
                this.remove();
                return;
            }

            boolean open = blockState.get(WoodenBarrelBlock.PROPERTY_OPEN);
            if (open) {
                this.playSoundEvent(blockState, SoundEvents.BLOCK_BARREL_CLOSE);
                this.setOpenProperty(blockState, false);
            }
        }

    }

    @Override
    public void closeInventory(PlayerEntity playerEntity) {
        if (!playerEntity.isSpectator()) {
            --this.openCount;
        }

    }

    private void setOpenProperty(BlockState blockState, boolean open) {
        if (this.world != null) {
            this.world.setBlockState(this.getPos(), blockState.with(WoodenBarrelBlock.PROPERTY_OPEN, open), 3);
        }
    }

    private void playSoundEvent(BlockState blockState, SoundEvent soundEvent) {
        if (this.world != null) {
            Vec3i vec3i = blockState.get(WoodenBarrelBlock.PROPERTY_FACING).getDirectionVec();
            this.world.playSound(
                    null,
                    (double) this.pos.getX() + 0.5D + (double) vec3i.getX() / 2.0D,
                    (double) this.pos.getY() + 0.5D + (double) vec3i.getY() / 2.0D,
                    (double) this.pos.getZ() + 0.5D + (double) vec3i.getZ() / 2.0D,
                    soundEvent,
                    SoundCategory.BLOCKS,
                    0.5F,
                    this.world.rand.nextFloat() * 0.1F + 0.9F
            );
        }
    }

    @Override
    public WoodType getWoodType() {
        return ((IWooden) this.getBlockState().getBlock()).getWoodType();
    }
}

package yamahari.ilikewood.tilenentities;

import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IClearable;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.LecternContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import yamahari.ilikewood.blocks.WoodenLecternBlock;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;

@SuppressWarnings("NullableProblems")
public class WoodenLecternTileEntity extends TileEntity implements IClearable, INamedContainerProvider, IWooden {
    private ItemStack book;
    private int page;
    private int pages;
    private final IInventory lecternInventory = new IInventory() {
        @Override
        public int getSizeInventory() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return WoodenLecternTileEntity.this.book.isEmpty();
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
            return slot == 0 ? WoodenLecternTileEntity.this.book : ItemStack.EMPTY;
        }

        @Override
        public ItemStack decrStackSize(int slot, int amount) {
            if (slot == 0) {
                ItemStack itemStack = WoodenLecternTileEntity.this.book.split(amount);
                if (WoodenLecternTileEntity.this.book.isEmpty()) {
                    WoodenLecternTileEntity.this.reset();
                }

                return itemStack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        @Override
        public ItemStack removeStackFromSlot(int slot) {
            if (slot == 0) {
                ItemStack itemStack = WoodenLecternTileEntity.this.book;
                WoodenLecternTileEntity.this.book = ItemStack.EMPTY;
                WoodenLecternTileEntity.this.reset();
                return itemStack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        @Override
        public void setInventorySlotContents(int slot, ItemStack itemStack) {
        }

        @Override
        public int getInventoryStackLimit() {
            return 1;
        }

        @Override
        public void markDirty() {
            WoodenLecternTileEntity.this.markDirty();
        }

        @Override
        public boolean isUsableByPlayer(PlayerEntity playerEntity) {
            if (WoodenLecternTileEntity.this.world.getTileEntity(WoodenLecternTileEntity.this.pos) != WoodenLecternTileEntity.this) {
                return false;
            } else {
                return !(playerEntity.getDistanceSq((double) WoodenLecternTileEntity.this.pos.getX() + 0.5D, (double) WoodenLecternTileEntity.this.pos.getY() + 0.5D, (double) WoodenLecternTileEntity.this.pos.getZ() + 0.5D) > 64.0D) && WoodenLecternTileEntity.this.isWrittenOrWritable();
            }
        }

        @Override
        public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
            return false;
        }

        @Override
        public void clear() {
        }
    };
    private final IIntArray field_214049_b = new IIntArray() {
        @Override
        public int get(int i) {
            return i == 0 ? WoodenLecternTileEntity.this.page : 0;
        }

        @Override
        public void set(int i, int value) {
            if (i == 0) {
                WoodenLecternTileEntity.this.func_214035_a(value);
            }

        }

        @Override
        public int size() {
            return 1;
        }
    };

    public WoodenLecternTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
        this.book = ItemStack.EMPTY;
    }

    @Override
    public WoodType getWoodType() {
        return ((IWooden) this.getBlockState().getBlock()).getWoodType();
    }

    public ItemStack getBook() {
        return this.book;
    }

    public boolean isWrittenOrWritable() {
        Item item = this.book.getItem();
        return item == Items.WRITABLE_BOOK || item == Items.WRITTEN_BOOK;
    }

    public void func_214045_a(ItemStack p_214045_1_) {
        this.func_214040_a(p_214045_1_, null);
    }

    private void reset() {
        this.page = 0;
        this.pages = 0;
        WoodenLecternBlock.setHasBook(this.getWorld(), this.getPos(), this.getBlockState(), false);
    }

    public void func_214040_a(ItemStack itemStack, @Nullable PlayerEntity playerEntity) {
        this.book = this.func_214047_b(itemStack, playerEntity);
        this.page = 0;
        this.pages = WrittenBookItem.func_220049_j(this.book);
        this.markDirty();
    }

    private void func_214035_a(int p_214035_1_) {
        int lvt_2_1_ = MathHelper.clamp(p_214035_1_, 0, this.pages - 1);
        if (lvt_2_1_ != this.page) {
            this.page = lvt_2_1_;
            this.markDirty();
            WoodenLecternBlock.pulse(this.getWorld(), this.getPos(), this.getBlockState());
        }

    }

    public int getPage() {
        return this.page;
    }

    public int func_214034_r() {
        float lvt_1_1_ = this.pages > 1 ? (float) this.getPage() / ((float) this.pages - 1.0F) : 1.0F;
        return MathHelper.floor(lvt_1_1_ * 14.0F) + (this.isWrittenOrWritable() ? 1 : 0);
    }

    private ItemStack func_214047_b(ItemStack itemStack, @Nullable PlayerEntity playerEntity) {
        if (this.world instanceof ServerWorld && itemStack.getItem() == Items.WRITTEN_BOOK) {
            WrittenBookItem.resolveContents(itemStack, this.func_214039_a(playerEntity), playerEntity);
        }

        return itemStack;
    }

    private CommandSource func_214039_a(@Nullable PlayerEntity playerEntity) {
        String s;
        Object o;
        if (playerEntity == null) {
            s = "Lectern";
            o = new StringTextComponent("Lectern");
        } else {
            s = playerEntity.getName().getString();
            o = playerEntity.getDisplayName();
        }

        Vec3d vec3d = new Vec3d((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D);
        return new CommandSource(ICommandSource.field_213139_a_, vec3d, Vec2f.ZERO, (ServerWorld) this.world, 2, s, (ITextComponent) o, this.world.getServer(), playerEntity);
    }

    public void read(CompoundNBT compoundNBT) {
        super.read(compoundNBT);
        if (compoundNBT.contains("Book", 10)) {
            this.book = this.func_214047_b(ItemStack.read(compoundNBT.getCompound("Book")), null);
        } else {
            this.book = ItemStack.EMPTY;
        }

        this.pages = WrittenBookItem.func_220049_j(this.book);
        this.page = MathHelper.clamp(compoundNBT.getInt("Page"), 0, this.pages - 1);
    }

    public CompoundNBT write(CompoundNBT compoundNBT) {
        super.write(compoundNBT);
        if (!this.getBook().isEmpty()) {
            compoundNBT.put("Book", this.getBook().write(new CompoundNBT()));
            compoundNBT.putInt("Page", this.page);
        }

        return compoundNBT;
    }

    public void clear() {
        this.func_214045_a(ItemStack.EMPTY);
    }

    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new LecternContainer(id, this.lecternInventory, this.field_214049_b);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container." + this.getWoodType().getModId() + "." + this.getWoodType().getName() + "_lectern");
    }
}

package yamahari.ilikewood.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yamahari.ilikewood.objectholders.WoodenContainerTypes;

@SuppressWarnings("NullableProblems")
public class WoodenLecternContainer extends Container {
    private final IInventory inventory;
    private final IIntArray field_217019_d;

    public WoodenLecternContainer(int id) {
        this(id, new Inventory(1), new IntArray(1));
    }

    public WoodenLecternContainer(int id, IInventory lecternInventory, IIntArray p_i50076_3_) {
        super(WoodenContainerTypes.LECTERN, id);
        assertInventorySize(lecternInventory, 1);
        assertIntArraySize(p_i50076_3_, 1);
        this.inventory = lecternInventory;
        this.field_217019_d = p_i50076_3_;
        this.addSlot(new Slot(lecternInventory, 0, 0, 0) {
            public void onSlotChanged() {
                super.onSlotChanged();
                WoodenLecternContainer.this.onCraftMatrixChanged(this.inventory);
            }
        });
        this.trackIntArray(p_i50076_3_);
    }

    public boolean enchantItem(PlayerEntity playerEntity, int p_75140_2_) {
        int lvt_3_2_;
        if (p_75140_2_ >= 100) {
            lvt_3_2_ = p_75140_2_ - 100;
            this.updateProgressBar(0, lvt_3_2_);
            return true;
        } else {
            switch (p_75140_2_) {
                case 1:
                    lvt_3_2_ = this.field_217019_d.get(0);
                    this.updateProgressBar(0, lvt_3_2_ - 1);
                    return true;
                case 2:
                    lvt_3_2_ = this.field_217019_d.get(0);
                    this.updateProgressBar(0, lvt_3_2_ + 1);
                    return true;
                case 3:
                    if (!playerEntity.isAllowEdit()) {
                        return false;
                    }

                    ItemStack lvt_3_4_ = this.inventory.removeStackFromSlot(0);
                    this.inventory.markDirty();
                    if (!playerEntity.inventory.addItemStackToInventory(lvt_3_4_)) {
                        playerEntity.dropItem(lvt_3_4_, false);
                    }

                    return true;
                default:
                    return false;
            }
        }
    }

    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        super.updateProgressBar(p_75137_1_, p_75137_2_);
        this.detectAndSendChanges();
    }

    public boolean canInteractWith(PlayerEntity playerEntity) {
        return this.inventory.isUsableByPlayer(playerEntity);
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack getBook() {
        return this.inventory.getStackInSlot(0);
    }

    @OnlyIn(Dist.CLIENT)
    public int getPage() {
        return this.field_217019_d.get(0);
    }
}

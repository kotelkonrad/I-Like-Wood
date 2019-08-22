package yamahari.ilikewood.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yamahari.ilikewood.blocks.WoodenCraftingTableBlock;
import yamahari.ilikewood.objectholders.WoodenContainerTypes;

import java.util.Optional;

public class WoodenWorkbenchContainer extends RecipeBookContainer<CraftingInventory> {
    private final CraftingInventory craftingInventory;
    private final CraftResultInventory craftResultInventory;
    private final IWorldPosCallable worldPosCallable;
    private final PlayerEntity playerEntity;

    public WoodenWorkbenchContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, IWorldPosCallable.DUMMY);
    }

    public WoodenWorkbenchContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
        super(WoodenContainerTypes.WORKBENCH, id);
        this.craftingInventory = new CraftingInventory(this, 3, 3);
        this.craftResultInventory = new CraftResultInventory();
        this.worldPosCallable = worldPosCallable;
        this.playerEntity = playerInventory.player;
        this.addSlot(new CraftingResultSlot(playerInventory.player, this.craftingInventory, this.craftResultInventory, 0, 124, 35));

        int i;
        int j;
        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.craftingInventory, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

    }

    private static void getRecipeResult(int windowId, World world, PlayerEntity playerEntity, CraftingInventory craftingInventory, CraftResultInventory craftResultInventory) {
        if (!world.isRemote) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerEntity;
            ItemStack itemStack = ItemStack.EMPTY;

            Optional<ICraftingRecipe> optionalCraftingRecipe;
            MinecraftServer minecraftServer = world.getServer();
            optionalCraftingRecipe = minecraftServer != null ? minecraftServer.getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftingInventory, world) : Optional.empty();

            if (optionalCraftingRecipe.isPresent()) {
                ICraftingRecipe craftingRecipe = optionalCraftingRecipe.get();
                if (craftResultInventory.canUseRecipe(world, serverPlayerEntity, craftingRecipe)) {
                    itemStack = craftingRecipe.getCraftingResult(craftingInventory);
                }
            }

            craftResultInventory.setInventorySlotContents(0, itemStack);
            serverPlayerEntity.connection.sendPacket(new SSetSlotPacket(windowId, 0, itemStack));
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean canInteractWith(PlayerEntity playerEntity) {
        return worldPosCallable.applyOrElse((world, blockPos) -> world.getBlockState(blockPos).getBlock() instanceof WoodenCraftingTableBlock && playerEntity.getDistanceSq((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        this.worldPosCallable.consume((world, blockPos) -> getRecipeResult(this.windowId, world, this.playerEntity, this.craftingInventory, this.craftResultInventory));
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void func_201771_a(RecipeItemHelper recipeItemHelper) {
        this.craftingInventory.fillStackedContents(recipeItemHelper);
    }

    @Override
    public void clear() {
        this.craftingInventory.clear();
        this.craftResultInventory.clear();
    }

    @Override
    public boolean matches(IRecipe<? super CraftingInventory> recipe) {
        return recipe.matches(this.craftingInventory, this.playerEntity.world);
    }

    @Override
    public void onContainerClosed(PlayerEntity playerEntity) {
        super.onContainerClosed(playerEntity);
        this.worldPosCallable.consume((p_217068_2_, p_217068_3_) -> this.clearContainer(playerEntity, p_217068_2_, this.craftingInventory));
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerEntity, int slotId) {
        ItemStack itemStack0 = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotId);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack0 = itemStack1.copy();
            if (slotId == 0) {
                this.worldPosCallable.consume((world, blockPos) -> itemStack1.getItem().onCreated(itemStack1, world, playerEntity));
                if (!this.mergeItemStack(itemStack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemStack1, itemStack0);
            } else if (slotId >= 10 && slotId < 37) {
                if (!this.mergeItemStack(itemStack1, 37, 46, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotId >= 37 && slotId < 46) {
                if (!this.mergeItemStack(itemStack1, 10, 37, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemStack1.getCount() == itemStack0.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemStack2 = slot.onTake(playerEntity, itemStack1);
            if (slotId == 0) {
                playerEntity.dropItem(itemStack2, false);
            }
        }

        return itemStack0;
    }

    @Override
    public boolean canMergeSlot(ItemStack itemStack, Slot slot) {
        return slot.inventory != this.craftResultInventory && super.canMergeSlot(itemStack, slot);
    }

    @Override
    public int getOutputSlot() {
        return 0;
    }

    @Override
    public int getWidth() {
        return this.craftingInventory.getWidth();
    }

    @Override
    public int getHeight() {
        return this.craftingInventory.getHeight();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 10;
    }
}

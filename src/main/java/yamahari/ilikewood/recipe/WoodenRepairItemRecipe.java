package yamahari.ilikewood.recipe;

import com.google.common.collect.Lists;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.RepairItemRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import yamahari.ilikewood.items.tiered.WoodenTieredItem;

import java.util.List;

public class WoodenRepairItemRecipe extends RepairItemRecipe {
    public WoodenRepairItemRecipe(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    public boolean matches(CraftingInventory craftingInventory, World world) {
        List<ItemStack> list = Lists.newArrayList();

        for (int i = 0; i < craftingInventory.getSizeInventory(); ++i) {
            ItemStack itemStack = craftingInventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                Item item = itemStack.getItem();
                if (item instanceof WoodenTieredItem) {
                    list.add(itemStack);
                    if (list.size() > 1) {
                        ItemStack itemStack1 = list.get(0);
                        WoodenTieredItem tieredItem = (WoodenTieredItem) item;
                        WoodenTieredItem tieredItem1 = (WoodenTieredItem) itemStack1.getItem();
                        if (tieredItem.getWoodenTieredItemType() != tieredItem1.getWoodenTieredItemType() || tieredItem.getWoodenItemTier() != tieredItem1.getWoodenItemTier()
                                || itemStack1.getCount() != 1 || itemStack.getCount() != 1 || !itemStack1.isRepairable()) {
                            return false;
                        }
                    }
                }
            }
        }

        return list.size() == 2;
    }

    // TODO make your own serializer!!
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return super.getSerializer();
    }
}

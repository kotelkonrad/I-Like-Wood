package yamahari.ilikewood.objectholders;

import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.data.recipe.WoodenRepairItemRecipe;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenRecipeSerializers {
    @ObjectHolder("wooden_repair_item")
    public static final SpecialRecipeSerializer<WoodenRepairItemRecipe> REPAIR_ITEM = null;
}

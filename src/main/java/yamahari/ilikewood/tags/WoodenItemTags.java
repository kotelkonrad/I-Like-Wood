package yamahari.ilikewood.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import yamahari.ilikewood.util.Constants;

public class WoodenItemTags {
    public static final Tag<Item> SCAFFOLDINGS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "tags/items/scaffoldings"));
}

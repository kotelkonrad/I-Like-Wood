package yamahari.ilikewood.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import yamahari.ilikewood.util.Constants;

@SuppressWarnings("unused")
public class WoodenItemTags {
    public static final Tag<Item> BARRELS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "barrels"));
    public static final Tag<Item> BOOKSHELFS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "bookshelfs"));
    public static final Tag<Item> CHESTS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "chests"));
    public static final Tag<Item> COMPOSTERS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "composters"));
    public static final Tag<Item> CRAFTING_TABLES = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "crafting_tables"));
    public static final Tag<Item> LADDERS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "ladders"));
    public static final Tag<Item> PANELS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "panels"));
    public static final Tag<Item> POSTS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "posts"));
    public static final Tag<Item> SCAFFOLDINGS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "scaffoldings"));
    public static final Tag<Item> STICKS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "sticks"));
    public static final Tag<Item> STRIPPED_POSTS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "stripped_posts"));
    public static final Tag<Item> WALLS = new ItemTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "walls"));
}

package yamahari.ilikewood.tags;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import yamahari.ilikewood.util.Constants;

@SuppressWarnings("unused")
public class WoodenBlockTags {
    public static final Tag<Block> BARRELS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "barrels"));
    public static final Tag<Block> BOOKSHELFS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "bookshelfs"));
    public static final Tag<Block> CHESTS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "chests"));
    public static final Tag<Block> COMPOSTERS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "composters"));
    public static final Tag<Block> CRAFTING_TABLES = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "crafting_tables"));
    public static final Tag<Block> LADDERS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "ladders"));
    public static final Tag<Block> PANELS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "panels"));
    public static final Tag<Block> POSTS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "posts"));
    public static final Tag<Block> SCAFFOLDINGS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "scaffoldings"));
    public static final Tag<Block> STRIPPED_POSTS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "stripped_posts"));
    public static final Tag<Block> TORCHES = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "torches"));
    public static final Tag<Block> WALLS = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "walls"));
    public static final Tag<Block> WALL_TORCHES = new BlockTags.Wrapper(new ResourceLocation(Constants.MOD_ID, "wall_torches"));
}

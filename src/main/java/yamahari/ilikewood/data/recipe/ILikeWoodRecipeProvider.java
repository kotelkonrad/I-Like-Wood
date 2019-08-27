package yamahari.ilikewood.data.recipe;

import net.minecraft.advancements.criterion.EnterBlockTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.items.tier.WoodenHoeItem;
import yamahari.ilikewood.items.tier.WoodenSwordItem;
import yamahari.ilikewood.items.tier.tool.WoodenAxeItem;
import yamahari.ilikewood.items.tier.tool.WoodenPickaxeItem;
import yamahari.ilikewood.items.tier.tool.WoodenShovelItem;
import yamahari.ilikewood.objectholders.barrel.WoodenBarrelBlocks;
import yamahari.ilikewood.objectholders.bed.black.WoodenBlackBedBlocks;
import yamahari.ilikewood.objectholders.bed.blue.WoodenBlueBedBlocks;
import yamahari.ilikewood.objectholders.bed.brown.WoodenBrownBedBlocks;
import yamahari.ilikewood.objectholders.bed.cyan.WoodenCyanBedBlocks;
import yamahari.ilikewood.objectholders.bed.gray.WoodenGrayBedBlocks;
import yamahari.ilikewood.objectholders.bed.green.WoodenGreenBedBlocks;
import yamahari.ilikewood.objectholders.bed.light_blue.WoodenLightBlueBedBlocks;
import yamahari.ilikewood.objectholders.bed.light_gray.WoodenLightGrayBedBlocks;
import yamahari.ilikewood.objectholders.bed.lime.WoodenLimeBedBlocks;
import yamahari.ilikewood.objectholders.bed.magenta.WoodenMagentaBedBlocks;
import yamahari.ilikewood.objectholders.bed.orange.WoodenOrangeBedBlocks;
import yamahari.ilikewood.objectholders.bed.pink.WoodenPinkBedBlocks;
import yamahari.ilikewood.objectholders.bed.purple.WoodenPurpleBedBlocks;
import yamahari.ilikewood.objectholders.bed.red.WoodenRedBedBlocks;
import yamahari.ilikewood.objectholders.bed.white.WoodenWhiteBedBlocks;
import yamahari.ilikewood.objectholders.bed.yellow.WoodenYellowBedBlocks;
import yamahari.ilikewood.objectholders.bookshelf.WoodenBookshelfBlocks;
import yamahari.ilikewood.objectholders.chest.WoodenChestBlocks;
import yamahari.ilikewood.objectholders.composter.WoodenComposterBlocks;
import yamahari.ilikewood.objectholders.crafting_table.WoodenCraftingTableBlocks;
import yamahari.ilikewood.objectholders.ladder.WoodenLadderBlocks;
import yamahari.ilikewood.objectholders.lectern.WoodenLecternBlocks;
import yamahari.ilikewood.objectholders.log_pile.WoodenLogPileBlocks;
import yamahari.ilikewood.objectholders.panels.WoodenPanelsBlocks;
import yamahari.ilikewood.objectholders.panels.slab.WoodenPanelsSlabBlocks;
import yamahari.ilikewood.objectholders.panels.stairs.WoodenPanelsStairsBlocks;
import yamahari.ilikewood.objectholders.post.WoodenPostBlocks;
import yamahari.ilikewood.objectholders.scaffolding.WoodenScaffoldingBlocks;
import yamahari.ilikewood.objectholders.stick.WoodenStickItems;
import yamahari.ilikewood.objectholders.tiered.WoodenHoeItems;
import yamahari.ilikewood.objectholders.tiered.WoodenSwordItems;
import yamahari.ilikewood.objectholders.tiered.tools.WoodenAxeItems;
import yamahari.ilikewood.objectholders.tiered.tools.WoodenPickaxeItems;
import yamahari.ilikewood.objectholders.tiered.tools.WoodenShovelItems;
import yamahari.ilikewood.objectholders.torch.WoodenTorchBlocks;
import yamahari.ilikewood.objectholders.wall.WoodenWallBlocks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ILikeWoodRecipeProvider extends RecipeProvider {
    public ILikeWoodRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    private static IItemProvider getIngredient(String name, Class<?> objectHolder) {
        try {
            Field block = objectHolder.getDeclaredField(name);
            return (IItemProvider) block.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            ILikeWood.logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static Tag<Item> getIngredientTag(String name, Class<?> objectHolder) {
        try {
            Field tag = objectHolder.getDeclaredField(name);
            return (Tag<Item>) tag.get(null);
        } catch (NoSuchFieldException | IllegalAccessException | ClassCastException e) {
            ILikeWood.logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private EnterBlockTrigger.Instance enteredBlock(Block blockIn) {
        return new EnterBlockTrigger.Instance(blockIn, null);
    }

    private InventoryChangeTrigger.Instance hasItem(MinMaxBounds.IntBound amount, IItemProvider itemIn) {
        return this.hasItem(ItemPredicate.Builder.create().item(itemIn).count(amount).build());
    }

    private InventoryChangeTrigger.Instance hasItem(IItemProvider itemIn) {
        return this.hasItem(ItemPredicate.Builder.create().item(itemIn).build());
    }

    private InventoryChangeTrigger.Instance hasItem(Tag<Item> tagIn) {
        return this.hasItem(ItemPredicate.Builder.create().tag(tagIn).build());
    }

    private InventoryChangeTrigger.Instance hasItem(Ingredient ingredientIn) {
        return InventoryChangeTrigger.Instance.forItems(Arrays.stream(ingredientIn.getMatchingStacks()).map(ItemStack::getItem).toArray(Item[]::new));
    }

    private InventoryChangeTrigger.Instance hasItem(ItemPredicate... predicates) {
        return new InventoryChangeTrigger.Instance(MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, predicates);
    }

    @Override
    @ParametersAreNonnullByDefault
    @SuppressWarnings("ConstantConditions")
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        Stream.of(WoodenBarrelBlocks.ACACIA, WoodenBarrelBlocks.BIRCH, WoodenBarrelBlocks.DARK_OAK, WoodenBarrelBlocks.JUNGLE, WoodenBarrelBlocks.OAK, WoodenBarrelBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('P', ingredient).key('S', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsSlabBlocks.class)).patternLine("PSP").patternLine("P P").patternLine("PSP").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenChestBlocks.ACACIA, WoodenChestBlocks.BIRCH, WoodenChestBlocks.DARK_OAK, WoodenChestBlocks.JUNGLE, WoodenChestBlocks.OAK, WoodenChestBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("###").patternLine("# #").patternLine("###").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenLecternBlocks.ACACIA, WoodenLecternBlocks.BIRCH, WoodenLecternBlocks.DARK_OAK, WoodenLecternBlocks.JUNGLE, WoodenLecternBlocks.OAK, WoodenLecternBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('S', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsSlabBlocks.class)).key('B', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenBookshelfBlocks.class)).patternLine("SSS").patternLine(" B ").patternLine(" S ").addCriterion("has_book", this.hasItem(Items.BOOK)).build(consumer));

        Stream.of(WoodenBookshelfBlocks.ACACIA, WoodenBookshelfBlocks.BIRCH, WoodenBookshelfBlocks.DARK_OAK, WoodenBookshelfBlocks.JUNGLE, WoodenBookshelfBlocks.OAK, WoodenBookshelfBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).key('X', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenBookshelfBlocks.class)).patternLine("###").patternLine("XXX").patternLine("###").addCriterion("has_book", this.hasItem(Items.BOOK)).build(consumer));

        Stream.of(WoodenComposterBlocks.ACACIA, WoodenComposterBlocks.BIRCH, WoodenComposterBlocks.DARK_OAK, WoodenComposterBlocks.JUNGLE, WoodenComposterBlocks.OAK, WoodenComposterBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase() + "_FENCE", Blocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('F', ingredient).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("F F").patternLine("F F").patternLine("###").addCriterion("has_fence", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenLadderBlocks.ACACIA, WoodenLadderBlocks.BIRCH, WoodenLadderBlocks.DARK_OAK, WoodenLadderBlocks.JUNGLE, WoodenLadderBlocks.OAK, WoodenLadderBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenStickItems.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('I', ingredient).patternLine("I I").patternLine("III").patternLine("I I").addCriterion("has_stick", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenScaffoldingBlocks.ACACIA, WoodenScaffoldingBlocks.BIRCH, WoodenScaffoldingBlocks.DARK_OAK, WoodenScaffoldingBlocks.JUNGLE, WoodenScaffoldingBlocks.OAK, WoodenScaffoldingBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenStickItems.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('I', ingredient).key('~', Items.STRING).patternLine("I~I").patternLine("I I").patternLine("I I").addCriterion("has_stick", this.hasItem(ingredient)).build(consumer);
                });

        // TODO FIX EMPTY TAG
        Stream.of(WoodenWallBlocks.ACACIA, WoodenWallBlocks.BIRCH, WoodenWallBlocks.DARK_OAK, WoodenWallBlocks.JUNGLE, WoodenWallBlocks.OAK, WoodenWallBlocks.SPRUCE)
                .forEach(block -> {
                    final Tag<Item> ingredient = getIngredientTag(block.getWoodType().getName().toUpperCase() + "_LOGS", ItemTags.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 6).key('#', ingredient).patternLine("###").patternLine("###").addCriterion("has_log", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPostBlocks.ACACIA, WoodenPostBlocks.BIRCH, WoodenPostBlocks.DARK_OAK, WoodenPostBlocks.JUNGLE, WoodenPostBlocks.OAK, WoodenPostBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase() + "_LOG", Blocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 6).key('#', ingredient).patternLine("#").patternLine("#").patternLine("#").addCriterion("has_log", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenCraftingTableBlocks.ACACIA, WoodenCraftingTableBlocks.BIRCH, WoodenCraftingTableBlocks.DARK_OAK, WoodenCraftingTableBlocks.JUNGLE, WoodenCraftingTableBlocks.OAK, WoodenCraftingTableBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("##").patternLine("##").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenLogPileBlocks.ACACIA, WoodenLogPileBlocks.BIRCH, WoodenLogPileBlocks.DARK_OAK, WoodenLogPileBlocks.JUNGLE, WoodenLogPileBlocks.OAK, WoodenLogPileBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPostBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("##").patternLine("##").addCriterion("has_post", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenBlackBedBlocks.ACACIA, WoodenBlackBedBlocks.BIRCH, WoodenBlackBedBlocks.DARK_OAK, WoodenBlackBedBlocks.JUNGLE, WoodenBlackBedBlocks.OAK, WoodenBlackBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.BLACK_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.BLACK_WOOL)).build(consumer));

        Stream.of(WoodenBlueBedBlocks.ACACIA, WoodenBlueBedBlocks.BIRCH, WoodenBlueBedBlocks.DARK_OAK, WoodenBlueBedBlocks.JUNGLE, WoodenBlueBedBlocks.OAK, WoodenBlueBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.BLUE_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.BLUE_WOOL)).build(consumer));

        Stream.of(WoodenBrownBedBlocks.ACACIA, WoodenBrownBedBlocks.BIRCH, WoodenBrownBedBlocks.DARK_OAK, WoodenBrownBedBlocks.JUNGLE, WoodenBrownBedBlocks.OAK, WoodenBrownBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.BROWN_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.BROWN_WOOL)).build(consumer));

        Stream.of(WoodenCyanBedBlocks.ACACIA, WoodenCyanBedBlocks.BIRCH, WoodenCyanBedBlocks.DARK_OAK, WoodenCyanBedBlocks.JUNGLE, WoodenCyanBedBlocks.OAK, WoodenCyanBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.CYAN_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.CYAN_WOOL)).build(consumer));

        Stream.of(WoodenGrayBedBlocks.ACACIA, WoodenGrayBedBlocks.BIRCH, WoodenGrayBedBlocks.DARK_OAK, WoodenGrayBedBlocks.JUNGLE, WoodenGrayBedBlocks.OAK, WoodenGrayBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.GRAY_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.GRAY_WOOL)).build(consumer));

        Stream.of(WoodenGreenBedBlocks.ACACIA, WoodenGreenBedBlocks.BIRCH, WoodenGreenBedBlocks.DARK_OAK, WoodenGreenBedBlocks.JUNGLE, WoodenGreenBedBlocks.OAK, WoodenGreenBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.GREEN_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.GREEN_WOOL)).build(consumer));

        Stream.of(WoodenLightBlueBedBlocks.ACACIA, WoodenLightBlueBedBlocks.BIRCH, WoodenLightBlueBedBlocks.DARK_OAK, WoodenLightBlueBedBlocks.JUNGLE, WoodenLightBlueBedBlocks.OAK, WoodenLightBlueBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.LIGHT_BLUE_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.LIGHT_BLUE_WOOL)).build(consumer));

        Stream.of(WoodenLightGrayBedBlocks.ACACIA, WoodenLightGrayBedBlocks.BIRCH, WoodenLightGrayBedBlocks.DARK_OAK, WoodenLightGrayBedBlocks.JUNGLE, WoodenLightGrayBedBlocks.OAK, WoodenLightGrayBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.LIGHT_GRAY_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.LIGHT_GRAY_WOOL)).build(consumer));

        Stream.of(WoodenLimeBedBlocks.ACACIA, WoodenLimeBedBlocks.BIRCH, WoodenLimeBedBlocks.DARK_OAK, WoodenLimeBedBlocks.JUNGLE, WoodenLimeBedBlocks.OAK, WoodenLimeBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.LIME_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.LIME_WOOL)).build(consumer));

        Stream.of(WoodenMagentaBedBlocks.ACACIA, WoodenMagentaBedBlocks.BIRCH, WoodenMagentaBedBlocks.DARK_OAK, WoodenMagentaBedBlocks.JUNGLE, WoodenMagentaBedBlocks.OAK, WoodenMagentaBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.MAGENTA_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.MAGENTA_WOOL)).build(consumer));

        Stream.of(WoodenOrangeBedBlocks.ACACIA, WoodenOrangeBedBlocks.BIRCH, WoodenOrangeBedBlocks.DARK_OAK, WoodenOrangeBedBlocks.JUNGLE, WoodenOrangeBedBlocks.OAK, WoodenOrangeBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.ORANGE_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.ORANGE_WOOL)).build(consumer));

        Stream.of(WoodenPinkBedBlocks.ACACIA, WoodenPinkBedBlocks.BIRCH, WoodenPinkBedBlocks.DARK_OAK, WoodenPinkBedBlocks.JUNGLE, WoodenPinkBedBlocks.OAK, WoodenPinkBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.PINK_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.PINK_WOOL)).build(consumer));

        Stream.of(WoodenPurpleBedBlocks.ACACIA, WoodenPurpleBedBlocks.BIRCH, WoodenPurpleBedBlocks.DARK_OAK, WoodenPurpleBedBlocks.JUNGLE, WoodenPurpleBedBlocks.OAK, WoodenPurpleBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.PURPLE_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.PURPLE_WOOL)).build(consumer));

        Stream.of(WoodenRedBedBlocks.ACACIA, WoodenRedBedBlocks.BIRCH, WoodenRedBedBlocks.DARK_OAK, WoodenRedBedBlocks.JUNGLE, WoodenRedBedBlocks.OAK, WoodenRedBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.RED_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.RED_WOOL)).build(consumer));

        Stream.of(WoodenWhiteBedBlocks.ACACIA, WoodenWhiteBedBlocks.BIRCH, WoodenWhiteBedBlocks.DARK_OAK, WoodenWhiteBedBlocks.JUNGLE, WoodenWhiteBedBlocks.OAK, WoodenWhiteBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.WHITE_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.WHITE_WOOL)).build(consumer));

        Stream.of(WoodenYellowBedBlocks.ACACIA, WoodenYellowBedBlocks.BIRCH, WoodenYellowBedBlocks.DARK_OAK, WoodenYellowBedBlocks.JUNGLE, WoodenYellowBedBlocks.OAK, WoodenYellowBedBlocks.SPRUCE)
                .forEach(block -> ShapedRecipeBuilder.shapedRecipe(block).key('X', Items.YELLOW_WOOL).key('#', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class)).patternLine("XXX").patternLine("###").addCriterion("has_wool", this.hasItem(Items.YELLOW_WOOL)).build(consumer));

        Stream.of(WoodenPanelsBlocks.ACACIA, WoodenPanelsBlocks.BIRCH, WoodenPanelsBlocks.DARK_OAK, WoodenPanelsBlocks.JUNGLE, WoodenPanelsBlocks.OAK, WoodenPanelsBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase() + "_SLAB", Blocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("#").patternLine("#").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPanelsStairsBlocks.ACACIA, WoodenPanelsStairsBlocks.BIRCH, WoodenPanelsStairsBlocks.DARK_OAK, WoodenPanelsStairsBlocks.JUNGLE, WoodenPanelsStairsBlocks.OAK, WoodenPanelsStairsBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 4).key('#', ingredient).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPanelsSlabBlocks.ACACIA, WoodenPanelsSlabBlocks.BIRCH, WoodenPanelsSlabBlocks.DARK_OAK, WoodenPanelsSlabBlocks.JUNGLE, WoodenPanelsSlabBlocks.OAK, WoodenPanelsSlabBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 6).key('#', ingredient).patternLine("###").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenStickItems.ACACIA, WoodenStickItems.BIRCH, WoodenStickItems.DARK_OAK, WoodenStickItems.JUNGLE, WoodenStickItems.OAK, WoodenStickItems.SPRUCE)
                .forEach(item -> {
                    final IItemProvider ingredient = getIngredient(item.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(item, 4).key('#', ingredient).patternLine("#").patternLine("#").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenTorchBlocks.ACACIA, WoodenTorchBlocks.BIRCH, WoodenTorchBlocks.DARK_OAK, WoodenTorchBlocks.JUNGLE, WoodenTorchBlocks.OAK, WoodenTorchBlocks.SPRUCE)
                .forEach(block -> {
                    final IItemProvider ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenStickItems.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 4).key('#', Ingredient.fromItems(Items.COAL, Items.CHARCOAL)).key('I', ingredient).patternLine("#").patternLine("I").addCriterion("has_coal", this.hasItem(Ingredient.fromItems(Items.COAL, Items.CHARCOAL))).build(consumer);
                });

        Arrays.stream(WoodenAxeItems.class.getDeclaredFields())
                .forEach(field -> {
                    try {
                        final WoodenAxeItem axe = (WoodenAxeItem) field.get(null);
                        final Ingredient ingredient = axe.getWoodenItemTier().getRepairMaterial();
                        ShapedRecipeBuilder.shapedRecipe(axe).key('#', ingredient).key('I', getIngredient(axe.getWoodType().getName().toUpperCase(), WoodenStickItems.class)).patternLine("##").patternLine("#I").patternLine(" I").addCriterion("has_repair_material", this.hasItem(ingredient)).build(consumer);
                    } catch (IllegalAccessException | ClassCastException e) {
                        ILikeWood.logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                });

        Arrays.stream(WoodenPickaxeItems.class.getDeclaredFields())
                .forEach(field -> {
                    try {
                        final WoodenPickaxeItem pickaxe = (WoodenPickaxeItem) field.get(null);
                        final Ingredient ingredient = pickaxe.getWoodenItemTier().getRepairMaterial();
                        ShapedRecipeBuilder.shapedRecipe(pickaxe).key('#', ingredient).key('I', getIngredient(pickaxe.getWoodType().getName().toUpperCase(), WoodenStickItems.class)).patternLine("###").patternLine(" I ").patternLine(" I ").addCriterion("has_repair_material", this.hasItem(ingredient)).build(consumer);
                    } catch (IllegalAccessException | ClassCastException e) {
                        ILikeWood.logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                });

        Arrays.stream(WoodenShovelItems.class.getDeclaredFields())
                .forEach(field -> {
                    try {
                        final WoodenShovelItem shovel = (WoodenShovelItem) field.get(null);
                        final Ingredient ingredient = shovel.getWoodenItemTier().getRepairMaterial();
                        ShapedRecipeBuilder.shapedRecipe(shovel).key('#', ingredient).key('I', getIngredient(shovel.getWoodType().getName().toUpperCase(), WoodenStickItems.class)).patternLine("#").patternLine("I").patternLine("I").addCriterion("has_repair_material", this.hasItem(ingredient)).build(consumer);
                    } catch (IllegalAccessException | ClassCastException e) {
                        ILikeWood.logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                });

        Arrays.stream(WoodenSwordItems.class.getDeclaredFields())
                .forEach(field -> {
                    try {
                        final WoodenSwordItem sword = (WoodenSwordItem) field.get(null);
                        final Ingredient ingredient = sword.getWoodenItemTier().getRepairMaterial();
                        ShapedRecipeBuilder.shapedRecipe(sword).key('#', ingredient).key('I', getIngredient(sword.getWoodType().getName().toUpperCase(), WoodenStickItems.class)).patternLine("#").patternLine("#").patternLine("I").addCriterion("has_repair_material", this.hasItem(ingredient)).build(consumer);
                    } catch (IllegalAccessException | ClassCastException e) {
                        ILikeWood.logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                });

        Arrays.stream(WoodenHoeItems.class.getDeclaredFields())
                .forEach(field -> {
                    try {
                        final WoodenHoeItem hoe = (WoodenHoeItem) field.get(null);
                        final Ingredient ingredient = hoe.getWoodenItemTier().getRepairMaterial();
                        ShapedRecipeBuilder.shapedRecipe(hoe).key('#', ingredient).key('I', getIngredient(hoe.getWoodType().getName().toUpperCase(), WoodenStickItems.class)).patternLine("##").patternLine(" I").patternLine(" I").addCriterion("has_repair_material", this.hasItem(ingredient)).build(consumer);
                    } catch (IllegalAccessException | ClassCastException e) {
                        ILikeWood.logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                });
    }
}

package yamahari.ilikewood.data;

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
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.objectholders.barrel.WoodenBarrelBlocks;
import yamahari.ilikewood.objectholders.chest.WoodenChestBlocks;
import yamahari.ilikewood.objectholders.panels.WoodenPanelsBlocks;
import yamahari.ilikewood.objectholders.panels.slab.WoodenPanelsSlabBlocks;
import yamahari.ilikewood.objectholders.panels.stairs.WoodenPanelsStairsBlocks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ILikeWoodRecipeProvider extends RecipeProvider {
    public ILikeWoodRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    private static Block getIngredient(String name, Class<?> objectHolder) {
        try {
            Field block = objectHolder.getDeclaredField(name);
            return (Block) block.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            ILikeWood.logger.error(objectHolder.toString() + " has no field called " + name);
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

    private InventoryChangeTrigger.Instance hasItem(ItemPredicate... predicates) {
        return new InventoryChangeTrigger.Instance(MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, predicates);
    }

    @Override
    @ParametersAreNonnullByDefault
    @SuppressWarnings("ConstantConditions")
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        Stream.of(WoodenBarrelBlocks.ACACIA, WoodenBarrelBlocks.BIRCH, WoodenBarrelBlocks.DARK_OAK, WoodenBarrelBlocks.JUNGLE, WoodenBarrelBlocks.OAK, WoodenBarrelBlocks.SPRUCE)
                .forEach(block -> {
                    Block ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('P', ingredient).key('S', getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsSlabBlocks.class)).patternLine("PSP").patternLine("P P").patternLine("PSP").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenChestBlocks.ACACIA, WoodenChestBlocks.BIRCH, WoodenChestBlocks.DARK_OAK, WoodenChestBlocks.JUNGLE, WoodenChestBlocks.OAK, WoodenChestBlocks.SPRUCE)
                .forEach(block -> {
                    Block ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("###").patternLine("# #").patternLine("###").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPanelsBlocks.ACACIA, WoodenPanelsBlocks.BIRCH, WoodenPanelsBlocks.DARK_OAK, WoodenPanelsBlocks.JUNGLE, WoodenPanelsBlocks.OAK, WoodenPanelsBlocks.SPRUCE)
                .forEach(block -> {
                    Block ingredient = getIngredient(block.getWoodType().getName().toUpperCase() + "_SLAB", Blocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block).key('#', ingredient).patternLine("#").patternLine("#").addCriterion("has_planks", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPanelsStairsBlocks.ACACIA, WoodenPanelsStairsBlocks.BIRCH, WoodenPanelsStairsBlocks.DARK_OAK, WoodenPanelsStairsBlocks.JUNGLE, WoodenPanelsStairsBlocks.OAK, WoodenPanelsStairsBlocks.SPRUCE)
                .forEach(block -> {
                    Block ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 4).key('#', ingredient).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });

        Stream.of(WoodenPanelsSlabBlocks.ACACIA, WoodenPanelsSlabBlocks.BIRCH, WoodenPanelsSlabBlocks.DARK_OAK, WoodenPanelsSlabBlocks.JUNGLE, WoodenPanelsSlabBlocks.OAK, WoodenPanelsSlabBlocks.SPRUCE)
                .forEach(block -> {
                    Block ingredient = getIngredient(block.getWoodType().getName().toUpperCase(), WoodenPanelsBlocks.class);
                    ShapedRecipeBuilder.shapedRecipe(block, 6).key('#', ingredient).patternLine("###").addCriterion("has_panels", this.hasItem(ingredient)).build(consumer);
                });
    }
}

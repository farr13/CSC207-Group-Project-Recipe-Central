package backend.entity;

import java.util.*;

/** Cookbook class, an entity which represents cookbooks that store recipes. They have a name,
 * and a list of recipe objects that are stored in them. */
@SuppressWarnings("ClassCanBeRecord")
public class Cookbook implements Iterable<Recipe> {
    private final String name;
    private final Recipe[] recipes;
    /** Initializes a new Cookbook Object.
     * @param name name of this recipe
     * @param recipes list containing the recipes in this cookbook */
    public Cookbook(String name, Recipe[] recipes) {
        this.name = name;
        this.recipes = recipes;
    }
    /** Returns the name of this Cookbook Object.
     * @return String */
    public String getName() {
        return name;
    }
    /** Returns the list of recipes in this Cookbook Object.
     * @return Recipe[] */
    public Recipe[] getRecipes() {
        return recipes;
    }
    /** Checks if an input object is the same as this Cookbook Object.
     * @param o Object
     * @return boolean */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cookbook){
            ArrayList<Recipe> recipeArrayList = new ArrayList<Recipe>(Arrays.asList(recipes)),
                    oArrayList = new ArrayList<Recipe>(Arrays.asList(((Cookbook) o).getRecipes()));
            return Objects.equals(((Cookbook) o).getName(), name) &&
                    oArrayList.containsAll(recipeArrayList) && recipeArrayList.containsAll(oArrayList);
        }
        return false;
    }

    /** Generates a Java iterator for indexing over recipes in the Cookbook Object.
     * @return Iterator</Recipe> */
    @Override
    public Iterator<Recipe> iterator() {
        return new CookbookItr();
    }
    private class CookbookItr implements Iterator<Recipe> {
        private int currIndex;
        @Override
        public boolean hasNext() {
            return currIndex < recipes.length;
        }
        @Override
        public Recipe next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           Recipe currRecipe = recipes[currIndex];
           currIndex += 1;
           return currRecipe;
        }
    }
}

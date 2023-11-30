package backend.entity;

import java.util.*;

public class Cookbook implements Iterable<Recipe>{

    private final String name;

    private Recipe[] recipes;

    public Cookbook(String name, Recipe[] recipes){
        this.name = name;
        this.recipes = recipes;
    }

    public String getName() {
        return name;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

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

    @Override
    public Iterator<Recipe> iterator() {
        return new CookbookItr();
    }

    private class CookbookItr implements Iterator<Recipe>{
        private int currindex;
        @Override
        public boolean hasNext() {
            return currindex < recipes.length;
        }

        @Override
        public Recipe next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           Recipe currRecipe = recipes[currindex];
           currindex += 1;
           return currRecipe;
        }
    }
}

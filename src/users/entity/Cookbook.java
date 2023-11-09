package users.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cookbook implements Iterable<Recipe>{

    private final String name;

    private ArrayList<Recipe> Recipes = new ArrayList<Recipe>();

    Cookbook(String name, ArrayList<Recipe> Recipes){
        this.name = name;
        this.Recipes = Recipes;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }

    @Override
    public Iterator<Recipe> iterator() {
        return new CookbookItr();
    }

    private class CookbookItr implements Iterator<Recipe>{
        private int currindex;
        @Override
        public boolean hasNext() {
            return currindex < Recipes.size();
        }

        @Override
        public Recipe next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           Recipe currRecipe = Recipes.get(currindex);
           currindex += 1;
           return currRecipe;
        }
    }
}

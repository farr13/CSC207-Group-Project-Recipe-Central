package backend.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Cookbook implements Iterable<Recipe>{

    private final String name;

    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public Cookbook(String name, ArrayList<Recipe> Recipes){
        this.name = name;
        this.recipes = Recipes;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cookbook){
            return Objects.equals(((Cookbook) o).getName(), name) &&
                    Objects.equals(((Cookbook)o).getRecipes(), recipes);
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
            return currindex < recipes.size();
        }

        @Override
        public Recipe next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           Recipe currRecipe = recipes.get(currindex);
           currindex += 1;
           return currRecipe;
        }
    }
}

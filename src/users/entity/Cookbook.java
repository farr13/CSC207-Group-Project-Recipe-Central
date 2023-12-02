package users.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Cookbook implements Iterable<Recipe> {

    private String name;
    private ArrayList<Recipe> recipes;

    public Cookbook(String name, ArrayList<Recipe> recipes) {
        this.name = name;
        this.recipes = new ArrayList<>(recipes);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = newName;
    }

    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipes); // Return a copy of the recipes list
    }

    public boolean removeRecipe(String recipeName) {
        boolean removed = recipes.removeIf(recipe -> recipe.getName().equals(recipeName));
        if (!removed) {
            throw new NoSuchElementException("Recipe with name '" + recipeName + "' not found.");
        }
        return true;
    }

    @Override
    public Iterator<Recipe> iterator() {
        return new CookbookIterator();
    }

    private class CookbookIterator implements Iterator<Recipe> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < recipes.size();
        }

        @Override
        public Recipe next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more recipes in the cookbook.");
            }
            return recipes.get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }

    @Override
    public String toString() {
        return "Cookbook{" +
                "name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookbook cookbook = (Cookbook) o;
        return name.equals(cookbook.name) &&
                Objects.equals(recipes, cookbook.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recipes);
    }
}
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
        return recipes.removeIf(recipe -> recipe.getName().equals(recipeName));
    }

    @Override
    public Iterator<Recipe> iterator() {
        return recipes.iterator();
    }

    @Override
    public String toString() {
        return "Cookbook{" +
                "name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    // Optional: Override equals and hashCode if needed
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

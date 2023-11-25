package users.entity;

import java.util.ArrayList;

public class CookbookFactory {

    public static Cookbook createCookbook(String name, ArrayList<Recipe> recipes) {
        return new Cookbook(name, recipes);
    }

    public static Cookbook createEmptyCookbook(String name) {
        return new Cookbook(name, new ArrayList<>());
    }
}

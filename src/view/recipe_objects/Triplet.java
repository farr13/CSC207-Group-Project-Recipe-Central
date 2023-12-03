package view.recipe_objects;

import java.util.ArrayList;

public class Triplet {
    private final String name;
    private final String link;
    private final String[] list;

    public Triplet(String first, String second, String[] third) {
        this.name = first;
        this.link = second;
        this.list = third;
    }
    public String getName() {
        return name;
    }
    public String getLink() {
        return link;
    }
    public String[] getList() {
        return list;
    }
}

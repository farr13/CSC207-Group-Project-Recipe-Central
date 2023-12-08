package view.recipe_objects;
public class Triplet {
    private final String name;
    private final String link;
    private final String[] list;
    public Triplet(String name, String link, String[] list) {
        this.name = name;
        this.link = link;
        this.list = list;
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

package backend.service.view_cookbook;

import backend.entity.Cookbook;

public class ViewCookbookOutputData {
    private final Cookbook cookbook;

    public ViewCookbookOutputData(Cookbook cookbook){this.cookbook = cookbook;}

    public Cookbook getCookbook() {return cookbook;}
}

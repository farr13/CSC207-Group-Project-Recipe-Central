package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public class SeeListCookbooksOutputData {
    private final Cookbook[] cookbookNames;

    public SeeListCookbooksOutputData(Cookbook[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }

    public Cookbook[] getNames() {return cookbookNames;}
}

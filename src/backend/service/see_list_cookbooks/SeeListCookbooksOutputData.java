package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public class SeeListCookbooksOutputData {
    private final Cookbook[] cookbooks;

    public SeeListCookbooksOutputData(Cookbook[] cookbooks) {
        this.cookbooks = cookbooks;
    }

    public Cookbook[] getCookbooks() {return cookbooks;}
}

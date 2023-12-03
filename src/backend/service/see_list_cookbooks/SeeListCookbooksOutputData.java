package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public class SeeListCookbooksOutputData {
    private final String[] cookbookNames;

    public SeeListCookbooksOutputData(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }

    public String[] getCookbookNames() {return cookbookNames;}
}

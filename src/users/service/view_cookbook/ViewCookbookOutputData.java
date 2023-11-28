package users.service.view_cookbook;

import users.entity.Cookbook;

public class ViewCookbookOutputData {
    private Cookbook[] cookbooks;

    public ViewCookbookOutputData(Cookbook[] cookbooks){
        this.cookbooks = cookbooks;
    }
}

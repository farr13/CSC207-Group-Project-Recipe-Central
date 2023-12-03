package backend.service.make_cookbook;

import backend.entity.Cookbook;

public class MakeCookbookOutputData {
    private final Cookbook[] cookbooks;

    public MakeCookbookOutputData(Cookbook[] cookbooks) {
        this.cookbooks = cookbooks;
    }

    public Cookbook[] getCookbooks() {
        return cookbooks;
    }
}

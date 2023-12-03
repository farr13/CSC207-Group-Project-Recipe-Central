package backend.service.make_cookbook;

import backend.entity.Cookbook;

public class MakeCookbookOutputData {
    private final String[] cookbookNames;

    public MakeCookbookOutputData(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }

    public String[] getCookbookNames() {
        return cookbookNames;
    }
}

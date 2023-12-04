package backend.service.delete_cookbook;

import backend.entity.Cookbook;

public class DeleteCookbookOutputData {

    private final String[] cookbooksNames;

    public DeleteCookbookOutputData(String[] cookbooksNames) {
        this.cookbooksNames = cookbooksNames;
    }

    public String[] getCookbookNames() {
        return cookbooksNames;
    }
}

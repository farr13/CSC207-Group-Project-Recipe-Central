package backend.service.delete_cookbook;

import backend.entity.Cookbook;

public class DeleteCookbookOutputData {

    private final Cookbook[] storedCookbooks;

    public DeleteCookbookOutputData(Cookbook[] storedCookbooks) {
        this.storedCookbooks = storedCookbooks;
    }

    public Cookbook[] getStoredCookbooks() {
        return storedCookbooks;
    }
}

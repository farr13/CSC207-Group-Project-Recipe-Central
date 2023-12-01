package backend.service.delete_cookbook;

import backend.entity.Cookbook;

import java.util.ArrayList;

public class DeleteCookbookInputData {
    final private String[] storedCookbooks;

    public DeleteCookbookInputData(String[] storedCookbooks){
        this.storedCookbooks = storedCookbooks;
    }

    String[] getStoredCookbooks() {
        return storedCookbooks;
    }
}

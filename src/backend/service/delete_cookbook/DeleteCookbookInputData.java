package backend.service.delete_cookbook;

import backend.entity.Cookbook;

import java.util.ArrayList;

public class DeleteCookbookInputData {
    final private String[] cookbookNames;

    public DeleteCookbookInputData(String[] cookbookNames){
        this.cookbookNames = cookbookNames;
    }

    public String[] getCookbookName() {
        return cookbookNames;
    }
}

package backend.service.rename_cookbook.DAI;

import backend.entity.Cookbook;

public interface RenameCookbookViewDAI {
    public Cookbook viewCookbook(String cookbookName) throws Exception;
}

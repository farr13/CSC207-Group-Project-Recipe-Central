package backend.service.view_cookbook;

import backend.entity.Cookbook;

public interface ViewCookbookViewDAI {
    public Cookbook viewCookbook(String cookbookName) throws Exception;
}

package backend.data_access_interfaces;

import backend.entity.Cookbook;

public interface ViewCookbookDAI {
    public Cookbook viewCookbook(String cookbookName) throws Exception;
}

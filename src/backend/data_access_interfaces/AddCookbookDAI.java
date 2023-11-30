package backend.data_access_interfaces;

import backend.entity.Cookbook;

public interface AddCookbookDAI {
    public void addCookbook(Cookbook cookbook) throws Exception;
}

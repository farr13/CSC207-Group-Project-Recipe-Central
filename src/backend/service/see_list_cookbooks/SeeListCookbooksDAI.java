package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public interface SeeListCookbooksDAI {
    public Cookbook[] viewCookbooks() throws Exception;
}

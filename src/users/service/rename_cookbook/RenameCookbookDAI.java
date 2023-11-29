package users.service.rename_cookbook;

import java.io.IOException;

public interface RenameCookbookDAI {
    void renameCookbook(String oldName, String newName) throws IOException;
}

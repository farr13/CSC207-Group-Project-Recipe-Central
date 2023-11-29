package users.service.rename_cookbook;

public class RenameCookbookInputData {
    private final String oldName;
    private final String newName;

    public RenameCookbookInputData(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public String getOldName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }
}

package backend.service.delete_cookbook;

public class DeleteCookbookOutputData {

    private final String[] deletedCookbookNames;

    public DeleteCookbookOutputData(String[] deletedCookbookNames) {
        this.deletedCookbookNames = deletedCookbookNames;
    }

    public String[] getDeletedCookbookName() {
        return deletedCookbookNames;
    }
}

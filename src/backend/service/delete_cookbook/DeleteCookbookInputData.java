package backend.service.delete_cookbook;

public class DeleteCookbookInputData {
    final private String[] storedCookbooks;
    public DeleteCookbookInputData(String[] storedCookbooks) {
        this.storedCookbooks = storedCookbooks;
    }
    String[] getStoredCookbooks() {
        return storedCookbooks;
    }
}

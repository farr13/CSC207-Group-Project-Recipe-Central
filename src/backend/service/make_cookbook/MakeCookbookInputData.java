package backend.service.make_cookbook;

public class MakeCookbookInputData {
    private final String newCookbookName;
    public MakeCookbookInputData(String newCookbookName) {
        this.newCookbookName = newCookbookName;
    }
    String getNewCookbookName() {
        return newCookbookName;
    }
}

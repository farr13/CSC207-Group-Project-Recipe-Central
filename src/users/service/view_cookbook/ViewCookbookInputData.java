package users.service.view_cookbook;

public class ViewCookbookInputData {
    private String cookbookName;

    public ViewCookbookInputData(String cookbookName) {
        this.cookbookName = cookbookName;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName;
    }

}

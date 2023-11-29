package users.service.rename_cookbook;

public class RenameCookbookInputData {

    private final String cookbookName;

    public RenameCookbookInputData(String cookbookName){
        this.cookbookName = cookbookName;
    }

    String getCookbookname() {return cookbookName;}
}

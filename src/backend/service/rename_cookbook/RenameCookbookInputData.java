package backend.service.rename_cookbook;

public class RenameCookbookInputData {

    private final String cookbookNameNew, cookbookNameOld;

    public RenameCookbookInputData(String cookbookNameNew, String cookbookNameOld){
        this.cookbookNameOld = cookbookNameOld;
        this.cookbookNameNew = cookbookNameNew;
    }
    public String getCookbookNameNew() {return cookbookNameNew;}
    public String getCookbookNameOld() {return cookbookNameOld;}
}

package backend.service.see_list_cookbooks;

public class SeeListCookbooksOutputData {
    private final String[] cookbookNames;
    public SeeListCookbooksOutputData(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }
    public String[] getCookbookNames() {return cookbookNames;}
}

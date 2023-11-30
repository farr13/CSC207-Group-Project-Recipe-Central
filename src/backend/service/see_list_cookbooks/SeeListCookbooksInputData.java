package backend.service.see_list_cookbooks;

public class SeeListCookbooksInputData {

    final private String[] cookbookNames;

    public SeeListCookbooksInputData(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }

    String[] getNames() {return cookbookNames;}
}

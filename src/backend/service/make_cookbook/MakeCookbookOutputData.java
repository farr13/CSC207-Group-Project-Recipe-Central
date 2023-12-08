package backend.service.make_cookbook;

public class MakeCookbookOutputData {
    private final String[] cookbookNames;
    public MakeCookbookOutputData(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }
    public String[] getCookbookNames() {
        return cookbookNames;
    }
}

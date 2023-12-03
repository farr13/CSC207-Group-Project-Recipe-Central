package view.states;

public class CookbookListState {
    private String[] cookbookNames = new String[]{};
    public CookbookListState(CookbookListState copy){
        this.cookbookNames = copy.getCookbookNames();
    }
    public CookbookListState(){}

    public void setCookbookNames(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }

    public String[] getCookbookNames() {
        return cookbookNames;
    }
}

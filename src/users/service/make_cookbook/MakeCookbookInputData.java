package users.service.make_cookbook;

public class MakeCookbookInputData {

    private final String title;
    public MakeCookbookInputData(String cookbookTitle) {
        this.title = cookbookTitle;
    }
    String getCookbookTitle() {return title;}
}

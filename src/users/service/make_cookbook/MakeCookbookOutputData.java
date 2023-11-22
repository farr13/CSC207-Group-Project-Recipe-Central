package users.service.make_cookbook;
public class MakeCookbookOutputData {
    private final String title;
    private final boolean useCaseFailed;

    public MakeCookbookOutputData(String title, boolean useCaseFailed) {
        this.title = title;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle(){return title;}
}

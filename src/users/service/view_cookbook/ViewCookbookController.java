package users.service.view_cookbook;

public class ViewCookbookController{
    private ViewCookbookInputBoundary viewCookbookInputBoundary;

    public ViewCookbookController(ViewCookbookInputBoundary viewCookbookInputBoundary){
        this.viewCookbookInputBoundary = viewCookbookInputBoundary;
    }
    public void execute(){
        ViewCookbookInputData viewCookbookInputData = new ViewCookbookInputData();
        viewCookbookInputBoundary.execute(viewCookbookInputData);
    }
}

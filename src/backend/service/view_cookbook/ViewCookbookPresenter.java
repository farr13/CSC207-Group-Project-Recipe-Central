package backend.service.view_cookbook;

public class ViewCookbookPresenter implements ViewCookbookOutputBoundary {
    public void prepareSuccessView(ViewCookbookOutputData viewCookbookOutputData){
        System.out.println(viewCookbookOutputData.getCookbook().getName());
    }
}

package backend.service.view_cookbook;

public class ViewCookbookPresenter implements ViewCookbookOutputBoundary {
    @Override
    public void prepareSuccessView(ViewCookbookOutputData viewCookbookOutputData){
        System.out.println(viewCookbookOutputData.getCookbook().getName());
    }

    @Override
    public void prepareFailView() {

    }
}

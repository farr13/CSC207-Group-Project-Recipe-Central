package backend.service.add_recipe;


import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

public class AddRecipePresenter implements AddRecipeOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddRecipeViewModel addRecipeViewModel;

    public AddRecipePresenter(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel){
        this.addRecipeViewModel = addRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView() {
        System.out.println("Success");
    }
}

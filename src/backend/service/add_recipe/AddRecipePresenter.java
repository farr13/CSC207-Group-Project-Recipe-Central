package backend.service.add_recipe;


import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

public class AddRecipePresenter {
    private final ViewManagerModel viewManagerModel;

    private final MainMenuViewModel mainMenuViewModel;

    public AddRecipePresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel){
        this.mainMenuViewModel = mainMenuViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareSuccessView(AddRecipeOutputData response) {
    }
}

package app;

import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import backend.service.delete_recipe.DeleteRecipeController;
import backend.service.delete_recipe.DeleteRecipeDAI;
import backend.service.delete_recipe.DeleteRecipeInteractor;
import backend.service.delete_recipe.DeleteRecipePresenter;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.see_list_cookbooks.SeeListCookbooksInteractor;
import backend.service.see_list_cookbooks.SeeListCookbooksPresenter;
import backend.service.view_cookbook.ViewCookbookViewDAI;
import data_access.DeleteCookbookDAO;
import view.usecase_views.OpenCookbookView;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.OpenCookbookViewModel;

public class OpenCookbookViewUseCaseFactory {
    private OpenCookbookViewUseCaseFactory(){}

    public static OpenCookbookView create(ViewManagerModel viewManagerModel, OpenCookbookViewModel openCookbookViewModel,
                                          CookbookListViewModel cookbookListViewModel, MainMenuViewModel mainMenuViewModel,
                                          SeeListCookbooksDAI viewCookbookDAO, DeleteRecipeDAI deleteRecipeDAO){
        DeleteRecipeController deleteRecipeController = OpenCookbookViewUseCaseFactory.createDeleteRecipeUseCase(deleteRecipeDAO);
        SeeListCookbooksController seeListCookbooksController = OpenCookbookViewUseCaseFactory.createSeeListCookbooksUseCase(viewManagerModel,
                cookbookListViewModel, viewCookbookDAO);
        return new OpenCookbookView(mainMenuViewModel, openCookbookViewModel, cookbookListViewModel, seeListCookbooksController,deleteRecipeController);
    }

    private static DeleteRecipeController createDeleteRecipeUseCase(DeleteRecipeDAI deleteRecipeDAO){
        DeleteRecipePresenter deleteCookbookPresenter = new DeleteRecipePresenter();
        DeleteRecipeInteractor deleteRecipeInteractor = new DeleteRecipeInteractor(deleteRecipeDAO, deleteCookbookPresenter);
        DeleteRecipeController deleteRecipeController = new DeleteRecipeController(deleteRecipeInteractor);
        return deleteRecipeController;
    }

    private static SeeListCookbooksController createSeeListCookbooksUseCase(ViewManagerModel viewManagerModel,
                                                                            CookbookListViewModel cookbookListViewModel,
                                                                            SeeListCookbooksDAI viewCookbookDAO){
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter(viewManagerModel, cookbookListViewModel);
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(viewCookbookDAO, seeListCookbooksPresenter);
        SeeListCookbooksController seeListCookbooksController = new SeeListCookbooksController(seeListCookbooksInteractor);
        return seeListCookbooksController;
    }
}

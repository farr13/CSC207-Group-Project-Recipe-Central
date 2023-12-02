package app;

import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import backend.service.view_cookbook.ViewCookbookDAI;
import view.usecase_views.CookbookListView;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

public class CookbookListUseCaseFactory {
    public CookbookListUseCaseFactory(){}

    public static CookbookListView create(CookbookListViewModel cookbookListViewModel, ViewManagerModel viewManagerModel,
                                          MainMenuViewModel mainMenuViewModel, ViewCookbookDAI viewCookbookDAO,
                                          DeleteCookbookDAI deleteCookbookDAO){
        ViewCookbookController viewCookbookController = CookbookListUseCaseFactory.createViewCookbookUsecase(viewCookbookDAO);
        DeleteCookbookController deleteCookbookController = CookbookListUseCaseFactory.createDeleteCookbookUsecase(deleteCookbookDAO);
        return new CookbookListView(cookbookListViewModel, viewManagerModel, mainMenuViewModel, viewCookbookController, deleteCookbookController);
    }
    private static ViewCookbookController createViewCookbookUsecase(ViewCookbookDAI viewCookbookDAO){
        ViewCookbookPresenter viewCookbookPresenter = new ViewCookbookPresenter();
        ViewCookbookInteractor viewCookbookInteractor = new ViewCookbookInteractor(viewCookbookDAO, viewCookbookPresenter);
        return new ViewCookbookController(viewCookbookInteractor);
    }
    private static DeleteCookbookController createDeleteCookbookUsecase(DeleteCookbookDAI deleteCookbookDAO){
        DeleteCookbookPresenter deleteCookbookPresenter = new DeleteCookbookPresenter();
        DeleteCookbookInteractor deleteCookbookInteractor = new DeleteCookbookInteractor(deleteCookbookDAO, deleteCookbookPresenter);
        return new DeleteCookbookController(deleteCookbookInteractor);
    }
}

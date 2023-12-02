package app;

import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookDeleteDAI;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import backend.service.view_cookbook.ViewCookbookViewDAI;
import view.usecase_views.CookbookListView;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

public class CookbookListUseCaseFactory {
    public CookbookListUseCaseFactory(){}

    public static CookbookListView create(CookbookListViewModel cookbookListViewModel, ViewManagerModel viewManagerModel,
                                          MainMenuViewModel mainMenuViewModel, ViewCookbookViewDAI viewCookbookDAO,
                                          DeleteCookbookDeleteDAI deleteCookbookDAO){
        ViewCookbookController viewCookbookController = CookbookListUseCaseFactory.createViewCookbookUsecase(viewCookbookDAO);
        DeleteCookbookController deleteCookbookController = CookbookListUseCaseFactory.createDeleteCookbookUsecase(deleteCookbookDAO);
        return new CookbookListView(cookbookListViewModel, viewManagerModel, mainMenuViewModel, viewCookbookController, deleteCookbookController);
    }
    private static ViewCookbookController createViewCookbookUsecase(ViewCookbookViewDAI viewCookbookDAO){
        ViewCookbookPresenter viewCookbookPresenter = new ViewCookbookPresenter();
        ViewCookbookInteractor viewCookbookInteractor = new ViewCookbookInteractor(viewCookbookDAO, viewCookbookPresenter);
        ViewCookbookController viewCookbookController = new ViewCookbookController(viewCookbookInteractor);
        return viewCookbookController;
    }
    private static DeleteCookbookController createDeleteCookbookUsecase(DeleteCookbookDeleteDAI deleteCookbookDAO){
        DeleteCookbookPresenter deleteCookbookPresenter = new DeleteCookbookPresenter();
        DeleteCookbookInteractor deleteCookbookInteractor = new DeleteCookbookInteractor(deleteCookbookDAO, deleteCookbookPresenter);
        DeleteCookbookController deleteCookbookController = new DeleteCookbookController(deleteCookbookInteractor);
        return deleteCookbookController;
    }
}

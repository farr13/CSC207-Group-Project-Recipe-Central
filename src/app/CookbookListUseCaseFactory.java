package app;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInteractor;
import backend.service.back_to_menu.BackToMenuPresenter;
import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookDAI;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import view.usecase_views.CookbookListView;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.OpenCookbookViewModel;

public class CookbookListUseCaseFactory {
    private CookbookListUseCaseFactory(){}

    public static CookbookListView create(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel,
                                          CookbookListViewModel cookbookListViewModel, OpenCookbookViewModel openCookbookViewModel,
                                          ViewCookbookDAI viewCookbookDAO, DeleteCookbookDAI deleteCookbookDAO){
        ViewCookbookController viewCookbookController = CookbookListUseCaseFactory.createViewCookbookUsecase(viewManagerModel,
                cookbookListViewModel, openCookbookViewModel, viewCookbookDAO);
        DeleteCookbookController deleteCookbookController = CookbookListUseCaseFactory.createDeleteCookbookUsecase(viewManagerModel,
                cookbookListViewModel, deleteCookbookDAO, (SeeListCookbooksDAI) viewCookbookDAO);
        BackToMenuController backToMenuController = CookbookListUseCaseFactory.createBackToMenuUsecase(viewManagerModel, mainMenuViewModel);
        return new CookbookListView(cookbookListViewModel, viewCookbookController, deleteCookbookController, backToMenuController);
    }
    private static ViewCookbookController createViewCookbookUsecase(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel,
                                                                    OpenCookbookViewModel openCookbookViewModel,ViewCookbookDAI viewCookbookDAO){
        ViewCookbookPresenter viewCookbookPresenter = new ViewCookbookPresenter(viewManagerModel, openCookbookViewModel, cookbookListViewModel);
        ViewCookbookInteractor viewCookbookInteractor = new ViewCookbookInteractor(viewCookbookDAO, viewCookbookPresenter);
        ViewCookbookController viewCookbookController = new ViewCookbookController(viewCookbookInteractor);
        return viewCookbookController;
    }
    private static DeleteCookbookController createDeleteCookbookUsecase(ViewManagerModel viewManagerModel,
                                                                        CookbookListViewModel cookbookListViewModel,
                                                                        DeleteCookbookDAI deleteCookbookDAO,
                                                                        SeeListCookbooksDAI viewCookbookDAO){
        DeleteCookbookPresenter deleteCookbookPresenter = new DeleteCookbookPresenter(viewManagerModel, cookbookListViewModel);
        DeleteCookbookInteractor deleteCookbookInteractor = new DeleteCookbookInteractor(deleteCookbookDAO, viewCookbookDAO,
                deleteCookbookPresenter);
        DeleteCookbookController deleteCookbookController = new DeleteCookbookController(deleteCookbookInteractor);
        return deleteCookbookController;
    }
    private static BackToMenuController createBackToMenuUsecase(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel){
        BackToMenuPresenter backToMenuPresenter = new BackToMenuPresenter(viewManagerModel, mainMenuViewModel);
        BackToMenuInteractor backToMenuInteractor = new BackToMenuInteractor(backToMenuPresenter);
        BackToMenuController backToMenuController = new BackToMenuController(backToMenuInteractor);
        return backToMenuController;
    }
}

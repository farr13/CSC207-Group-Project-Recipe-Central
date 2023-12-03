package app;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.go_add_cookbook.GoAddCookbookController;
import backend.service.make_cookbook.MakeCookbookAddDAI;
import backend.service.make_cookbook.MakeCookbookController;
import backend.service.make_cookbook.MakeCookbookInteractor;
import backend.service.make_cookbook.MakeCookbookPresenter;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.see_list_cookbooks.SeeListCookbooksInteractor;
import backend.service.see_list_cookbooks.SeeListCookbooksPresenter;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookDAI;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import view.usecase_views.AddCookbookView;
import view.usecase_views.CookbookListView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.OpenCookbookViewModel;

public class AddCookbookUseCaseFactory {
    private AddCookbookUseCaseFactory(){}

    public static AddCookbookView create(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel,
                                          AddCookbookViewModel addCookbookViewModel, MakeCookbookAddDAI addCookbookDAO,
                                          SeeListCookbooksDAI seeListCookbooksDAO){
        MakeCookbookController makeCookbookController = AddCookbookUseCaseFactory.createMakeCookbookUsecase(viewManagerModel,
                cookbookListViewModel, addCookbookViewModel, addCookbookDAO, seeListCookbooksDAO);
        SeeListCookbooksController seeListCookbooksController = AddCookbookUseCaseFactory.createSeeListCookbooksUseCase(viewManagerModel,
                cookbookListViewModel, seeListCookbooksDAO);
        return new AddCookbookView(viewManagerModel, addCookbookViewModel, makeCookbookController, seeListCookbooksController);
    }

    private static MakeCookbookController createMakeCookbookUsecase(ViewManagerModel viewManagerModel,
                                                                    CookbookListViewModel cookbookListViewModel,
                                                                    AddCookbookViewModel addCookbookViewModel,
                                                                    MakeCookbookAddDAI addCookbookDAO,
                                                                    SeeListCookbooksDAI seeListCookbooksDAO){
        MakeCookbookPresenter makeCookbookPresenter = new MakeCookbookPresenter(viewManagerModel, cookbookListViewModel, addCookbookViewModel);
        MakeCookbookInteractor makeCookbookInteractor = new MakeCookbookInteractor(addCookbookDAO, seeListCookbooksDAO, makeCookbookPresenter);
        return new MakeCookbookController(makeCookbookInteractor);
    }

    private static SeeListCookbooksController createSeeListCookbooksUseCase(ViewManagerModel viewManagerModel,
                                                                            CookbookListViewModel cookbookListViewModel,
                                                                            SeeListCookbooksDAI seeListCookbooksDAO){
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter(viewManagerModel, cookbookListViewModel);
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(seeListCookbooksDAO, seeListCookbooksPresenter);
        SeeListCookbooksController seeListCookbooksController = new SeeListCookbooksController(seeListCookbooksInteractor);
        return seeListCookbooksController;
    }
}

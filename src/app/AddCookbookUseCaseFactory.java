package app;

import backend.service.make_cookbook.*;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.see_list_cookbooks.SeeListCookbooksInteractor;
import backend.service.see_list_cookbooks.SeeListCookbooksPresenter;
import view.usecase_views.AddCookbookView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;
import view.view_models.CookbookListViewModel;

public class AddCookbookUseCaseFactory {
    private AddCookbookUseCaseFactory(){}

    public static AddCookbookView create(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel,
                                          AddCookbookViewModel addCookbookViewModel, MakeCookbookAddDAI addCookbookDAO,
                                          SeeListCookbooksDAI seeListCookbooksDAO){
        MakeCookbookController makeCookbookController = AddCookbookUseCaseFactory.createMakeCookbookUseCase(viewManagerModel,
                cookbookListViewModel, addCookbookViewModel, addCookbookDAO, seeListCookbooksDAO);
        SeeListCookbooksController seeListCookbooksController = AddCookbookUseCaseFactory.createSeeListCookbooksUseCase(viewManagerModel,
                cookbookListViewModel, seeListCookbooksDAO);
        return new AddCookbookView(viewManagerModel, addCookbookViewModel, makeCookbookController, seeListCookbooksController);
    }

    private static MakeCookbookController createMakeCookbookUseCase(ViewManagerModel viewManagerModel,
                                                                    CookbookListViewModel cookbookListViewModel,
                                                                    AddCookbookViewModel addCookbookViewModel,
                                                                    MakeCookbookAddDAI addCookbookDAO,
                                                                    SeeListCookbooksDAI seeListCookbooksDAO){
        MakeCookbookPresenter makeCookbookPresenter = new MakeCookbookPresenter(viewManagerModel, cookbookListViewModel, addCookbookViewModel);
        MakeCookbookInteractor makeCookbookInteractor = new MakeCookbookInteractor(addCookbookDAO, (MakeCookbookViewDAI) seeListCookbooksDAO, makeCookbookPresenter);
        return new MakeCookbookController(makeCookbookInteractor);
    }

    private static SeeListCookbooksController createSeeListCookbooksUseCase(ViewManagerModel viewManagerModel,
                                                                            CookbookListViewModel cookbookListViewModel,
                                                                            SeeListCookbooksDAI seeListCookbooksDAO){
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter(viewManagerModel, cookbookListViewModel);
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(seeListCookbooksDAO, seeListCookbooksPresenter);
        return new SeeListCookbooksController(seeListCookbooksInteractor);
    }
}

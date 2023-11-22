package users.service.make_cookbook;

import users.service.make_cookbook.MakeCookbookInputBoundary;
import users.service.make_cookbook.MakeCookbookInputData;

public class MakeCookbookController {

    final MakeCookbookInputBoundary makeCookbookUseCaseInteractor;

    public MakeCookbookController(MakeCookbookInputBoundary makeCookbookUseCaseInteractor) {
        this.makeCookbookUseCaseInteractor = makeCookbookUseCaseInteractor;
    }

    public void execute(String title) {
        MakeCookbookInputData makeCookbookInputData = new MakeCookbookInputData(title);

        makeCookbookUseCaseInteractor.execute(makeCookbookInputData);
    }
}
